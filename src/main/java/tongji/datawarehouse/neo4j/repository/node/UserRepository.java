package tongji.datawarehouse.neo4j.repository.node;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.node.User;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 20:36 2020/12/31
 * @Modified By:
 **/
public interface UserRepository extends Neo4jRepository<User,Long> {
    User getUserByName(String name);
    Iterable<User> getUserListByProfileName(String profileName);
}
