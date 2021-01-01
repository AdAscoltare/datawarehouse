package tongji.datawarehouse.neo4j.controller;

import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.SameMovie;
import tongji.datawarehouse.neo4j.repository.SameMovieRepository;

import java.util.*;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 20:09 2021/1/1
 * @Modified By:
 **/
@RestController
@RequestMapping("/api/v1/movies")
public class MovieVersionQueryController {
    private final SameMovieRepository sameMovieRepository;

    public MovieVersionQueryController(SameMovieRepository sameMovieRepository) {
        this.sameMovieRepository = sameMovieRepository;
    }
    @RequestMapping(value = "/versions",method = RequestMethod.GET)
    @Description("根据电影title获取相同页面的并查集")
    public HashMap<String ,Object> getAllSameMovieByTitle(@RequestParam String title){
        List<SameMovie> sameMovieList= sameMovieRepository.getALlSameMovieByTitle(title);
        HashMap<String ,Object> res=new HashMap<>();
        res.put("count",sameMovieList.size());
        List<HashMap<String,Object>> movielist=new ArrayList<>();
        for (SameMovie child :sameMovieList){
            HashMap<String ,Object> temp=new HashMap<>();
            temp.put("pid",child.getChild().getName());
            temp.put("movieName",child.getChild().getTitle());
            temp.put("score",child.getParent().getScore());
            temp.put("publishYear",child.getParent().getYear());
            temp.put("publishMonth",child.getParent().getMonth());
            temp.put("publishDay",child.getParent().getDate());
            movielist.add(temp);
        }
        res.put("movieList",movielist);
        return res;
    }
}
