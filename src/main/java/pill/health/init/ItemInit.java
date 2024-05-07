package pill.health.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pill.health.dto.ItemFormDto;
import pill.health.entity.item.Item;
import pill.health.service.ItemService;

@Component
@RequiredArgsConstructor
public class ItemInit {
    private final ItemService itemService;

    @PostConstruct
    public void init() {
        ItemFormDto item = new ItemFormDto("탈모약", 50000, 100, "ㅎㅎ");
        itemService.save(item);
    }
}
