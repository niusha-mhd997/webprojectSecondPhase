package ir.asta.training.contacts.entities;

/**
 * Created by win_8.1 on 5/18/2019.
 */
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="EMPLOYEE")
public class EmployeeEntity {

    @Id
    @Column(name = "EMAIL")
    String email;

    @Basic
    @Column(name="NAME")
    String name;

    @Basic
    @Column(name="PASSWORD")
    String password;


    //1=can Login, 0=cannot Login
    @Basic
    @Column(name="PERMISSION")
    int permission;


    @OneToMany(mappedBy = "RECEIVER", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<CaseEntity> CaseEntitys;
    public List<CaseEntity> getCaseEntitys() {
        return CaseEntitys;
    }
    public void setCaseEntitys(List<CaseEntity> caseEntitys) {
        CaseEntitys = caseEntitys;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public int getPermission() {
        return permission;
    }
    public void setPermission(int permission) {
        this.permission = permission;
    }
}
