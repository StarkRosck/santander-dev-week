package starkrosck.com.santander_dev_week.domain.service.impl;

import org.springframework.stereotype.Service;
import starkrosck.com.santander_dev_week.domain.model.User;
import starkrosck.com.santander_dev_week.domain.repository.UserRepository;
import starkrosck.com.santander_dev_week.domain.service.UserService;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public User delete(Long id) {
        User userToDelete = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado com ID: " + id));

        userRepository.delete(userToDelete);
        return userToDelete;
    }

    @Override
    public User update(User updateToUser) {
        User existingUser = userRepository.findById(updateToUser.getId())
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado com ID: " + updateToUser.getId()));

        // Só atualiza se vier valor novo
        if (updateToUser.getName() != null) {
            existingUser.setName(updateToUser.getName());
        }
        if (updateToUser.getEmail() != null) {
            existingUser.setEmail(updateToUser.getEmail());
        }
        if (updateToUser.getTelefone() != null) {
            existingUser.setTelefone(updateToUser.getTelefone());
        }
        if (updateToUser.getCcreation() != null) {
            existingUser.setCcreation(updateToUser.getCcreation());
        }
        if (updateToUser.getAccount() != null) {
            existingUser.setAccount(updateToUser.getAccount());
        }
        if (updateToUser.getCard() != null) {
            existingUser.setCard(updateToUser.getCard());
        }
        if (updateToUser.getFeatures() != null) {
            existingUser.setFeatures(updateToUser.getFeatures());
        }
        if (updateToUser.getNews() != null) {
            existingUser.setNews(updateToUser.getNews());
        }

        return userRepository.save(existingUser);
    }



}
