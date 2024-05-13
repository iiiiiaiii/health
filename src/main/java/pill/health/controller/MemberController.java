package pill.health.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;


@Controller
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/member/{memberId}")
    public String memberHome(@RequestParam("memberId") UUID memberId) {
        return "memberHome";
    }
}
