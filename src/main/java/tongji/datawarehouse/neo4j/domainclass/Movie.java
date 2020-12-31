package tongji.datawarehouse.neo4j.domainclass;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 17:01 2020/12/31
 * @Modified By:
 **/
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String date;
    private String month;
    private String year;
    private String score;
    private String realTitle;
    private String title;
    private String[] genre;
    private String[] version;

    public Movie() {
    }

    public Movie(String name, String date, String month, String year, String score, String realTitle, String title, String[] genre, String[] version) {
        this.name = name;
        this.date = date;
        this.month = month;
        this.year = year;
        this.score = score;
        this.realTitle = realTitle;
        this.title = title;
        this.genre = genre;
        this.version = version;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRealTitle() {
        return realTitle;
    }

    public void setRealTitle(String realTitle) {
        this.realTitle = realTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
