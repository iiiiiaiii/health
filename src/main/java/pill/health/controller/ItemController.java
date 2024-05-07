package pill.health.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pill.health.dto.ItemListDto;
import pill.health.service.ItemService;

import java.util.List;
import org.springframework.ui.Model;


@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items")
    public String itemList(Model model,@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);

        List<ItemListDto> itemListDtos = itemService.itemListDtoList(pageable);

        System.out.println("itemListDtos = " + itemListDtos);
        model.addAttribute("itemListDtos", itemListDtos);
        return "item/itemList";
    }
}
