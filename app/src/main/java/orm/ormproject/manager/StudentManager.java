package orm.ormproject.manager;

import java.util.List;

import orm.ormproject.db.Student;

/**
 * Created by xingyatong on 2018/2/22.
 */
public class StudentManager {

    public void saveStudent() {
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setStudentId(String.valueOf(i));
            student.setAge(15+i);
            student.setName("name");
            student.setSex("男");
            student.save();
        }


    }

    public boolean ishaveData() {
        long count = Student.count(Student.class);
        return count >= 0;
    }

    public List<Student> searchByCondition(String wherecause, String... whereargs) {
        List<Student> findList = Student.find(Student.class, wherecause, whereargs);
        return findList;
    }

    public List<Student> listAll() {
        List<Student> mList = Student.listAll(Student.class);
        return mList;
    }
}