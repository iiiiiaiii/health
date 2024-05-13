package pill.health.controller;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pill.health.jwt.JwtRequest;
import pill.health.jwt.JwtResponse;
import pill.health.jwt.JwtUtil;
import pill.health.service.CustomUserDetailService;
import pill.health.service.MemberService;


@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {


    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    private final CustomUserDetailService customUserDetailService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception{


        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword())
            );

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = customUserDetailService.loadUserByUsername(jwtRequest.getUsername());
        final String jwt = jwtUtil.createJwt(userDetails.getUsername(), "USER", 60 * 60L);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
}
