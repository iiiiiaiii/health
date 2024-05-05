package pill.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pill.health.entity.item.Item;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
}
