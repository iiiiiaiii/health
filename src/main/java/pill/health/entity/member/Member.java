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
    @GeneratedValue
    @Column(name="member_id")
    private UUID uuid;

    @Column(unique = true)
    private String username;

    private String name;
    private String password;
    private String privateNumber; //주민번호
    @Embedded
    private Address address;
    private String tell;
    private String Email;
    private int consumption;
    @Enumerated(EnumType.STRING)
    private Grade grade;
    private String role;

    @OneToOne
    @JoinColumn(name = "orderBase_id")
    private OrderBase orderBase;

    protected Member() {

    }


    public Member(String username, String name, String password, String privateNumber, Address address, String tell, String email) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.privateNumber = privateNumber;
        this.address = address;
        this.tell = tell;
        this.Email = email;
        this.consumption=0;
        this.role = "USER";
        this.grade = Grade.Silver;
        this.orderBase = new OrderBase(this);
    }
}
