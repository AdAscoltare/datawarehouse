package tongji.datawarehouse.neo4j.controller.node;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.node.Actor;
import tongji.datawarehouse.neo4j.repository.node.ActorRepository;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 20:19 2020/12/31
 * @Modified By:
 **/

@RestController
@RequestMapping("/neo4j/actor")
public class ActorController {
    private final ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @RequestMapping("/getActorByName")
    public Actor getActorByName(@RequestParam String name) {
        return actorRepository.getActorByName(name);
    }
}
