package springtheamproject.project.model.dtomodel;

public class UserPasswordOnly {
    private Long id;
    private String password;

    public UserPasswordOnly(){}

    public UserPasswordOnly(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserPasswordOnly{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
