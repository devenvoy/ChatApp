package com.example.chatapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ChatFragment extends Fragment {

    ListView listView;


    public static class chat {
        String name;
        String lastMsg;
        int imgid;

        public chat(String name, String lastMsg, int imgid) {
            this.name = name;
            this.lastMsg = lastMsg;
            this.imgid = imgid;
        }
    }

    chat[] chatList = {
            new chat("Devansh", "Hi i am using whatsapp", R.drawable.user),
            new chat("Prince", "Hi i not using whatsapp", R.drawable.user),
            new chat("Riya", "Hi i will using whatsapp", R.drawable.user),
            new chat("Aryan", "Hi i will Not  whatsapp", R.drawable.user),
            new chat("Smit", "Hi i was using whatsapp", R.drawable.user)
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vv = inflater.inflate(R.layout.fragment_chat, container, false);
        listView = vv.findViewById(R.id.chatlist);
        return vv;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        MyChatAdapter chatAdapter = new MyChatAdapter(getActivity(), chatList);
        listView.setAdapter(chatAdapter);
    }
}