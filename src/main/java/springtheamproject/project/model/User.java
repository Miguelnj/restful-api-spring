package springtheamproject.project.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, length = 60)
    private String password;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();

    public User(){}

    public User(String name, String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Role> status) {
        this.roles = status;
    }

    public Set<Role> getRoles(){
        return this.roles;
    }

    public Long getId() {
        return id;
    }

    public void setNullId() {
        this.id = null;
    }

    @Override
    public String toString(){
        String toReturn =  "Account name: " + username + "\nPassword: " +password;
        if(this.roles.size() > 1){
            return toReturn.concat("\nRole: Administrator");
        }else{
            return toReturn.concat("\nRole: Regular");
        }
    }

}
