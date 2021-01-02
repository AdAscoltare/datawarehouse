package tongji.datawarehouse.neo4j.domainclass;

import org.neo4j.ogm.annotation.*;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 16:28 2021/1/2
 * @Modified By:
 **/
@RelationshipEntity(type = "coo")
public class Coo {
    @Id
    @GeneratedValue
    private Long id;

    private Integer times;
    private Integer ddTimes;
    private Integer adTimes;
    private Integer aaTimes;

    @StartNode
    private Person start;
    @EndNode
    private Person end;

    public Coo() {
    }

    public Coo(Integer times, Integer ddTimes, Integer adTimes, Integer aaTimes, Person start, Person end) {
        this.times = times;
        this.ddTimes = ddTimes;
        this.adTimes = adTimes;
        this.aaTimes = aaTimes;
        this.start = start;
        this.end = end;
    }

    public Integer getDdTimes() {
        return ddTimes;
    }

    public void setDdTimes(Integer ddTimes) {
        this.ddTimes = ddTimes;
    }

    public Integer getAdTimes() {
        return adTimes;
    }

    public void setAdTimes(Integer adTimes) {
        this.adTimes = adTimes;
    }

    public Integer getAaTimes() {
        return aaTimes;
    }

    public void setAaTimes(Integer aaTimes) {
        this.aaTimes = aaTimes;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Long getId() {
        return id;
    }

    public Person getStart() {
        return start;
    }

    public void setStart(Person start) {
        this.start = start;
    }

    public Person getEnd() {
        return end;
    }

    public void setEnd(Person end) {
        this.end = end;
    }
}
