package by.itacademy.fitness.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserPersonalAccountController {
//
//    @PostMapping("/registration")
//    public ResponseEntity<String> register(@RequestBody UserRegistrationDTO userRegistration) {
//
//        this.userAuthenticationService.register(userRegistration);
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .build();
//    }
//    @GetMapping("/verification")
//    public ResponseEntity<String> verifyCode(@RequestParam String code,
//                                             @RequestParam String mail) {
//
//        this.userAuthenticationService.verify(code, mail);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@Valid @RequestBody UserLoginDTO userLogin) {
//
//        if (!this.userDataService.isActivated(userLogin.getMail())) {
//            throw new BadCredentialsException(userLogin.getMail()
//                    + " mail address has not been verified!");
//        }
//        String jwtToken = this.userAuthenticationService.login(userLogin);
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(jwtToken);
//    }
//
//    @GetMapping("/me")
//    public ResponseEntity<UserDTO> getPersonalData() {
//
//        UserDTO userData = this.userAuthenticationService.getPersonalData();
//        return ResponseEntity.ok(userData);
//    }
}
