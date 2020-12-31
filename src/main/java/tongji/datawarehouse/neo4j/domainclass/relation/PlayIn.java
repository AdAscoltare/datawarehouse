package tongji.datawarehouse.neo4j.domainclass.relation;

import jdk.jfr.StackTrace;
import org.neo4j.ogm.annotation.*;
import tongji.datawarehouse.neo4j.domainclass.node.Actor;
import tongji.datawarehouse.neo4j.domainclass.node.Movie;

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
    Actor actor;
    @EndNode
    Movie movie;

    public PlayIn() {
    }

    public PlayIn(Actor actor, Movie movie) {
        this.actor = actor;
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
