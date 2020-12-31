package tongji.datawarehouse.neo4j.domainclass.node;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 18:15 2020/12/31
 * @Modified By:
 **/
@NodeEntity(label="Product")
public class Product {
    @Id
    @GeneratedValue
    protected Long id;
    protected String name;

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
