package com.example.tbtapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tbtapp.Foot;
import com.example.tbtapp.R;

import java.util.ArrayList;

public class FootListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Foot> footsList;

    public FootListAdapter(Context context, int layout, ArrayList<Foot> footsList){
        this.context = context;
        this.layout = layout;
        this.footsList = footsList;
    }

    @Override
    public int getCount() {
        return footsList.size();
    }

    @Override
    public Object getItem(int position) {
        return footsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView txtName, txtPrice, txtSize, txtAngle;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView)row.findViewById(R.id.txtName);
            holder.txtPrice = (TextView)row.findViewById(R.id.txtPrice);
            holder.txtSize = (TextView)row.findViewById(R.id.txtSize);
            holder.txtAngle = (TextView)row.findViewById(R.id.txtAngle);
            holder.imageView = (ImageView)row.findViewById(R.id.imgFoot);
            row.setTag(holder);
        }
        else{
            holder = (ViewHolder) row.getTag();
        }
        Foot foot = footsList.get(position);

        holder.txtName.setText(foot.getName());
        holder.txtPrice.setText(foot.getPrice());
        holder.txtSize.setText(foot.getSize());
        holder.txtAngle.setText(foot.getAngle());
        byte[] footImage = foot.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(footImage, 0, footImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
