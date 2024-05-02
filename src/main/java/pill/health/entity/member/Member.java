package pill.health.entity.member;

import jakarta.persistence.*;
import lombok.Getter;
import pill.health.entity.Address;
import pill.health.entity.BaseEntity;
import pill.health.entity.order.OrderBase;
import pill.health.entity.enums.Grade;

import java.util.UUID;

@Entity
@Getter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private UUID uuid;

    @Column(unique = true)
    private String username;

    private String password;
    private String privateNumber; //주민번호
    @Embedded
    private Address address;
    private String tell;
    private String Email;
    private int consumption;
    private Grade grade;
    private String role;

    @OneToOne
    @JoinColumn(name = "orderBase_id")
    private OrderBase orderBase;



    public Member(String username, String password, String privateNumber, String address, String zipcode,String street, String tell, String email, int consumption) {
        this.username = username;
        this.password = password;
        this.privateNumber = privateNumber;
        this.address = new Address(address, zipcode, street);
        this.tell = tell;
        this.Email = email;
        this.consumption = consumption;
        this.role = "USER";
        this.grade = Grade.Silver;
        this.orderBase = new OrderBase(this);
    }
}
