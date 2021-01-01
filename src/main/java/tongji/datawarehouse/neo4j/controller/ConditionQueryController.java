package tongji.datawarehouse.neo4j.controller;

import org.springframework.beans.factory.support.MethodOverride;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.Movie;
import tongji.datawarehouse.neo4j.repository.MovieRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 2:33 2021/1/2
 * @Modified By:
 **/
@RestController
@RequestMapping("/api/v1/movies/")
public class ConditionQueryController {
    private final MovieRepository movieRepository;

    public ConditionQueryController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @Description("根据各种各样的条件查询")
    public HashMap<String, Object> getMovieByConditions(
            @RequestParam(required = false, defaultValue = "") String title,
            @RequestParam(required = false, defaultValue = "0.0") String scoreLargerThan,
            @RequestParam(required = false, defaultValue = "5.0") String scoreLessThan,
            @RequestParam(required = false, defaultValue = "1971-01-01") String startTime,
            @RequestParam(required = false, defaultValue = "2020-01-01") String endTime,
            @RequestParam(required = false, defaultValue = "default") String genre,
            @RequestParam(required = false, defaultValue = "default") String actor,
            @RequestParam(required = false, defaultValue = "default") String leadActor,
            @RequestParam(required = false, defaultValue = "default") String director


    ) {
        String startYear = startTime.substring(0, 4);
        String startMonth = startTime.substring(5, 7);
        String startDate = startTime.substring(8, 10);
        String endYear = endTime.substring(0, 4);
        String endMonth = endTime.substring(5, 7);
        String endDate = endTime.substring(8, 10);
        List<Movie> movies = movieRepository.getMoviesByConditions(
                title,
                Float.parseFloat(scoreLargerThan),
                Float.parseFloat(scoreLessThan),
                Integer.parseInt(startYear),
                Integer.parseInt(startMonth),
                Integer.parseInt(startDate),
                Integer.parseInt(endYear),
                Integer.parseInt(endMonth),
                Integer.parseInt(endDate),
                genre,
                actor,
                leadActor,
                director
        );
        HashMap<String, Object> params = new HashMap<>();
        params.put("title", title);
        params.put("scoreLargerThan", Float.parseFloat(scoreLargerThan));
        params.put("scoreLessThan", Float.parseFloat(scoreLessThan));
        params.put("startYear", Integer.parseInt(startYear));
        params.put("startMonth", Integer.parseInt(startMonth));
        params.put("startDate", Integer.parseInt(startDate));
        params.put("endYear", Integer.parseInt(endYear));
        params.put("endMonth", Integer.parseInt(endMonth));
        params.put("endDate", Integer.parseInt(endDate));
        params.put("genre", genre);


        HashMap<String, Object> res = new HashMap<>();

        List<HashMap<String, Object>> movieList = new ArrayList<>();
        for (Movie movie : movies) {
            HashMap<String, Object> t = new HashMap<>();
            t.put("pid", movie.getName());
            t.put("movieName", movie.getRealTitle());
            t.put("score", movie.getScore());
            t.put("publishYear", movie.getYear());
            t.put("publishMonth", movie.getMonth());
            t.put("publishDay", movie.getDate());
            movieList.add(t);
        }
        res.put("count", movies.size());
        res.put("movieList", movieList);
        res.put("params", params);
        return res;
    }
}
