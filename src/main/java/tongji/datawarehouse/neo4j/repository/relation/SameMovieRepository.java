package tongji.datawarehouse.neo4j.repository.relation;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.relation.Direct;
import tongji.datawarehouse.neo4j.domainclass.relation.Leading;
import tongji.datawarehouse.neo4j.domainclass.relation.SameMovie;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 18:25 2020/12/31
 * @Modified By:
 **/
public interface SameMovieRepository extends Neo4jRepository<SameMovie,Long> {
    @Query("MATCH (c:Product) -[s:same_movie]->(p:Product) return s,collect(c),collect(p)")
    List<SameMovie> getALlSameMovie();
}
