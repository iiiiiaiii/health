package pill.health.entity.item;


import jakarta.persistence.*;
import lombok.Getter;
import pill.health.entity.BaseEntity;

import java.util.UUID;

@Entity
@Getter
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private UUID uuid;

    private String name;
    private int price;
    private int stock;
    private String etc;

    public Item(String name, int price, int stock, String etc) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.etc = etc;
    }
}
