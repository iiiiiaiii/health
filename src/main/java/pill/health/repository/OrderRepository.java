package pill.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pill.health.entity.order.OrderBase;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderBase, UUID> {
}
