package tongji.datawarehouse.neo4j.controller.relation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.relation.PlayIn;
import tongji.datawarehouse.neo4j.repository.relation.PlayInRepository;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 21:02 2020/12/31
 * @Modified By:
 **/
@RestController
@RequestMapping("/neo4j/playin")
public class PlayInController {

    private  final PlayInRepository playInRepository;

    public PlayInController(PlayInRepository playInRepository) {
        this.playInRepository = playInRepository;
    }

    @GetMapping("/getAllPlayIn")
    public List<PlayIn> getAllPlayIn(){
        return playInRepository.getALlPlayIn();
    }
}
