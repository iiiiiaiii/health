package pill.health.dto;

import lombok.Data;

@Data
public class ItemListDto {

    private String name;
    private int price;
    private int stock;
    private String etc;

    protected ItemListDto() {

    }

    public ItemListDto(String name, int price, int stock, String etc) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.etc = etc;
    }
}
