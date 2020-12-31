package tongji.datawarehouse.neo4j.controller.relation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.relation.Direct;
import tongji.datawarehouse.neo4j.domainclass.relation.Leading;
import tongji.datawarehouse.neo4j.repository.relation.LeadingRepository;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 18:28 2020/12/31
 * @Modified By:
 **/

@RestController
@RequestMapping("/neo4j/leading")
public class LeadingController {
    private final LeadingRepository leadingRepository;

    public LeadingController(LeadingRepository leadingRepository) {
        this.leadingRepository = leadingRepository;
    }

    @GetMapping("/getAllLeading")
    public List<Leading> getAllLeading(){
        return leadingRepository.getALlLeading();
    }
}
