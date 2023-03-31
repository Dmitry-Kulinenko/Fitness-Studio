package by.itacademy.fitness.controller.user;

import by.itacademy.fitness.core.user.dto.UserDTO;
import by.itacademy.fitness.core.user.dto.UserLoginDTO;
import by.itacademy.fitness.core.user.dto.UserRegistrationDTO;
import by.itacademy.fitness.service.user.api.IUserPersonalAccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserPersonalAccountController {
    private final IUserPersonalAccountService userPersonalAccountService;

    public UserPersonalAccountController(IUserPersonalAccountService userPersonalAccountService) {
        this.userPersonalAccountService = userPersonalAccountService;
    }

    @PostMapping("/registration")
    public ResponseEntity<String> register(@RequestBody UserRegistrationDTO userRegistration) {
        userPersonalAccountService.register(userRegistration);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/verification")
    public ResponseEntity<String> verifyCode(@RequestParam String code,
                                             @RequestParam String mail) {

        userPersonalAccountService.verify(code, mail);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserLoginDTO userLogin) {
//
//        if (!userDataService.isActivated(userLogin.getMail())) {
//            throw new BadCredentialsException(userLogin.getMail()
//                    + " mail address has not been verified!");
//        }
        String jwtToken = userPersonalAccountService.login(userLogin);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(jwtToken);
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getPersonalData() {
        UserDTO userData = userPersonalAccountService.getPersonalData();
        return ResponseEntity.ok(userData);
    }
}
