package pill.health.entity.order;

import jakarta.persistence.*;
import lombok.Getter;
import pill.health.entity.Address;
import pill.health.entity.BaseEntity;
import pill.health.entity.enums.DeliveryStatus;

import java.util.UUID;

@Entity
@Getter
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @OneToOne
    @JoinColumn(name = "orderBasket_id")
    private OrderBasket orderBasket;

    @Embedded
    private Address address;

    protected Delivery() {

    }

    public Delivery(OrderBasket orderBasket, Address address) {
        this.deliveryStatus = DeliveryStatus.배송전;
        this.orderBasket = orderBasket;
        this.address = address;
    }
}
