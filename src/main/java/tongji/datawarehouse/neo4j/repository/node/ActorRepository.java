package tongji.datawarehouse.neo4j.repository.node;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.node.Actor;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 20:16 2020/12/31
 * @Modified By:
 **/
public interface ActorRepository extends Neo4jRepository<Actor,Long> {
    Actor getActorByName(String name);


}
