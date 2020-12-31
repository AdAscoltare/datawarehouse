package tongji.datawarehouse.neo4j.domainclass.relation;

import org.neo4j.ogm.annotation.*;
import tongji.datawarehouse.neo4j.domainclass.node.Product;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 19:50 2020/12/31
 * @Modified By:
 **/
@RelationshipEntity(type = "same_movie")
public class SameMovie {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    Product child;

    @EndNode
    Product parent;

    public SameMovie() {
    }

    public SameMovie(Product child, Product parent) {
        this.child = child;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public Product getChild() {
        return child;
    }

    public void setChild(Product child) {
        this.child = child;
    }

    public Product getParent() {
        return parent;
    }

    public void setParent(Product parent) {
        this.parent = parent;
    }
}
