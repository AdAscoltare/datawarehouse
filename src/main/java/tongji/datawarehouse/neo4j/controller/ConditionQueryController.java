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
            @RequestParam(required = false, defaultValue = "5.1") String scoreLessThan,
            @RequestParam(required = false, defaultValue = "1000-32-32") String startTime,
            @RequestParam(required = false, defaultValue = "1000-32-32") String endTime,
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

        HashMap<String, Object> res = new HashMap<>();
        List<HashMap<String, Object>> movieList = new ArrayList<>();
        //不查询角色
        //000
        if (actor.equals("default") && director.equals("default") && leadActor.equals("default")) {
            List<Movie> movies = movieRepository.getMoviesByConditionsWithoutALD(
                    title,
                    Float.parseFloat(scoreLargerThan),
                    Float.parseFloat(scoreLessThan),
                    Integer.parseInt(startYear),
                    Integer.parseInt(startMonth),
                    Integer.parseInt(startDate),
                    Integer.parseInt(endYear),
                    Integer.parseInt(endMonth),
                    Integer.parseInt(endDate),
                    genre
            );
            makeMovieItem(movieList, movies);
            //如果查询主演
            //001
        } else if (actor.equals("default") && director.equals("default") && !leadActor.equals("default")) {
            List<Movie> movies = movieRepository.getMoviesByConditionsWithL(
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
                    leadActor
            );
            makeMovieItem(movieList, movies);
            //如果查询参演
            //100
        } else if (!actor.equals("default") && director.equals("default") && leadActor.equals("default")) {
            List<Movie> movies = movieRepository.getMoviesByConditionsWithA(
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
                    actor
            );
            makeMovieItem(movieList, movies);
            //如果查询导演
            //010
        } else if (actor.equals("default") && !director.equals("default") && leadActor.equals("default")) {
            List<Movie> movies = movieRepository.getMoviesByConditionsWithD(
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
                    director
            );
            makeMovieItem(movieList, movies);
            //如果查询参演和导演
            //110
        }else if (!actor.equals("default") && !director.equals("default") && leadActor.equals("default")) {
            List<Movie> movies = movieRepository.getMoviesByConditionsWithAD(
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
                    director
            );
            makeMovieItem(movieList, movies);
            //101
        }else if (!actor.equals("default") && director.equals("default") && !leadActor.equals("default")) {
            List<Movie> movies = movieRepository.getMoviesByConditionsWithAL(
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
                    leadActor
            );
            makeMovieItem(movieList, movies);
            //011
        }else if (actor.equals("default") && !director.equals("default") && !leadActor.equals("default")) {
            List<Movie> movies = movieRepository.getMoviesByConditionsWithDL(
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
                    director,
                    leadActor
            );
            makeMovieItem(movieList, movies);
            //111
        }else if (!actor.equals("default") && !director.equals("default") && !leadActor.equals("default")) {
            List<Movie> movies = movieRepository.getMoviesByConditionsWithADL(
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
                    director,
                    leadActor
            );
            makeMovieItem(movieList, movies);
        }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

        res.put("count", movieList.size());
        res.put("movieList", movieList);
        res.put("params", params);
        return res;
    }

    private void makeMovieItem(List<HashMap<String, Object>> movieList, List<Movie> movies) {
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
    }
}
