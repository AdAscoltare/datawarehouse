package tongji.datawarehouse.neo4j.controller.node;

import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.node.Person;
import tongji.datawarehouse.neo4j.repository.node.PersonRepository;

import java.util.HashMap;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 15:12 2021/1/1
 * @Modified By:
 **/
@RestController
@RequestMapping("/api/v1/movies/persons")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
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
