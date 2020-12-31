package tongji.datawarehouse.neo4j.repository.relation;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.relation.Comment;
import tongji.datawarehouse.neo4j.domainclass.relation.Direct;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 20:48 2020/12/31
 * @Modified By:
 **/
public interface CommentRepository extends Neo4jRepository<Comment,Long> {
    @Query("MATCH (u:User) -[c:comment]->(m:Movie) return c,collect(u),collect(m)")
    List<Comment> getALlComment();
}
