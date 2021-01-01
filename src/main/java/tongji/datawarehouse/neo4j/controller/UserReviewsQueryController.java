package tongji.datawarehouse.neo4j.controller;

import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.Comment;
import tongji.datawarehouse.neo4j.domainclass.Movie;
import tongji.datawarehouse.neo4j.domainclass.SameMovie;
import tongji.datawarehouse.neo4j.repository.MovieRepository;
import tongji.datawarehouse.neo4j.repository.CommentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 21:22 2021/1/1
 * @Modified By:
 **/
@RestController
@RequestMapping("/api/v1/movies/")
public class UserReviewsQueryController {

    private final MovieRepository movieRepository;
    private final CommentRepository commentRepository;

    public UserReviewsQueryController(MovieRepository movieRepository, CommentRepository commentRepository) {
        this.movieRepository = movieRepository;
        this.commentRepository = commentRepository;
    }

    @RequestMapping(value = "/avgscores", method = RequestMethod.GET)
    @Description("根据电影的title搜索平均值")
    public HashMap<String, Object> getAvgScoresByTitle(@RequestParam String title) {
        Movie movie = movieRepository.getMovieByRealTitle(title);
        HashMap<String, Object> res = new HashMap<>();
        res.put("score", movie.getScore());
        return res;
    }

    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    @Description("根据title获取一部电影的评论列表")
    public HashMap<String, Object> getReviewsByTitle(@RequestParam String title) {
        List<Comment> commentList = commentRepository.getReviewListByRealTitle(title);
        HashMap<String, Object> res = new HashMap<>();
        res.put("count", commentList.size());
        List<HashMap<String, Object>> reviewlist = new ArrayList<>();
        for (Comment comment : commentList) {
            HashMap<String, Object> temp = new HashMap<>();
            temp.put("pid", comment.getProduct().getName());
            temp.put("userid", comment.getUser().getName());
            temp.put("profileName", comment.getUser().getProfileName());
            temp.put("helpfulness", comment.getHelpfulness());
            temp.put("score", comment.getScore());
            temp.put("time", comment.getTime());
            temp.put("summary", comment.getSummary());
            temp.put("text", comment.getText());
            temp.put("is_Positive", false);
            reviewlist.add(temp);
        }
        res.put("reviewList", reviewlist);
        return res;
    }
}
