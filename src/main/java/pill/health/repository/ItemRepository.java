package pill.health.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pill.health.dto.ItemListDto;
import pill.health.entity.item.Item;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {

    @Query("select new pill.health.dto.ItemListDto(i.name, i.price, i.stock, i.etc)" +
            " from Item i")
    List<ItemListDto> itemList(Pageable pageable);
}
