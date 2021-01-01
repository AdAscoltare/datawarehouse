package tongji.datawarehouse.neo4j.repository.node;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.node.Movie;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 17:10 2020/12/31
 * @Modified By:
 **/
public interface MovieRepository extends Neo4jRepository<Movie,Long> {
    Movie getMovieByName(String pid);
}
