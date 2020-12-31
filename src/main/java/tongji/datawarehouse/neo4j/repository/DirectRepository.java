package tongji.datawarehouse.neo4j.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.relation.Direct;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 18:25 2020/12/31
 * @Modified By:
 **/
public interface DirectRepository extends Neo4jRepository<Direct,Long> {
    @Query("MATCH (d:Director) -[dir:direct]->(m:Movie) return dir,collect(d),collect(m)")
    List<Direct> getALlDirect();
}
