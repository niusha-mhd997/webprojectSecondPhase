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

    @Column(name = "ANSWER")
    String answer;

    // false: not answered,
    // true: answered
    @Column(name = "STATUSS")
    boolean statuss;

    @ManyToOne
    @JoinColumn(name="SENDER_EMAIL", referencedColumnName = "EMAIL")
    StudentEntity SENDER;
    public void setSENDER(StudentEntity SENDER) {
        this.SENDER = SENDER;
    }


    @ManyToOne
    @JoinColumn(name="RECEIVER_EMAIL", referencedColumnName = "EMAIL")
    EmployeeEntity RECEIVER;
    public void setRECEIVER(EmployeeEntity RECEIVER) {
        this.RECEIVER = RECEIVER;
    }
    public EmployeeEntity getRECEIVER() {
        return RECEIVER;
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

    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
