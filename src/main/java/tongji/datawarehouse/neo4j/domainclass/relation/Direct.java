package tongji.datawarehouse.neo4j.domainclass.relation;

import org.neo4j.ogm.annotation.*;
import tongji.datawarehouse.neo4j.domainclass.Movie;
import tongji.datawarehouse.neo4j.domainclass.Person;

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
    private Person director;

    @EndNode
    private Movie movie;

    public Direct() {
    }

    public Direct(Person director, Movie movie) {
        this.director = director;
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
