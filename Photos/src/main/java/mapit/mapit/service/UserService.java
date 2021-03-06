package mapit.mapit.service;

import lombok.AllArgsConstructor;
import mapit.mapit.exception.UserNotFoundException;
import mapit.mapit.model.dao.UserEntity;
import mapit.mapit.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public UserEntity addUser(UserEntity addUser) {
        addUser.setLevel(0);
        return userRepo.save(addUser);
    }

    public List<UserEntity> findAllUsers(){
        return userRepo.findAll();
    }

    public UserEntity updateUser(UserEntity user) {
        return userRepo.save(user);
    }

    public UserEntity findUserById(Long id) {
        return userRepo.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " was not found"));
    }

   /*public UserEntity findUserByUsername(String username) {
        return userRepo.findUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username " + username + " was not found"));
    }*/

    public void deleteUser(Long id) {
        userRepo.deleteUserById(id);
    }
}
