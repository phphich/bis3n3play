package models;

import play.db.ebean.Model;
import scala.util.parsing.combinator.testing.Str;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by COM2-00-PC on 9/29/2018.
 */
@Entity
@Table(name = "tbCurriculum")
public class Curriculum extends Model{
    @Id
    private String id;
    private String thName, engName, level;
    private int year;
    @ManyToOne()
    private Faculty faculty;

    public Curriculum() {
    }

    public Curriculum(String id, String thName, String engName, String level, int year, Faculty curriculum) {
        this.id = id;
        this.thName = thName;
        this.engName = engName;
        this.level = level;
        this.year = year;
        this.faculty = curriculum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThName() {
        return thName;
    }

    public void setThName(String thName) {
        this.thName = thName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty curriculum) {
        this.faculty = curriculum;
    }

    /********** DB Management ************/
    public static Finder<String, Curriculum> finder
            = new Finder<String, Curriculum>(String.class, Curriculum.class);
    public static List<Curriculum> list() {
        return finder.all();
    }
    public static void create(Curriculum curriculum){
        curriculum.save();
    }
    public static void update(Curriculum curriculum){
        curriculum.update();
    }
    public static void  delete(Curriculum curriculum){
        curriculum.delete();
    }
}
