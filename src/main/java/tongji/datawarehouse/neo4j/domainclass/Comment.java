package tongji.datawarehouse.neo4j.domainclass;

import org.neo4j.ogm.annotation.*;
import tongji.datawarehouse.neo4j.domainclass.node.Product;
import tongji.datawarehouse.neo4j.domainclass.node.User;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 19:44 2020/12/31
 * @Modified By:
 **/
@RelationshipEntity(type = "comment")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private User user;

    @EndNode
    private Product product;

    private String summary;
    private String score;
    private String time;
    private String text;
    private String helpfulness;

    public Comment() {
    }

    public Comment(User user, Product product, String summary, String score, String time, String text, String helpfulness) {
        this.user = user;
        this.product = product;
        this.summary = summary;
        this.score = score;
        this.time = time;
        this.text = text;
        this.helpfulness = helpfulness;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHelpfulness() {
        return helpfulness;
    }

    public void setHelpfulness(String helpfulness) {
        this.helpfulness = helpfulness;
    }
}
