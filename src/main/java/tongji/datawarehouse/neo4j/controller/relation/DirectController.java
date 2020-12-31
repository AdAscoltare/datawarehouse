package tongji.datawarehouse.neo4j.controller.relation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.relation.Direct;
import tongji.datawarehouse.neo4j.repository.relation.DirectRepository;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 18:28 2020/12/31
 * @Modified By:
 **/

@RestController
@RequestMapping("/neo4j/direct")
public class DirectController {
    private final DirectRepository directRepository;

    public DirectController(DirectRepository directRepository) {
        this.directRepository = directRepository;
    }
    @GetMapping("/getAllDirect")
    public List<Direct> getAllDirect(){
        return directRepository.getALlDirect();
    }
}
