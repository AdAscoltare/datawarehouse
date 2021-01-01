package tongji.datawarehouse.neo4j.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.Comment;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 20:48 2020/12/31
 * @Modified By:
 **/
public interface CommentRepository extends Neo4jRepository<Comment,Long> {
    @Query("MATCH (u:User) -[c:comment]->(m:Movie) where m.realTitle=$realTitle return c,collect(u),collect(m)")
    List<Comment> getReviewListByRealTitle(String realTitle);
}
