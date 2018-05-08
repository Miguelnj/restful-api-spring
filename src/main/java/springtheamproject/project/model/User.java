package springtheamproject.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String accountName;
    private String password;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
