package tongji.datawarehouse.neo4j.repository.node;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.node.Person;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 15:14 2021/1/1
 * @Modified By:
 **/
public interface PersonRepository extends Neo4jRepository<Person,Long> {
    Person getPersonByName(String name);

}
