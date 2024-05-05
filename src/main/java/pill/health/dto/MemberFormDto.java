package pill.health.dto;

import lombok.Data;
import pill.health.entity.Address;

@Data
public class MemberFormDto {
    private String username;
    private String name;
    private String password;
    private String privateNumber;
    private Address address;
    private String tell;
    private String Email;

    public MemberFormDto(String username, String name, String password, String city, String zipcode,String street, String tell, String email) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.address = new Address(city, zipcode, street);
        this.tell = tell;
        this.Email = email;
    }
}
