package orm.ormproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.recycle_item, null);
        ListViewHolder listViewHolder = new ListViewHolder(view);
        return listViewHolder;

    }

    @Override
    public void onBindViewHolder(final ListViewHolder holder, final int position) {
        Student student = mList.get(position);
        holder.setData(student);
        //如果设置了监听，就设置回调
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (mList != null && mList.size() > 0) {
            return mList.size();
        }
        return 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_studentid)
        public TextView txt_id;
        @BindView(R.id.txt_name)
        TextView txt_name;
        @BindView(R.id.txt_studentAge)
        TextView txt_age;
        @BindView(R.id.txt_sex)
        TextView txt_sex;

        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(ListViewHolder.this, itemView);
        }

        public void setData(Student student) {
            txt_id.setText("学生ID: " + student.getStudentId());
            //txt_id.setHeight((int) (100 + Math.random() * 30));
            txt_name.setText("学生姓名: " + student.getName());
            //txt_name.setHeight((int) (100 + Math.random() * 30));
            txt_age.setText("学生年龄: " + String.valueOf(student.getAge()));
            txt_sex.setText("学生性别: " + student.getSex());
        }
    }

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
