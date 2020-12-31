package tongji.datawarehouse.neo4j.neo4j.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.Director;
import tongji.datawarehouse.neo4j.repository.DirectorRepository;


import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 16:09 2020/12/31
 * @Modified By:
 **/
@RestController
@RequestMapping("/neo4j/director")
public class DirectorController {
    private final DirectorRepository directorRepository;

    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }
    @RequestMapping("/getallDirector")
    public List<Director> getAllDirctor(){
        return directorRepository.getAllDirector();
    }
}
