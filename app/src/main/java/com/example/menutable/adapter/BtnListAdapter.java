package com.example.menutable.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.menutable.R;
import com.example.menutable.model.BtnList;

import java.util.ArrayList;
import java.util.List;

public class BtnListAdapter extends RecyclerView.Adapter<BtnListAdapter.btnListViewHolder> {

    private Context context;
    private List<BtnList> btnArrayList = new ArrayList<>();

    public BtnListAdapter(Context context) {
        this.context = context;
    }

    public class btnListViewHolder extends RecyclerView.ViewHolder {
        public ImageView iconP;
        public TextView menuNum;

        public btnListViewHolder(View itemView) {
            super(itemView);
            iconP= itemView.findViewById(R.id.ic_pencil);
            menuNum = itemView.findViewById(R.id.menu_num);

          /*  itemView.setOnClickListener((View v) -> {
                //onClickItem.onClick(getAdapterPosition());
            });*/
        }
    }


    @Override
    public btnListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.btnlist_item, parent, false);
        btnListViewHolder viewHolder = new btnListViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(btnListViewHolder holder, int position) {
        BtnList Listitem = btnArrayList.get(position);

        setMenuNum(holder.menuNum, Listitem.listIndex);
        holder.iconP.setImageResource(R.drawable.ic_pencil);

    }

    private void setMenuNum(TextView text, int index){
        switch (index) {
            case 0:
                text.setText("메뉴1");
                break;
            case 1:
                text.setText("메뉴2");
                break;
            case 2:
                text.setText("메뉴3");
                break;
            case 3:
                text.setText("메뉴4");
                break;

        }
    }

    @Override
    public int getItemCount() { return btnArrayList.size(); }

    public void setList(ArrayList<BtnList> list) { this.btnArrayList = list;}



}
