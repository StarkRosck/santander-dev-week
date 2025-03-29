package starkrosck.com.santander_dev_week.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import starkrosck.com.santander_dev_week.domain.model.User;
import starkrosck.com.santander_dev_week.domain.service.UserService;

import java.net.URI;

import static org.springframework.web.servlet.function.RequestPredicates.path;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // Construtor
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate) throws IllegalAccessException {
        var userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }


}
