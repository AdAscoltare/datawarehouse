package tongji.datawarehouse.neo4j.domainclass.node;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 16:08 2021/1/1
 * @Modified By:
 **/
@NodeEntity(label = "Person")
public class Person {
    @Id
    @GeneratedValue
    protected Long id;
    protected String name;

    private Boolean isActor;
    private Boolean isDirector;

    public Person() {
    }

    public Person(String name, Boolean isActor, Boolean isDirector) {
        this.name = name;
        this.isActor = isActor;
        this.isDirector = isDirector;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActor() {
        return isActor;
    }

    public void setActor(Boolean actor) {
        isActor = actor;
    }

    public Boolean getDirector() {
        return isDirector;
    }

    public void setDirector(Boolean director) {
        isDirector = director;
    }
}
