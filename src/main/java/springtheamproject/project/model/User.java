package springtheamproject.project.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String accountName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean status;

    public User(){}

    public User(String name, String accountName, String password, boolean status) {
        this.name = name;
        this.accountName = accountName;
        this.password = password;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus(){
        return this.status;
    }

    public String getId() {
        return id;
    }

    public void setNullId() {
        this.id = null;
    }

    @Override
    public String toString(){
        String toReturn =  "Account used by: " + name + "\nAccount name: " + accountName + "\nPassword: " +password;
        if(this.status){
            return toReturn.concat("\nRole: Administrator");
        }else{
            return toReturn.concat("\nRole: Regular");
        }
    }

}
