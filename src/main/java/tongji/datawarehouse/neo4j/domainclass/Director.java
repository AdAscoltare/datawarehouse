package tongji.datawarehouse.neo4j.domainclass;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 15:46 2020/12/31
 * @Modified By:
 **/
public class Director {


    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Director(String name) {
        this.name = name;
    }

    public Director() {

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

}
