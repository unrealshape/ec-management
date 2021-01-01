package de.elmasconsulting.ecmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    @lombok.Getter
    @lombok.Setter
    @Id
    @GeneratedValue
    @SequenceGenerator(
            name = "users_generator",
            sequenceName = "users_sequence",
            initialValue = 1000
    )
    @Column(name = "userID")
    private Long userID;

    @Column(name = "rollID")
    private int rollID;

    @lombok.Getter
    @lombok.Setter
    @Column(name = "username")
    private String username;

    @lombok.Getter
    @lombok.Setter
    @Column(name = "password")
    private String password;

    public User(Long userID,int rollID, String username, String password) {
        this.userID = userID;
        this.rollID = rollID;
        this.username = username;
        this.password = password;
    }

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + this.userID + ", username='" + this.username + ", password='" + this.password + '\'' + ", rollid='" + this.rollID + '\'' + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
