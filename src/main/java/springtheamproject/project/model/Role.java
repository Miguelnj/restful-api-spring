package springtheamproject.project.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private int id;
    @Column(name="role")
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
