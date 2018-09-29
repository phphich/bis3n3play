package models;

import play.db.ebean.Model;
import play.libs.F;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by COM2-00-PC on 9/29/2018.
 */
@Entity
@Table(name = "tbFaculty")
public class Faculty  extends Model{
    @Id
    private String id;
    private String name, address;
    @OneToMany(mappedBy = "faculty", cascade= CascadeType.ALL)
    private List<Curriculum> curriculumList = new ArrayList<Curriculum>();

    public Faculty() {
    }

    public Faculty(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Curriculum> getCurriculumList() {
        return curriculumList;
    }

    /********** DB Management ************/
    public static Finder<String, Faculty> finder
            = new Finder<String, Faculty>(String.class, Faculty.class);

    public static List<Faculty> list() {
        return finder.all();
    }
    public static void create(Faculty faculty){
        faculty.save();
    }
    public static void update(Faculty faculty){
        faculty.update();
    }
    public static void delete(Faculty faculty){
        faculty.delete();
    }





}
