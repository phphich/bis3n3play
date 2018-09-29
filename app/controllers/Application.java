package controllers;

import models.*;
import play.*;
import play.data.Form;
import play.libs.F;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {
    public static List<Student> studentList= new ArrayList<Student>();
    public static Form<Student> studentForm=Form.form(Student.class);
    public static Student student;

    public static List<Curriculum> curriculumList= new ArrayList<Curriculum>();
    public static Form<Curriculum> curriculumForm=Form.form(Curriculum.class);
    public static Curriculum curriculum;

    public static List<Faculty> facultyList = new ArrayList<Faculty>();

    public static Result index() {
        return ok();
    }

    public static Result listStudent() {
        studentList = Student.list();
        return ok(listStudent.render(studentList));
    }

    public static Result addStudent() {
        student = new Student("std001", "John Woo", "BIS.", 5.50);
        Student.create(student);
        student = new Student("std002", "Jee Hun", "BIS.", 3.50);
        Student.create(student);
        student = new Student("std003", "Jee Jee", "BMG.", 5.50);
        Student.create(student);
        student = new Student("std004", "Black Converse", "BMK.", 2.50);
        Student.create(student);
        student = new Student("std005", "Jusmine Jay", "BIT.", 1.50);
        Student.create(student);
        return listStudent();
    }


    public static Result getNewStudent() {
        studentForm=Form.form(Student.class);
        return ok(addNewStudent.render(studentForm));
    }

    public static Result createNewStudent(){
        Form<Student> newForm = studentForm.bindFromRequest();
        if (newForm.hasErrors()){
            flash("err", "ป้อนข้อมูลไม่สมบูรณ์/ไม่ถูกต้อง กรุณาตรวจสอบใหม่");
            return ok(addNewStudent.render(newForm));
        }else{
            student = newForm.get();
            Student tmp;
            tmp = Student.find.byId(student.getId());
            if(tmp==null) {
                Student.create(student);
                return listStudent();
            }else {
                flash("err", "รหัสนักศึกษาซ้ำกับที่มีอยู่ในระบบแล้ว กรุณาตรวจสอบใหม่");
                return ok(addNewStudent.render(newForm));
            }
        }
    }

    public static Result getUpdateStudent(String id) {
        student = Student.find.byId(id);
        if(student!=null){
            studentForm=Form.form(Student.class).fill(student);
            return ok(getUpdateStudent.render(studentForm));
        }else{
            return listStudent();
        }
    }

    public static Result updateStudent() {
        Form<Student> newForm = studentForm.bindFromRequest();
        if (newForm.hasErrors()) {
            flash("err", "ป้อนข้อมูลไม่สมบูรณ์/ไม่ถูกต้อง กรุณาตรวจสอบใหม่");
            return ok(getUpdateStudent.render(newForm));
        } else {
            student = newForm.get();
            Student.update(student);
            return listStudent();        }    }

    public static Result deleteStudent(String id){
        student = Student.find.byId(id);
        if(student!=null){
            Student.delete(student);
        }
        return listStudent();
    }

    public static Result listCurriculum() {
        curriculumList = Curriculum.list();
        return ok(listCurriculum.render(curriculumList));
    }

    public static Result getCurriculum() {
        facultyList=Faculty.list();
        curriculumForm = Form.form(Curriculum.class);
        return ok(getCurriculum.render(curriculumForm, facultyList));
    }

    public static Result createCurriculum() {
        Form<Curriculum> newForm = curriculumForm.bindFromRequest();
        if (newForm.hasErrors()){
            flash("err", "ป้อนข้อมูลไม่สมบูรณ์/ไม่ถูกต้อง กรุณาตรวจสอบใหม่");
            return ok(getCurriculum.render(newForm, facultyList));
        }else{
            curriculum = newForm.get();
            Curriculum tmp;
            tmp = Curriculum.finder.byId(curriculum.getId());
            if(tmp==null) {
                Curriculum.create(curriculum);
                return listCurriculum();
            }else {
                flash("err", "รหัสนักศึกษาซ้ำกับที่มีอยู่ในระบบแล้ว กรุณาตรวจสอบใหม่");
                return ok(getCurriculum.render(newForm, facultyList));
            }
        }
    }

    public static Result editCurriculum(String id) {
        curriculum = Curriculum.finder.byId(id);
        facultyList=Faculty.list();
        if(curriculum!=null){
            curriculumForm=Form.form(Curriculum.class).fill(curriculum);
            return ok(editCurriculum.render(curriculumForm,facultyList));
        }else{
            return listCurriculum();
        }
    }

    public static Result updateCurriculum(){
        Form<Curriculum> newForm = curriculumForm.bindFromRequest();
        if (newForm.hasErrors()){
            flash("err", "ป้อนข้อมูลไม่สมบูรณ์/ไม่ถูกต้อง กรุณาตรวจสอบใหม่");
            return ok(editCurriculum.render(newForm, facultyList));
        }else{
            curriculum = newForm.get();
            Curriculum.update(curriculum);
            return listCurriculum();
        }
    }


    public static Result deleteCurriculum(String id){
        curriculum = Curriculum.finder.byId(id);
        if(curriculum!=null){
            Curriculum.delete(curriculum);
        }
        return listCurriculum();
    }

}



