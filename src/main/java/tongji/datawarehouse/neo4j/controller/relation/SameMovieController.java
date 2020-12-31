package tongji.datawarehouse.neo4j.controller.relation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.relation.SameMovie;
import tongji.datawarehouse.neo4j.repository.relation.SameMovieRepository;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 21:03 2020/12/31
 * @Modified By:
 **/
@RestController
@RequestMapping("/neo4j/samemovie")
public class SameMovieController {
    private final SameMovieRepository sameMovieRepository;

    public SameMovieController(SameMovieRepository sameMovieRepository) {
        this.sameMovieRepository = sameMovieRepository;
    }

    @GetMapping("/getAllSameMovie")
    public List<SameMovie> getAllSameMovie(){
        return  sameMovieRepository.getALlSameMovie();
    }
}
