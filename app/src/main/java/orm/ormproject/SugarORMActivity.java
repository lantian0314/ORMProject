package orm.ormproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import orm.ormproject.adapter.MyRecycleAdapter;
import orm.ormproject.db.Student;
import orm.ormproject.manager.StudentManager;

/**
 * Created by xingyatong on 2018/2/22.
 */
public class SugarORMActivity extends AppCompatActivity {
    @BindView(R.id.recycle_view)
    RecyclerView recyclerView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sugarlayout);
        ButterKnife.bind(this);
        StudentManager studentManager = new StudentManager();
        studentManager.saveStudent();
        studentManager.ishaveData();
        studentManager.searchByCondition("student_ID=?", "123456");
        List<Student> mList = studentManager.listAll();
        //创建适配器对象
        MyRecycleAdapter myRecycleAdapter = new MyRecycleAdapter(SugarORMActivity.this, mList);
        //设置适配器
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myRecycleAdapter);
        //布局管理器
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //瀑布流布局管理
        //StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //网格布局管理
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
//            @Override
//            public int getSpanSize(int position) {
//                return 0;
//            }
//        });
        //设置完则水平滑动
        //linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置布局管理器
//        recyclerView.setLayoutManager(linearLayoutManager);
        //recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setLayoutManager(gridLayoutManager);
        //设置监听
        myRecycleAdapter.setOnItemClickListener(new MyRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(SugarORMActivity.this, "第" + position + "个被点击", Toast.LENGTH_LONG).show();
            }
        });
    }
}
