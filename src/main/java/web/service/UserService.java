package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    User get(Long id);

    List<User> getList();

    void update(User user);

    void delete(User user);
}
