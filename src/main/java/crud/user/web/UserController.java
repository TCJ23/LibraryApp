package crud.user.web;

import crud.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    User getUser(@PathVariable Long id) {return userService.findUser(id);}

    @GetMapping
    Iterable<User> getUsers() {
        return userService.findAllUsers();
    }

    @PostMapping
    ResponseEntity creatUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(userService.createUser(createUserDto));
    }

    @PutMapping("/{id}")
    ResponseEntity updateUser(@PathVariable Long id, @RequestBody UpdateUserDto updateUserDto) {
        userService.updateUser(id, updateUserDto);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
