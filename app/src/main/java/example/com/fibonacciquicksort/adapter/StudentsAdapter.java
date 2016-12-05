package example.com.fibonacciquicksort.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.com.fibonacciquicksort.R;
import example.com.fibonacciquicksort.util.StudentApplicationClass;
import example.com.fibonacciquicksort.util.StudentRecord;
import example.com.fibonacciquicksort.util.Utility;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> implements Utility
{

    List<StudentRecord> listStudentRecord;
    Context mContext;






    public StudentsAdapter(List<StudentRecord> listStudentRecord)
    {
        this.listStudentRecord = new ArrayList<>();
        this.listStudentRecord = listStudentRecord;
        mContext = StudentApplicationClass.getContext();
    }

    public void setData(List<StudentRecord> listStudentRecord)
    {
        this.listStudentRecord = listStudentRecord;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflating_detail_layout, parent, false); //Inflating the layout
        ViewHolder vhItem = new ViewHolder(v, viewType); //Creating ViewHolder and passing the object of type view
        return vhItem;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        StudentRecord sdR =listStudentRecord.get(position);

        holder.textViewRank.setText(String.valueOf(position+1));
        holder.textViewName.setText(sdR.getName());

        holder.textViewEnglish.setText(String.valueOf(sdR.getMapSubMark().get(ENGLISH)));
        holder.textViewMath.setText(String.valueOf(sdR.getMapSubMark().get(MATH)));
        holder.textViewScience.setText(String.valueOf(sdR.getMapSubMark().get(SCIENCE)));
        holder.textViewTotall.setText(String.valueOf(sdR.getTotal()));
    }



    @Override
    public int getItemCount()
    {
        if(listStudentRecord!=null)
          return listStudentRecord.size();

        else
            return 0;


    }




        public class ViewHolder extends RecyclerView.ViewHolder
        {


            TextView textViewRank,
                    textViewName,
                    textViewEnglish,
                    textViewMath,
                    textViewScience,
                    textViewTotall ;



            public ViewHolder(View itemView, int ViewType)
            {
                super(itemView);
                textViewRank= (TextView)itemView.findViewById(R.id.id_TextView_rank);
                textViewName= (TextView)itemView.findViewById(R.id.id_TextView_name);
                textViewEnglish= (TextView)itemView.findViewById(R.id.id_TextView_english);
                textViewMath= (TextView)itemView.findViewById(R.id.id_TextView_math);
                textViewScience= (TextView)itemView.findViewById(R.id.id_TextView_science);
                textViewTotall= (TextView)itemView.findViewById(R.id.id_TextView_total);
            }
        }
}
