
package by.itacademy.fitness.controller.user;

import by.itacademy.fitness.core.user.dto.UserCreateUpdateDTO;
import by.itacademy.fitness.core.user.dto.UserDTO;
import by.itacademy.fitness.service.user.api.IUserManagementService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserManagementController {
    private IUserManagementService service;

    public UserManagementController(IUserManagementService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity addUser(@Valid @RequestBody UserCreateUpdateDTO user) {
        service.add(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping
    public Page<UserDTO> getUserPage(Pageable pageable) {
        return service.getPage(pageable);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserDTO> getUserData(@PathVariable UUID uuid) {
        return ResponseEntity.ok(service.get(uuid));
    }

    @PutMapping("/{uuid}/dt_update/{lastUpdated}")
    public ResponseEntity<Integer> updateUser(@PathVariable UUID uuid,
                                              @PathVariable LocalDateTime lastUpdated,
                                              @RequestBody @Valid UserCreateUpdateDTO user) {
        service.update(uuid, lastUpdated, user);
        return ResponseEntity.ok().build();
    }
}