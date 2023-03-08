package apptive.team1.friendly.domain.user.controller;

import apptive.team1.friendly.domain.user.data.dto.RequestSignUp;
import apptive.team1.friendly.domain.user.data.dto.ResponseSignUp;
import apptive.team1.friendly.domain.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * User signup api
     */
    @PostMapping("/signup")
    public ResponseEntity<ResponseSignUp> signup(@Valid @RequestBody RequestSignUp requestSignUp) {
        ResponseSignUp responseSignUp = userService.signUp(requestSignUp);

        return new ResponseEntity<>(responseSignUp, HttpStatus.OK);
    }
}
