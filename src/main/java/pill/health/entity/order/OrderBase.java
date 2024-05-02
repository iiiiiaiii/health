package pill.health.entity.order;

import jakarta.persistence.*;
import lombok.Getter;
import pill.health.entity.BaseEntity;
import pill.health.entity.member.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class OrderBase extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderBase_id")
    private UUID uuid;

    @OneToMany(mappedBy = "orderBase")
    private List<OrderBasket> orderBasket = new ArrayList<>();

    @OneToOne(mappedBy = "orderBase")
    private Member member;

    private int price;

    public OrderBase(Member member) {
        this.member = member;
        this.price=0;
    }
}
