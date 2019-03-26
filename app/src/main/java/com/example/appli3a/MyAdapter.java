package com.example.appli3a;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CelluleJava> {
    private List<Api> listValues;

    public class CelluleJava extends RecyclerView.ViewHolder {

        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView image;
        public View layout;

        public CelluleJava(View v) {
            super(v);
            layout = v;
            txtHeader =  v.findViewById(R.id.firstLine);
            txtFooter =  v.findViewById(R.id.secondLine);
            image = v.findViewById(R.id.icon);
        }
    }

    public void add(int position, Api item) {
        listValues.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        listValues.remove(position);
        notifyItemRemoved(position);
    }

    public MyAdapter(List<Api> listValues) {
        this.listValues = listValues;
    }

    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent,int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CelluleJava holder, final int position) {

        Api currentGod = listValues.get(position);
        final String name = currentGod.getName();
        final String description = currentGod.getDescription();
        holder.txtHeader.setText(name);
        holder.txtFooter.setText(description);

        //TODO image

    }
    @Override
    public int getItemCount() {
        return listValues.size();
    }
}
