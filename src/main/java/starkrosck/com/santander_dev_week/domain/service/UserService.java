package starkrosck.com.santander_dev_week.domain.service;

import starkrosck.com.santander_dev_week.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate) throws IllegalAccessException;

    User delete(Long id) throws  IllegalAccessException;

    User update(User userToUpdate) throws  IllegalAccessException;
}
