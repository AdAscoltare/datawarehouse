package tongji.datawarehouse.neo4j.controller;

import org.neo4j.ogm.compiler.SrcTargetKey;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.Movie;
import tongji.datawarehouse.neo4j.domainclass.Person;
import tongji.datawarehouse.neo4j.domainclass.relation.Direct;
import tongji.datawarehouse.neo4j.repository.DirectRepository;
import tongji.datawarehouse.neo4j.repository.PlayInRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 1:18 2021/1/2
 * @Modified By:
 **/
@RestController
@RequestMapping("/api/v1/movies")
public class RelationshipQueryController {
    private final DirectRepository directRepository;
    private final PlayInRepository playInRepository;

    public RelationshipQueryController(DirectRepository directRepository, PlayInRepository playInRepository) {
        this.directRepository = directRepository;
        this.playInRepository = playInRepository;
    }

    @RequestMapping(value = "/cooperationRanking",method = RequestMethod.GET)
    @Description("查找关系")
    public HashMap<String,Object> /*HashMap<String,Object>*/ getRelationByTypeAndLength(@RequestParam Integer length, @RequestParam String type){
        HashMap<String ,Object> res=new HashMap<>();
        if(type.equals("Director and Director")){
            List<Direct> directList=directRepository.getALlDirectCooperation();
            res.put("size",directList.size());
        }
        List<Direct> directList=directRepository.getALlDirectCooperation();
        HashMap<String,Object> directors=new HashMap<>();
        HashMap<String , Object> movies=new HashMap<>();
        for(Direct direct : directList){
            Person d=direct.getDirector();
            Movie m=direct.getMovie();
            directors.put(d.getName(),d);
            movies.put(m.getRealTitle(),m);
        }
        res.put("size",directList.size());
        res.put("directorNum",directors.size());
        res.put("movieNum",movies.size());
        return res;
    }
}
