package tongji.datawarehouse.neo4j.neo4j.controller;

import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;
import tongji.datawarehouse.neo4j.domainclass.node.Movie;
import tongji.datawarehouse.neo4j.repository.MovieRepository;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 17:13 2020/12/31
 * @Modified By:
 **/
@RestController
@RequestMapping("/neo4j/movie")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/getMovieByYear")
    @Description("根据年份获取全部电影")
    public Iterable<Movie> getMovieListByYear(@RequestParam String year) {
        return movieRepository.getMovieListByYear(year);
    }

    @GetMapping("/getMovieByYearAndMonth")
    @Description("根据年份获取全部电影")
    public Iterable<Movie> getMovieListByYearAndMonth(@RequestParam String year, @RequestParam String month) {
        return movieRepository.getMovieListByYearAndMonth(year, month);
    }
}
