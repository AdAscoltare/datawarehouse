package tongji.datawarehouse.neo4j.repository.node;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.node.Director;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 15:56 2020/12/31
 * @Modified By:
 **/
public interface DirectorRepository extends Neo4jRepository<Director,Long> {
    Director getDirectorByName(String name);

    Iterable<Director> findDirectorByNameLike(String name);

    @Query("MATCH (d:Director) RETURN d")
    List<Director> getAllDirector();
}
