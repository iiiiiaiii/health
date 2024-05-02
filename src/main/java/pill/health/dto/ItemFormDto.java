package pill.health.dto;

import lombok.Data;

@Data
public class ItemFormDto {
    private String name;
    private int stock;
    private int price;
    private String etc;

    public ItemFormDto(String name, int stock, int price, String etc) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.etc = etc;
    }
}
