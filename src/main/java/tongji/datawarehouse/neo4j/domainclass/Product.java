package tongji.datawarehouse.neo4j.domainclass;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 18:15 2020/12/31
 * @Modified By:
 **/
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
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
