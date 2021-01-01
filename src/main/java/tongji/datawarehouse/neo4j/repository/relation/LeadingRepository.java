package tongji.datawarehouse.neo4j.repository.relation;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.relation.Leading;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 18:25 2020/12/31
 * @Modified By:
 **/
public interface LeadingRepository extends Neo4jRepository<Leading,Long> {
    @Query("MATCH (a:Actor) -[l:leading]->(m:Movie) return l,collect(a),collect(m)")
    List<Leading> getALlLeading();
}
