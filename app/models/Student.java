package models;
import play.db.ebean.Model;
import scala.util.parsing.combinator.testing.Str;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;/**
 * Created by COM2-00-PC on 9/10/2018.
 */
@Entity
@Table(name="tbStudent")
public class Student extends Model {
    @Id
    private String id;
    private String name, major;
    private double gpa;
    public Student() {    }
    public Student(String id, String name, String major, double gpa) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.gpa = gpa;    }
    public String getId() {        return id;    }
    public void setId(String id) {        this.id = id;    }
    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }
    public String getMajor() {        return major;    }
    public void setMajor(String major) {        this.major = major;    }
    public double getGpa() {        return gpa;    }
    public void setGpa(double gpa) {        this.gpa = gpa;    }
    //****************************************//
    public static Finder<String, Student> find =
            new Finder<String, Student>(String.class, Student.class);
    public static List<Student> list() {        return find.all();    }
    public static void create(Student student){        student.save();    }
    public static void update(Student student){        student.update();    }
    public static void delete(Student student){        student.delete();    }}


