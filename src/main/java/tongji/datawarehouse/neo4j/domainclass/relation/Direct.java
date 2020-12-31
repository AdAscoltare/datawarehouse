package tongji.datawarehouse.neo4j.domainclass.relation;

import org.neo4j.ogm.annotation.*;
import tongji.datawarehouse.neo4j.domainclass.node.Director;
import tongji.datawarehouse.neo4j.domainclass.node.Movie;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 18:22 2020/12/31
 * @Modified By:
 **/
@RelationshipEntity(type = "direct")
public class Direct {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Director director;

    @EndNode
    private Movie movie;

    public Direct() {
    }

    public Direct(Director director, Movie movie) {
        this.director = director;
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
