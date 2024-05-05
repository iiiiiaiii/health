package pill.health.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pill.health.dto.ItemFormDto;
import pill.health.entity.item.Item;
import pill.health.repository.ItemRepository;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void save(ItemFormDto itemForm) {
        Item item = new Item(
                itemForm.getName(),
                itemForm.getPrice(),
                itemForm.getStock(),
                itemForm.getEtc()
        );
        itemRepository.save(item);
    }

    @Transactional
    public void delete(Item item) {
        itemRepository.delete(item);
    }


}
