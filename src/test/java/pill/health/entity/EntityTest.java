package pill.health.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pill.health.dto.MemberFormDto;
import pill.health.entity.member.Member;
import pill.health.service.ItemService;
import pill.health.service.MemberService;
import pill.health.service.OrderService;

@SpringBootTest
@Transactional

public class EntityTest {

    @Autowired
    MemberService memberService;
    @Autowired
    ItemService itemService;
    @Autowired
    OrderService orderService;

    @Test
    void saveEntity() {
        memberService.save(new MemberFormDto("1", "1", "1", "1", "1", "1", "1", "1"));

    }
}
