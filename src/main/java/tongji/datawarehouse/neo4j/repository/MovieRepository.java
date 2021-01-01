package tongji.datawarehouse.neo4j.repository;

import com.sun.org.apache.bcel.internal.generic.FLOAD;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.Movie;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 17:10 2020/12/31
 * @Modified By:
 **/
public interface MovieRepository extends Neo4jRepository<Movie, Long> {
    Movie getMovieByName(String pid);

    Movie getMovieByRealTitle(String realTitle);

    @Query("MATCH (m:Movie),(a:Actor),(a2:Actor),(d:Director)" +
            "WHERE m.realTitle CONTAINS $title AND " +
            "m.score>=$scoreLargerThan AND " +
            "m.score<=$scoreLessThan AND " +
            "(m.year>$startYear OR " +
            "(m.month>=$startMonth AND m.year=$startYear) OR " +
            "(m.date>=$startDate AND m.month=$startMonth AND m.year=$startYear)) AND" +
            "(m.year<$endYear OR " +
            "(m.month<=$endMonth AND m.year=$endYear) OR " +
            "(m.date<=$endDate AND m.month=$endMonth AND m.year=$endYear)) AND " +
            "($genre='default' OR $genre IN m.genre ) AND " +
            "($actor='default' OR exists((a:Actor{name:$actor})-[:play_in]-(m:Movie))) AND " +
            "($leadActor='default' OR exists((a2:Actor{name:$leadActor})-[:leading]-(m:Movie))) AND " +
            "($director='default' OR exists((d:Director{name:$director})-[:direct]-(m:Movie))) AND " +
            "1<>2 " +
            "RETURN m")
    List<Movie> getMoviesByConditions(
            String title,
            Float scoreLargerThan,
            Float scoreLessThan,
            Integer startYear,
            Integer startMonth,
            Integer startDate,
            Integer endYear,
            Integer endMonth,
            Integer endDate,
            String genre,
            String actor,
            String leadActor,
            String director
    );

}
