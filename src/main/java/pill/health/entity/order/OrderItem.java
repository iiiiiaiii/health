package pill.health.entity.order;

import jakarta.persistence.*;
import lombok.Getter;
import pill.health.entity.BaseEntity;
import pill.health.entity.order.OrderBasket;

import java.util.UUID;

@Entity
@Getter
public class OrderItem extends BaseEntity {
//상품담기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderItem_id")
    private UUID uuid;

    private String name;
    private int count;
    private int priceOne;

    @JoinColumn(name = "orderBasket_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderBasket orderBasket;

    public OrderItem(String name, int count, int priceOne,OrderBasket orderBasket) {
        this.name = name;
        this.count = count;
        this.priceOne = priceOne;
        this.orderBasket = orderBasket;
    }
}
