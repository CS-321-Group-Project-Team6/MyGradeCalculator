package com.example.mygradecalculator.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mygradecalculator.R;
import com.example.mygradecalculator.ui.classes.ClassModel;
import com.google.android.material.textfield.TextInputEditText;
import java.util.List;
import java.util.ArrayList;


public class MyClassAdapter extends RecyclerView.Adapter<MyClassAdapter.ViewHolder> {
    private Context mContext;
    private List<ClassModel> madapterDataset;

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextInputEditText cName;
        public TextInputEditText cGPA;

        public ViewHolder(View itemView) {
            super(itemView);

            cName = itemView.findViewById(R.id.class_name_edit_text);
            cGPA = itemView.findViewById(R.id.class_gpa_edit_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ClassModel cpu = (ClassModel) view.getTag();

                    Toast.makeText(view.getContext(), cpu.getClassName()+" is "+ cpu.getGPA(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    public MyClassAdapter(Context context, List classModels) {
        madapterDataset = classModels;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = View.inflate(mContext, R.layout.item_view_layout, null);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(madapterDataset.get(position));
        ClassModel cm = madapterDataset.get(position);
        cm.setGpa(madapterDataset.get(position).getGPA());
        cm.setClassName(madapterDataset.get(position).getClassName());
        //holder.itemView.setId(madapterDataset.size() + 1);
        holder.cName.setText(madapterDataset.get(position).getClassName());
        holder.cGPA.setText(madapterDataset.get(position).getGPA().toString());
        holder.itemView.setId(position);
        //holder.cGPA.setText(cm.getGPA().toString());

    }

    @Override
    public int getItemCount() {
        return madapterDataset.size();
    }
}
