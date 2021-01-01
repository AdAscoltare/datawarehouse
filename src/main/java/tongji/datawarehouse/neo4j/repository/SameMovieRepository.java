package tongji.datawarehouse.neo4j.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.SameMovie;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 18:25 2020/12/31
 * @Modified By:
 **/
public interface SameMovieRepository extends Neo4jRepository<SameMovie,Long> {
    @Query("MATCH (c:Product) -[s:same_movie]->(p:Product) where p.realTitle= $realTitle return s,collect(c),collect(p)")
    List<SameMovie> getALlSameMovieByTitle(String realTitle);
}
