package pill.health.dto;

import lombok.Data;

@Data
public class MemberFormDto {
    private String username;
    private String name;
    private String password;
    private String privateNumber;
    private String Address;
    private String AddressDetail;
    private String tell;
    private String Email;

    public MemberFormDto(String username, String name, String password, String address, String addressDetail, String tell, String email) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.Address = address;
        this.AddressDetail = addressDetail;
        this.tell = tell;
        this.Email = email;
    }
}
