package orm.ormproject.db;

import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Table;

import java.io.Serializable;

/**
 * Created by xingyatong on 2018/2/9.
 */
@Table
public class Student extends SugarRecord implements Serializable {

    @Column(name = "student_ID", unique = true)
    private String studentId;
    private String name;
    private int age;
    private String sex;

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
