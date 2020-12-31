package tongji.datawarehouse.neo4j.repository.relation;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.node.Actor;
import tongji.datawarehouse.neo4j.domainclass.relation.Direct;
import tongji.datawarehouse.neo4j.domainclass.relation.Leading;
import tongji.datawarehouse.neo4j.domainclass.relation.PlayIn;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 18:25 2020/12/31
 * @Modified By:
 **/
public interface PlayInRepository extends Neo4jRepository<PlayIn,Long> {
    @Query("MATCH (a:Actor) -[p:play_in]->(m:Movie) return p,collect(a),collect(m)")
    List<PlayIn> getALlPlayIn();
}
