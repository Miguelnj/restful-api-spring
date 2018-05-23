package springtheamproject.project.model;

import javax.persistence.*;
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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User() {
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

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
        StringBuilder toReturn = new StringBuilder("Account name: " + username + "\nPassword: " + password);
        for (Role role :
                this.roles) {
            toReturn.append("\n").append(role.getRoleName());
        }
        return toReturn.toString();
    }

}
