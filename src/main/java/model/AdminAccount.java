package model;

import javax.persistence.*;

@Entity
@Table(name = "adminAccounts")
public class AdminAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private String phone;
    private String role;
    private String dateStart;
    private String dateEnd;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AdminAccount(){}

    public AdminAccount(Long id, String email, String password, String phone, String role, String dateStart, String dateEnd, int status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}

