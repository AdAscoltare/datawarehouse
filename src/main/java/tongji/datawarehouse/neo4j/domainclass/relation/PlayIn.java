package tongji.datawarehouse.neo4j.domainclass.relation;

import org.neo4j.ogm.annotation.*;
import tongji.datawarehouse.neo4j.domainclass.node.Movie;
import tongji.datawarehouse.neo4j.domainclass.node.Person;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 20:01 2020/12/31
 * @Modified By:
 **/
@RelationshipEntity(type = "play_in")
public class PlayIn {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    Person actor;
    @EndNode
    Movie movie;

    public PlayIn() {
    }

    public PlayIn(Person actor, Movie movie) {
        this.actor = actor;
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public Person getActor() {
        return actor;
    }

    public void setActor(Person actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
