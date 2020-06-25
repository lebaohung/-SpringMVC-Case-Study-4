package model.admin;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdDate;
    private String receivedName;
    private String receivedAddress;
    private String receivedPhone;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
    @ManyToOne
    @JoinColumn(name="status_id")
    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public Bill(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getReceivedName() {
        return receivedName;
    }

    public void setReceivedName(String receivedName) {
        this.receivedName = receivedName;
    }

    public String getReceivedAddress() {
        return receivedAddress;
    }

    public void setReceivedAddress(String receivedAddress) {
        this.receivedAddress = receivedAddress;
    }

    public String getReceivedPhone() {
        return receivedPhone;
    }

    public void setReceivedPhone(String receivedPhone) {
        this.receivedPhone = receivedPhone;
    }



    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Bill(Long id, Date createdDate, String receivedName, String receivedAddress, String receivedPhone, Province province, Status status) {
        this.id = id;
        this.createdDate = createdDate;
        this.receivedName = receivedName;
        this.receivedAddress = receivedAddress;
        this.receivedPhone = receivedPhone;
        this.province = province;
        this.status = status;
    }
}
