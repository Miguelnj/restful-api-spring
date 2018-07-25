package springtheamproject.project.model;


import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    private String photoURL;
    private String lastUserWhoEdited;
    private String createdBy;

    public Customer(){}

    public Customer(String name, String surname, String photoURL, String createdBy) {
        this.name = name;
        this.surname = surname;
        this.photoURL = photoURL;
        this.lastUserWhoEdited = "";
        this.createdBy = createdBy;
    }

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.photoURL = "";
        this.lastUserWhoEdited = "";
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

    public Long getId() {
        return id;
    }

    public String getLastUserWhoEdited() {
        return lastUserWhoEdited;
    }

    public void setLastUserWhoEdited(String lastUserWhoEdited) {
        this.lastUserWhoEdited = lastUserWhoEdited;
    }

    public void setNullId() {
        this.id = null;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }

    @Override
    public String toString(){
        return (new StringBuilder("Customer " + id + ": " + name + " " + surname +
                "\nCreated by: " + createdBy + "\nLast edited by: " + lastUserWhoEdited)).toString();
    }

}
