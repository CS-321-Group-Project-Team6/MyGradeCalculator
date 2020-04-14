package com.example.mygradecalculator.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

//import com.example.mygradecalculator.R;
import com.example.mygradecalculator.R;
import com.example.mygradecalculator.ui.classes.ClassModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;


public class MyClassAdapter extends RecyclerView.Adapter<MyClassAdapter.ViewHolder> {
    private Context mContext;
    private List<ClassModel> madapterDataset;

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextInputEditText cName;
        public TextInputEditText cGPA;

        public ViewHolder(View itemView) {
            super(itemView);

            cName = (TextInputEditText) itemView.findViewById(R.id.class_name_edit_text);
            cGPA = (TextInputEditText) itemView.findViewById(R.id.class_gpa_edit_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ClassModel cpu = (ClassModel) view.getTag();

                    //Toast.makeText(view.getContext(), cpu.getPersonName()+" is "+ cpu.getJobProfile(), Toast.LENGTH_SHORT).show();

                }
            });

        }
    }

    public MyClassAdapter(Context context, List classModels) {
        madapterDataset = classModels;
        mContext = context;
    }

    /*@Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item_view_layout, )
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }*/

    /*@Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(personUtils.get(position));

        PersonUtils pu = personUtils.get(position);

        holder.pName.setText(pu.getPersonName());
        holder.pJobProfile.setText(pu.getJobProfile());

    }*/
}
