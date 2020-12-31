package tongji.datawarehouse.neo4j.controller.relation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.relation.Comment;
import tongji.datawarehouse.neo4j.repository.relation.CommentRepository;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 20:49 2020/12/31
 * @Modified By:
 **/
@RestController
@RequestMapping("/neo4j/comment")
public class CommentController {
    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    @GetMapping("/getAllComment")
    public List<Comment> getAllComment(){
        return  commentRepository.getALlComment();
    }
}
