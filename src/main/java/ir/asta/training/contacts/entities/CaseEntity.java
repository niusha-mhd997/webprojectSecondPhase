package ir.asta.training.contacts.entities;

/**
 * Created by win_8.1 on 5/18/2019.
 */
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;



@Entity
@Table(name="CASES")
public class CaseEntity {

    @Id
    @Column(name = "ID")
    //@GeneratedValue(strategy=GenerationType.AUTO)
    String id;

    @Column(name = "SUBJECT")
    String subject;

    @Column(name = "DESCRIPTION")
    String description;

    @Column(name = "DATE")
    String date;

    @Column(name = "STATUSS")
    boolean statuss;

    @Column(name = "RECEIVER")
    String receiver;

    @ManyToOne
    @JoinColumn(name="SENDER_EMAIL", referencedColumnName = "EMAIL")
    StudentEntity SENDER;
    public void setSTU(StudentEntity SENDER) {
        this.SENDER = SENDER;
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public boolean getStatuss() {
        return statuss;
    }
    public void setStatuss(boolean statuss) {
        this.statuss = statuss;
    }

    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }


}