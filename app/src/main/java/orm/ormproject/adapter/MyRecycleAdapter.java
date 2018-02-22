package orm.ormproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import orm.ormproject.R;
import orm.ormproject.db.Student;

/**
 * Created by xingyatong on 2018/2/22.
 */
public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ListViewHolder> {

    private Context mContext;
    private List<Student> mList;

    public MyRecycleAdapter(Context context, List<Student> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public MyRecycleAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.recycle_item, null);
        ListViewHolder listViewHolder = new ListViewHolder(view);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        Student student = mList.get(position);
        holder.setData(student);
    }

    @Override
    public int getItemCount() {
        if (mList != null && mList.size() > 0) {
            return mList.size();
        }
        return 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_id;
        private TextView txt_name;
        private TextView txt_age;
        private TextView txt_sex;

        public ListViewHolder(View itemView) {
            super(itemView);
            txt_id = itemView.findViewById(R.id.txt_studentid);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_age = itemView.findViewById(R.id.txt_studentAge);
            txt_sex = itemView.findViewById(R.id.txt_sex);
        }

        public void setData(Student student) {
            txt_id.setText("学生ID: " + student.getStudentId());
            txt_name.setText("学生姓名: " + student.getName());
            txt_age.setText("学生年龄: " + String.valueOf(student.getAge()));
            txt_sex.setText("学生性别: " + student.getSex());
        }
    }
}
