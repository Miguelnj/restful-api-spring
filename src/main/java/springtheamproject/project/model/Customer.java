package springtheamproject.project.model;


import javax.persistence.*;

//Having this annotation, im telling JPA to create a table of customer objects.
// JPA framework process the object making the SQL for the database
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String photoURL;
    @Column()
    private String lastUserWhoEdited;
    @Column()
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

    public String getId() {
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
        return "Name: " + name + "\nSurname: " + surname;
    }

}
