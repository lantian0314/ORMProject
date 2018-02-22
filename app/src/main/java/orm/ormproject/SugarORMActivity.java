package orm.ormproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import orm.ormproject.adapter.MyRecycleAdapter;
import orm.ormproject.db.Student;
import orm.ormproject.manager.StudentManager;

/**
 * Created by xingyatong on 2018/2/22.
 */
public class SugarORMActivity extends AppCompatActivity {
    private RecyclerView recyclerView=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sugarlayout);
        recyclerView=(RecyclerView)findViewById(R.id.recycle_view);
        StudentManager studentManager=new StudentManager();
        studentManager.saveStudent();
        studentManager.ishaveData();
        studentManager.searchByCondition("student_ID=?", "123456");
        List<Student> mList=studentManager.listAll();
        //创建适配器对象
        MyRecycleAdapter myRecycleAdapter=new MyRecycleAdapter(SugarORMActivity.this,mList);
        //设置适配器
        recyclerView.setAdapter(myRecycleAdapter);
        //布局管理器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
