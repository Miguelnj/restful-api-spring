package springtheamproject.project.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = true)
    private long id;
    @Column(name="role_name", nullable = true)
    private String role;

    public Role(){}

    public Role(String role){
        this.role = role;
    }

    public String getRoleName() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
