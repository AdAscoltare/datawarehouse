package tongji.datawarehouse.neo4j.controller.node;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tongji.datawarehouse.neo4j.domainclass.node.Product;
import tongji.datawarehouse.neo4j.repository.node.ProductRepository;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 20:30 2020/12/31
 * @Modified By:
 **/
@RestController
@RequestMapping("/neo4j/product")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/getProductByPid")
    public Product getProductByName(@RequestParam String pid) {
        return productRepository.getProductByName(pid);
    }
}
