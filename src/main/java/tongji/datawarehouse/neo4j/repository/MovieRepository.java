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

    //没有角色查询
    @Query(
            "MATCH(m:Movie)" +
                    "WHERE" +
                    "($title='' OR m.realTitle = $title) AND " +

                    "($scoreLargerThan<0.01 OR m.score>=$scoreLargerThan) AND " +
                    "($scoreLessThan>5.0 OR m.score<=$scoreLessThan) AND " +

                    "(($startYear=1000 OR m.year>$startYear) OR " +
                    "($startMonth=32 OR m.month>=$startMonth AND m.year=$startYear) OR " +
                    "($startDate=32 OR m.date>=$startDate AND m.month=$startMonth AND m.year=$startYear)) AND" +
                    "(($endYear=1000 OR m.year<$endYear) OR " +
                    "($endMonth=32 OR m.month<=$endMonth AND m.year=$endYear) OR " +
                    "($endDate=32 OR m.date<=$endDate AND m.month=$endMonth AND m.year=$endYear)) AND " +
                    "($genre='default' OR $genre IN m.genre )" +
                    "RETURN m")
    List<Movie> getMoviesByConditionsWithoutALD(
            String title,
            Float scoreLargerThan,
            Float scoreLessThan,
            Integer startYear,
            Integer startMonth,
            Integer startDate,
            Integer endYear,
            Integer endMonth,
            Integer endDate,
            String genre
    );

    //查询主演
    @Query(
            "MATCH(m:Movie)-[:leading]-(:Actor{name:$leadActor})" +
                    "WHERE" +
                    "($title='' OR m.realTitle = $title) AND " +

                    "($scoreLargerThan<0.01 OR m.score>=$scoreLargerThan) AND " +
                    "($scoreLessThan>5.0 OR m.score<=$scoreLessThan) AND " +

                    "(($startYear=1000 OR m.year>$startYear) OR " +
                    "($startMonth=32 OR m.month>=$startMonth AND m.year=$startYear) OR " +
                    "($startDate=32 OR m.date>=$startDate AND m.month=$startMonth AND m.year=$startYear)) AND" +
                    "(($endYear=1000 OR m.year<$endYear) OR " +
                    "($endMonth=32 OR m.month<=$endMonth AND m.year=$endYear) OR " +
                    "($endDate=32 OR m.date<=$endDate AND m.month=$endMonth AND m.year=$endYear)) AND " +
                    "($genre='default' OR $genre IN m.genre )" +
                    "RETURN m")
    List<Movie> getMoviesByConditionsWithL(
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
            String leadActor
    );
    //查询出演
    @Query(
            "MATCH(m:Movie)-[:play_in]-(:Actor{name:$actor})" +
                    "WHERE" +
                    "($title='' OR m.realTitle = $title) AND " +

                    "($scoreLargerThan<0.01 OR m.score>=$scoreLargerThan) AND " +
                    "($scoreLessThan>5.0 OR m.score<=$scoreLessThan) AND " +

                    "(($startYear=1000 OR m.year>$startYear) OR " +
                    "($startMonth=32 OR m.month>=$startMonth AND m.year=$startYear) OR " +
                    "($startDate=32 OR m.date>=$startDate AND m.month=$startMonth AND m.year=$startYear)) AND" +
                    "(($endYear=1000 OR m.year<$endYear) OR " +
                    "($endMonth=32 OR m.month<=$endMonth AND m.year=$endYear) OR " +
                    "($endDate=32 OR m.date<=$endDate AND m.month=$endMonth AND m.year=$endYear)) AND " +
                    "($genre='default' OR $genre IN m.genre )" +
                    "RETURN m")
    List<Movie> getMoviesByConditionsWithA(
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
            String actor
    );

    //查询导演
    @Query(
            "MATCH(m:Movie)-[:direct]-(:Director{name:$director})" +
                    "WHERE" +
                    "($title='' OR m.realTitle = $title) AND " +

                    "($scoreLargerThan<0.01 OR m.score>=$scoreLargerThan) AND " +
                    "($scoreLessThan>5.0 OR m.score<=$scoreLessThan) AND " +

                    "(($startYear=1000 OR m.year>$startYear) OR " +
                    "($startMonth=32 OR m.month>=$startMonth AND m.year=$startYear) OR " +
                    "($startDate=32 OR m.date>=$startDate AND m.month=$startMonth AND m.year=$startYear)) AND" +
                    "(($endYear=1000 OR m.year<$endYear) OR " +
                    "($endMonth=32 OR m.month<=$endMonth AND m.year=$endYear) OR " +
                    "($endDate=32 OR m.date<=$endDate AND m.month=$endMonth AND m.year=$endYear)) AND " +
                    "($genre='default' OR $genre IN m.genre )" +
                    "RETURN m")
    List<Movie> getMoviesByConditionsWithD(
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
            String director
    );

    //查询参演和导演
    @Query(
            "MATCH(m:Movie)-[:direct]-(:Director{name:$director})" +
                    "with m match (m)-[:play_in]-(:Actor{name:$actor})"+
                    "WHERE" +
                    "($title='' OR m.realTitle = $title) AND " +

                    "($scoreLargerThan<0.01 OR m.score>=$scoreLargerThan) AND " +
                    "($scoreLessThan>5.0 OR m.score<=$scoreLessThan) AND " +

                    "(($startYear=1000 OR m.year>$startYear) OR " +
                    "($startMonth=32 OR m.month>=$startMonth AND m.year=$startYear) OR " +
                    "($startDate=32 OR m.date>=$startDate AND m.month=$startMonth AND m.year=$startYear)) AND" +
                    "(($endYear=1000 OR m.year<$endYear) OR " +
                    "($endMonth=32 OR m.month<=$endMonth AND m.year=$endYear) OR " +
                    "($endDate=32 OR m.date<=$endDate AND m.month=$endMonth AND m.year=$endYear)) AND " +
                    "($genre='default' OR $genre IN m.genre )" +
                    "RETURN m")
    List<Movie> getMoviesByConditionsWithAD(
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
            String director
    );

    //查询参演和主演
    @Query(
            "MATCH(m:Movie)-[:leading]-(:Actor{name:$leadActor})" +
                    "with m match (m)-[:play_in]-(:Actor{name:$actor})"+
                    "WHERE" +
                    "($title='' OR m.realTitle = $title) AND " +

                    "($scoreLargerThan<0.01 OR m.score>=$scoreLargerThan) AND " +
                    "($scoreLessThan>5.0 OR m.score<=$scoreLessThan) AND " +

                    "(($startYear=1000 OR m.year>$startYear) OR " +
                    "($startMonth=32 OR m.month>=$startMonth AND m.year=$startYear) OR " +
                    "($startDate=32 OR m.date>=$startDate AND m.month=$startMonth AND m.year=$startYear)) AND" +
                    "(($endYear=1000 OR m.year<$endYear) OR " +
                    "($endMonth=32 OR m.month<=$endMonth AND m.year=$endYear) OR " +
                    "($endDate=32 OR m.date<=$endDate AND m.month=$endMonth AND m.year=$endYear)) AND " +
                    "($genre='default' OR $genre IN m.genre )" +
                    "RETURN m")
    List<Movie> getMoviesByConditionsWithAL(
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
            String leadActor
    );

    //查询导演和主演
    @Query(
            "MATCH(m:Movie)-[:leading]-(:Actor{name:$leadActor})" +
                    "with m match (m)-[:direct]-(:Director{name:$director})"+
                    "WHERE" +
                    "($title='' OR m.realTitle = $title) AND " +

                    "($scoreLargerThan<0.01 OR m.score>=$scoreLargerThan) AND " +
                    "($scoreLessThan>5.0 OR m.score<=$scoreLessThan) AND " +

                    "(($startYear=1000 OR m.year>$startYear) OR " +
                    "($startMonth=32 OR m.month>=$startMonth AND m.year=$startYear) OR " +
                    "($startDate=32 OR m.date>=$startDate AND m.month=$startMonth AND m.year=$startYear)) AND" +
                    "(($endYear=1000 OR m.year<$endYear) OR " +
                    "($endMonth=32 OR m.month<=$endMonth AND m.year=$endYear) OR " +
                    "($endDate=32 OR m.date<=$endDate AND m.month=$endMonth AND m.year=$endYear)) AND " +
                    "($genre='default' OR $genre IN m.genre )" +
                    "RETURN m")
    List<Movie> getMoviesByConditionsWithDL(
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
            String director,
            String leadActor
    );
    //全查
    @Query(
            "MATCH(m:Movie)-[:leading]-(:Actor{name:$leadActor})" +
                    "with m match (m)-[:direct]-(:Director{name:$director})"+
                    "with m match (m)-[:play_in]-(:Actor{name:$actor})"+
                    "WHERE" +
                    "($title='' OR m.realTitle = $title) AND " +

                    "($scoreLargerThan<0.01 OR m.score>=$scoreLargerThan) AND " +
                    "($scoreLessThan>5.0 OR m.score<=$scoreLessThan) AND " +

                    "(($startYear=1000 OR m.year>$startYear) OR " +
                    "($startMonth=32 OR m.month>=$startMonth AND m.year=$startYear) OR " +
                    "($startDate=32 OR m.date>=$startDate AND m.month=$startMonth AND m.year=$startYear)) AND" +
                    "(($endYear=1000 OR m.year<$endYear) OR " +
                    "($endMonth=32 OR m.month<=$endMonth AND m.year=$endYear) OR " +
                    "($endDate=32 OR m.date<=$endDate AND m.month=$endMonth AND m.year=$endYear)) AND " +
                    "($genre='default' OR $genre IN m.genre )" +
                    "RETURN m")
    List<Movie> getMoviesByConditionsWithADL(
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
            String director,
            String leadActor
    );
}
