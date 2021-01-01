package tongji.datawarehouse.neo4j.controller.node;

import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.node.Movie;
import tongji.datawarehouse.neo4j.repository.node.MovieRepository;

import java.util.HashMap;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 19:06 2021/1/1
 * @Modified By:
 **/

@RestController
@RequestMapping("/api/v1/movies/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @RequestMapping(value = "/{pid}",method = RequestMethod.GET)
    @Description("根据pid查一部电影")
    public HashMap<String,Object> getMovieByName(@PathVariable("pid") String name){
        Movie movie= movieRepository.getMovieByName(name);
        HashMap<String ,Object> res=new HashMap<>();
        res.put("pid",movie.getName());
        res.put("movieName",movie.getRealTitle());
        res.put("score",movie.getScore());
        res.put("publishYear",movie.getYear());
        res.put("publishMonth",movie.getMonth());
        res.put("publishDay",movie.getDate());
        return res;
    }
}
