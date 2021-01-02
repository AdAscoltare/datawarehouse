package tongji.datawarehouse.neo4j.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import tongji.datawarehouse.neo4j.domainclass.Coo;

import java.util.List;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 16:30 2021/1/2
 * @Modified By:
 **/
public interface CooRepository extends Neo4jRepository<Coo,Long> {

    @Query("match (p:Person{name:$name})-[r:coo]-(p2:Person) return r,collect(p),collect(p2) order by r.times desc limit $length")
    List<Coo> getCoosOnAllByName(String name,Integer length);
    @Query("match (p:Person{name:$name})-[r:coo]-(p2:Director) return r,collect(p),collect(p2) order by r.times desc limit $length")
    List<Coo> getCoosOnDirectorByName(String name,Integer length);
    @Query("match (p:Person{name:$name})-[r:coo]-(p2:Actor) return r,collect(p),collect(p2) order by r.times desc limit $length")
    List<Coo> getCoosOnActorByName(String name,Integer length);


    @Query("match (p1:Director)-[r:coo]-(p2:Director) return r,collect(p1),collect(p2) order by r.ddTimes desc limit $length")
    List<Coo> getCoosOnDD(Integer length);
    @Query("match (p1:Actor)-[r:coo]-(p2:Director) return r,collect(p1),collect(p2) order by r.adTimes desc limit $length")
    List<Coo> getCoosOnAD(Integer length);
    @Query("match (p1:Actor)-[r:coo]-(p2:Actor) return r,collect(p1),collect(p2) order by r.aaTimes desc limit $length")
    List<Coo> getCoosOnAA(Integer length);
}
