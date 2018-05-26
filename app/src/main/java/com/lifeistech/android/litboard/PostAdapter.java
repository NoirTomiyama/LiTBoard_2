package com.lifeistech.android.litboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends ArrayAdapter<Post> {

    List<Post> items;

    @Override
    public int getCount(){
        return items.size();
    }

    @Override
    public Post getItem(int position){
        return items.get(position);
    }

    public PostAdapter(Context context,int resource,List<Post> objects){
        super(context,resource);
        items = objects;
    }

    public class ViewHolder {
        TextView userNameText;
        TextView messageText;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        Post item = getItem(getCount() - 1 - position);
        final ViewHolder viewHolder;

        if(convertView != null){
            viewHolder = (ViewHolder)convertView.getTag();
        }else{
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_item_post,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.userNameText = (TextView)convertView.findViewById(R.id.username);
            viewHolder.messageText = (TextView)convertView.findViewById(R.id.message);

            convertView.setTag(viewHolder);
        }

        viewHolder.userNameText.setText(item.getUserName());
        viewHolder.messageText.setText(item.getMessage());


        return convertView;
    }
}
