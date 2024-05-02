package pill.health.entity.order;

import jakarta.persistence.*;
import lombok.Getter;
import pill.health.entity.BaseEntity;
import pill.health.entity.enums.PayStatus;
import pill.health.entity.member.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class OrderBasket extends BaseEntity {
//장바구니
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderBasket_id")
    private UUID uuid;

    @OneToMany(mappedBy = "orderBasket")
    private List<OrderItem> orderItem = new ArrayList<>();

    @JoinColumn(name = "orderItem_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderBase orderBase;

    private int price;

    @Enumerated(EnumType.STRING)
    private PayStatus payStatus;

    @OneToOne(mappedBy = "orderBasket")
    private Delivery delivery;

    public void setOrderItem(String name, int count, int priceOne) {
        OrderItem newOrderItem = new OrderItem(name, count, priceOne, this);
        orderItem.add(newOrderItem);
    }


    protected OrderBasket() {
    }

    public OrderBasket(Member member, int price) {
        OrderBase memberOrder = member.getOrderBase();
        this.orderBase = memberOrder;
        this.price = price;
        this.payStatus = PayStatus.결제전;
        this.delivery = null;
        memberOrder.getOrderBasket().add(this);
    }
}
