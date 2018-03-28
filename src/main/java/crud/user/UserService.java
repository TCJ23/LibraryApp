package crud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(Long id){
        userRepository.delete(id);
    }

    public User createUser(CreateUserDto createUserDto) {
        Objects.requireNonNull(createUserDto);
        User user = new User(createUserDto.getName());
        return userRepository.save(user);
    }

    public Iterable<User> findAllUsers(){
        Iterable<User> users = userRepository.findAll();
        return users;
    }
    
    public User updateUser(Long id, UpdateUserDto updateUserDto){
        Objects.requireNonNull(updateUserDto);
        User user = userRepository.findOne(id);
        user.setFirstname(updateUserDto.getFirstname());
        user.setLastname(updateUserDto.getLastname());
        user.setEmail(updateUserDto.getEmail());
        user.setUsername(updateUserDto.getUsername());
        return userRepository.save(user);
    }
    public User findUser(Long id) {
        Objects.requireNonNull(id);
        return userRepository.findOne(id);
    }
}

