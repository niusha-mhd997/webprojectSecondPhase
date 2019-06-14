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

    @Column(name="SEMAT")
    String semat;

    //true=can Login, false=cannot Login
    @Basic
    @Column(name="PERMISSION")
    boolean permission;

    @Basic
    @Column(name="TOKEN")
    int token;

    @OneToMany(mappedBy = "RECEIVER", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<CaseEntity> CaseEntitys;
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

    public boolean getPermission() {
        return permission;
    }
    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public int getToken() {
        return token;
    }
    public void setToken(int token) {
        this.token = token;
    }

    public String getSemat() {
        return semat;
    }
    public void setSemat(String semat) {
        this.semat = semat;
    }

    public EmployeeEntity(String email, String name, String semat) {
        this.email = email;
        this.name = name;
        this.semat = semat;
    }

    public EmployeeEntity() {
    }
}
