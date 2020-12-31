package tongji.datawarehouse.neo4j.domainclass.node;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 18:13 2020/12/31
 * @Modified By:
 **/
@NodeEntity(label="User")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String profileName;

    public User() {
    }

    public User(String name, String profileName) {
        this.name = name;
        this.profileName = profileName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
