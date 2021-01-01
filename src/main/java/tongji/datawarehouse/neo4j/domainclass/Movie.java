package tongji.datawarehouse.neo4j.domainclass;


import org.neo4j.ogm.annotation.NodeEntity;
import tongji.datawarehouse.neo4j.domainclass.node.Product;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 17:01 2020/12/31
 * @Modified By:
 **/
@NodeEntity(label="Movie")
public class Movie extends Product {
    private Integer date;
    private Integer month;
    private Integer year;
    private Float score;
    private String realTitle;
    private String[] genre;
    private String[] version;

    public Movie() {
    }

    public Movie(String name, String title, Integer date, Integer month, Integer year, Float score, String realTitle, String[] genre, String[] version) {
        super(name, title);
        this.date = date;
        this.month = month;
        this.year = year;
        this.score = score;
        this.realTitle = realTitle;
        this.genre = genre;
        this.version = version;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getRealTitle() {
        return realTitle;
    }

    public void setRealTitle(String realTitle) {
        this.realTitle = realTitle;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String[] getVersion() {
        return version;
    }

    public void setVersion(String[] version) {
        this.version = version;
    }
}
