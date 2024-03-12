package com.example.chatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyChatAdapter extends BaseAdapter {
    Context context;
    ChatFragment.chat[] chatList;
    public MyChatAdapter(Context activity, ChatFragment.chat[] chatList) {
        this.context = activity;
        this.chatList = chatList;
    }


    @Override
    public int getCount() {
        return chatList.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.chat_item,parent,false);
        ImageView uimg = view.findViewById(R.id.userimg);
        TextView uname = view.findViewById(R.id.username);
        TextView udesc = view.findViewById(R.id.userdesc);
        uimg.setImageResource(chatList[position].imgid);
        uname.setText(chatList[position].name);
        udesc.setText(chatList[position].lastMsg);
        return view;
    }
}
