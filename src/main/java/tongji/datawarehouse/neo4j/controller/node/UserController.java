package tongji.datawarehouse.neo4j.controller.node;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.node.User;
import tongji.datawarehouse.neo4j.repository.node.UserRepository;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 20:37 2020/12/31
 * @Modified By:
 **/
@RestController
@RequestMapping("/neo4j/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/getUserByUid")
    public User getUserByUid(@RequestParam String uid){
        return  userRepository.getUserByName(uid);
    }

    @GetMapping("/getUserByProfileName")
    public Iterable<User> getUserListByProfileName(@RequestParam String profileName){
        return  userRepository.getUserListByProfileName(profileName);
    }
}
