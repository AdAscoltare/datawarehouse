package tongji.datawarehouse.neo4j.repository.node;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.node.Product;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 20:31 2020/12/31
 * @Modified By:
 **/
public interface ProductRepository extends Neo4jRepository<Product,Long> {
    Product getProductByName(String name);
}
