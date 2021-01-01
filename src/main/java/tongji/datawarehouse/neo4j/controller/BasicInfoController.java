package tongji.datawarehouse.neo4j.controller;

import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.Movie;
import tongji.datawarehouse.neo4j.domainclass.Person;
import tongji.datawarehouse.neo4j.repository.MovieRepository;
import tongji.datawarehouse.neo4j.repository.PersonRepository;

import java.util.HashMap;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 19:06 2021/1/1
 * @Modified By:
 **/

@RestController
@RequestMapping("/api/v1/movies/")
public class BasicInfoController {
    private final MovieRepository movieRepository;
    private final PersonRepository personRepository;

    public BasicInfoController(MovieRepository movieRepository, PersonRepository personRepository) {
        this.movieRepository = movieRepository;
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "movies/{pid}",method = RequestMethod.GET)
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

    @RequestMapping(value = "/persons/{pid}", method = RequestMethod.GET)
    @Description("根据名称获取一个Person节点")
    public HashMap<String,Object> getPersonByName(@PathVariable("pid") String name) {
        Person person=personRepository.getPersonByName(name);
        HashMap<String,Object> res=new HashMap<>();
        res.put("personName",person.getName());
        res.put("isDirector",person.getDirector());
        res.put("isActor",person.getActor());

        return res;
    }
}
