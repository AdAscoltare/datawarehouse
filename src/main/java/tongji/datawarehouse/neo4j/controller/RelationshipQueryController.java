package tongji.datawarehouse.neo4j.controller;

import org.neo4j.ogm.compiler.SrcTargetKey;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;
import tongji.datawarehouse.neo4j.domainclass.Coo;
import tongji.datawarehouse.neo4j.domainclass.Movie;
import tongji.datawarehouse.neo4j.domainclass.Person;
import tongji.datawarehouse.neo4j.domainclass.relation.Direct;
import tongji.datawarehouse.neo4j.repository.CooRepository;
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

    private final CooRepository cooRepository;

    public RelationshipQueryController(CooRepository cooRepository) {
        this.cooRepository = cooRepository;
    }

    @RequestMapping(value = "/cooperationRanking", method = RequestMethod.GET)
    @Description("查找关系")
    public HashMap<String, Object> getRelationByTypeAndLength(@RequestParam Integer title, @RequestParam String type) {
        HashMap<String, Object> res = new HashMap<>();
        List<HashMap<String, Object>> rankingList = new ArrayList<>();
        if (type.equals("Director and Director")) {
            List<Coo> coos = cooRepository.getCoosOnDD(title);
            for (Coo c : coos) {
                rankingList.add(makeCooPair(c,"dd"));
            }
        } else if (type.equals("Director and Actor")) {
            List<Coo> coos = cooRepository.getCoosOnAD(title);
            for (Coo c : coos) {
                rankingList.add(makeCooPair(c,"ad"));
            }
        } else if (type.equals("Actor and Actor")) {
            List<Coo> coos = cooRepository.getCoosOnAA(title);
            for (Coo c : coos) {
                rankingList.add(makeCooPair(c,"aa"));
            }
        }
        res.put("count", rankingList.size());
        res.put("rankingList", rankingList);
        return res;
    }

    @RequestMapping(value = "cooperations/{pid}", method = RequestMethod.GET)
    @Description("根据人名查询合作关系")
    public HashMap<String, Object> getCooperationByNameAndTypeAndLength(@PathVariable("pid") String name, @RequestParam(required = true, defaultValue = "10") Integer title, @RequestParam(required = true, defaultValue = "All") String type) {
        HashMap<String, Object> res = new HashMap<>();
        List<HashMap<String, Object>> rankingList = new ArrayList<>();
        if (type.equals("All")) {
            List<Coo> coos = cooRepository.getCoosOnAllByName(name, title);
            for (Coo c : coos) {
                rankingList.add(makeCooPair(c,"times"));
            }
        } else if (type.equals("Director Only")) {
            List<Coo> coos = cooRepository.getCoosOnDirectorByName(name, title);
            for (Coo c : coos) {
                rankingList.add(makeCooPair(c,"times"));
            }
        } else if (type.equals("Actor Only")) {
            List<Coo> coos = cooRepository.getCoosOnActorByName(name, title);
            for (Coo c : coos) {
                rankingList.add(makeCooPair(c,"times"));
            }
        }
        res.put("count", rankingList.size());
        res.put("rankingList", rankingList);
        return res;
    }

    private HashMap<String, Object> makeCooPair(Coo coo,String  type) {
        HashMap<String, Object> res = new HashMap<>();
        HashMap<String, Object> person1 = new HashMap<>();
        HashMap<String, Object> person2 = new HashMap<>();
        Person p1 = coo.getStart();
        Person p2 = coo.getEnd();
        person1.put("personName", p1.getName());
        person1.put("isDirector", p1.getDirector());
        person1.put("isActor", p1.getActor());
        person2.put("personName", p2.getName());
        person2.put("isDirector", p2.getDirector());
        person2.put("isActor", p2.getActor());
        res.put("person1", person1);
        res.put("person2", person2);
        if (type.equals("times")){
            res.put("countOfCooperations", coo.getTimes());
        }else if (type.equals("dd")){
            res.put("countOfCooperations", coo.getDdTimes());
        }else if (type.equals("ad")){
            res.put("countOfCooperations", coo.getAdTimes());
        }else if (type.equals("aa")){
            res.put("countOfCooperations", coo.getAaTimes());
        }
        return res;
    }
}
