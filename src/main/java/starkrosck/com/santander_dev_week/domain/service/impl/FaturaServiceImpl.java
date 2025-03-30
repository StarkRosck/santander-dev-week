package starkrosck.com.santander_dev_week.domain.service.impl;

import org.springframework.stereotype.Service;
import starkrosck.com.santander_dev_week.domain.model.Fatura;
import starkrosck.com.santander_dev_week.domain.model.User;
import starkrosck.com.santander_dev_week.domain.repository.FaturaRepository;
import starkrosck.com.santander_dev_week.domain.repository.UserRepository;
import starkrosck.com.santander_dev_week.domain.service.FaturaService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FaturaServiceImpl implements FaturaService {

    private final FaturaRepository faturaRepository;
    private final UserRepository userRepository;

    public FaturaServiceImpl(FaturaRepository faturaRepository, UserRepository userRepository) {
        this.faturaRepository = faturaRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Fatura findById(Long id) {
        return faturaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Fatura não encontrada com ID: " + id));
    }

    @Override
    public List<Fatura> findAll() {
        return faturaRepository.findAll();
    }

    @Override
    public Fatura create(Fatura fatura) {
        Long userId = fatura.getUsuario().getId();

        User usuario = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado com ID: " + userId));

        fatura.setUsuario(usuario);
        return faturaRepository.save(fatura);
    }


    @Override
    public void delete(Long id) {
        faturaRepository.deleteById(id);
    }

    @Override
    public Fatura update(Fatura fatura) {
        if (!faturaRepository.existsById(fatura.getId())) {
            throw new NoSuchElementException("Fatura não encontrada para atualizar.");
        }
        return faturaRepository.save(fatura);
    }
}
