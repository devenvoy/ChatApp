package com.example.chatapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class CallFragment extends Fragment {

    SearchView searchView;
    ListView listView;
    Spinner college;
    Button submit;
    TextView txtview;

    String[] courseList = {"BCA", "BBA", "B.COM", "MCA", "MBA", "M.COM", "B.Tech", "It", "BSC"};
    String[] collgeList = {"SDJ", "DRB", "Sutex", "SVPatel", "CK", "PPSU", "Tapi", "Vivekanand", "etc.."};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_call, container, false);
        searchView = (SearchView) view.findViewById(R.id.searchView);
        listView = view.findViewById(R.id.courselist);
        college = view.findViewById(R.id.collegespinner);
        submit = view.findViewById(R.id.submit);
        txtview = view.findViewById(R.id.txtview);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, courseList);
        ArrayAdapter sadapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, collgeList);
        listView.setAdapter(adapter);
        college.setAdapter(sadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtview.setText(courseList[position]);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext()).setTitle(txtview.getText())
                        .setMessage(college.getSelectedItem().toString()).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                getActivity().finishAffinity();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}