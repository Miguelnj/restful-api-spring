package springtheamproject.project.model;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Having this annotation, im thelling JPA to create a Table of Customer Objetcs.
// JPA framework process the object making the SQL for the database
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;
    private String name;
    private String surname;
    private String photoURL;

    public Customer(){}

    public Customer(String name, String surname, String photoURL) {
        this.name = name;
        this.surname = surname;
        this.photoURL = photoURL;
    }

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.photoURL = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    @Override
    public String toString(){
        return "Name: " + name + "\nSurname: " + surname;
    }
}
