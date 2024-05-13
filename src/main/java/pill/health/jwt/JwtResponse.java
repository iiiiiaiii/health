package pill.health.jwt;

import lombok.Getter;

@Getter
public class JwtResponse {

    private final String JwtToken;

    public JwtResponse(String jwtToken) {
        JwtToken = jwtToken;
    }
}
