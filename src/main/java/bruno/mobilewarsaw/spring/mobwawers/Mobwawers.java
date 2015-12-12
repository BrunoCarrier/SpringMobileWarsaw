package bruno.mobilewarsaw.spring.mobwawers;

import javax.persistence.*;

@Entity
public class Mobwawers {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String email;
    private String platform;
    private int age;

    public Mobwawers() {
    }

    public Mobwawers(String name, String email, String platform, int age) {
        this.name = name;
        this.email = email;
        this.platform = platform;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
