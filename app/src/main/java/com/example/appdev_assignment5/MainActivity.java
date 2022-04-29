package com.example.appdev_assignment5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static int index = 0;
    ArrayList<String> textmsg;
    ArrayList<String> name;
    ArrayList<String> time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textmsg = new ArrayList<>();
        textmsg.add("Some message");
        textmsg.add("Another message");
        textmsg.add("Another message");
        textmsg.add("Another message");
        textmsg.add("Another message");
        textmsg.add("Another message");
        textmsg.add("Another message");
        textmsg.add("Another message");
        textmsg.add("Another message");
        textmsg.add("Another message");
        textmsg.add("Another message");
        textmsg.add("Another message");
        textmsg.add("Another message");
        textmsg.add("Another message");
        textmsg.add("Last message");

        name = new ArrayList<>();
        name.add("MR.WUHAN");
        name.add("ICH");
        name.add("MR.WUHAN");
        name.add("ICH");
        name.add("MR.WUHAN");
        name.add("ICH");
        name.add("MR.WUHAN");
        name.add("MR.WUHAN");
        name.add("MR.WUHAN");
        name.add("MR.WUHAN");
        name.add("MR.WUHAN");
        name.add("ICH");
        name.add("MR.WUHAN");
        name.add("ICH");
        name.add("MR.WUHAN");


        time = new ArrayList<>();
        time.add("10:21 AM");
        time.add("10:21 AM");
        time.add("10:21 AM");
        time.add("10:21 AM");
        time.add("10:22 AM");
        time.add("10:22 AM");
        time.add("10:22 AM");
        time.add("10:22 AM");
        time.add("10:23 AM");
        time.add("10:23 AM");
        time.add("10:23 AM");
        time.add("10:23 AM");
        time.add("10:24 AM");
        time.add("10:24 AM");
        time.add("10:24 AM");
        time.add("10:24 AM");

        index = 14;

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new RecyclerviewAdapter(this, textmsg, name, time);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);



        FloatingActionButton fab = findViewById(R.id.floatingActionButton2);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(view.getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialog);

                TextInputEditText input = dialog.findViewById(R.id.textinputlayout);
                Button send = dialog.findViewById(R.id.button);
                Button close = dialog.findViewById(R.id.button2);
                Spinner spinner = dialog.findViewById(R.id.spinner);

                send.setOnClickListener(e -> {
                    String messagetext = input.getText().toString();

                    textmsg.add(messagetext);

                    if(spinner.getSelectedItem().toString().equals("ICH")) {
                        name.add("ICH");
                    }
                    else{
                        name.add("MR.WUHAN");
                    }


                    time.add("10:25 AM");
                    index++;
                    RecyclerView.Adapter adapter = new RecyclerviewAdapter(getApplicationContext(), textmsg, name, time);
                    recyclerView.setAdapter(adapter);
                    //recyclerView.getAdapter().notifyDataSetChanged();
                    //RecyclerviewAdapter.name_index = name.size()-1;

                    Snackbar snackbar = Snackbar
                            .make(view, "message sent", Snackbar.LENGTH_LONG)
                            .setAction("UNDO", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    textmsg.remove(messagetext);
                                    name.remove(index);
                                    index--;
                                    RecyclerView.Adapter adapter = new RecyclerviewAdapter(getApplicationContext(), textmsg, name, time);
                                    recyclerView.setAdapter(adapter);
                                    //recyclerView.getAdapter().notifyDataSetChanged();
                                }
                            });

                    snackbar.show();
                    //recyclerView.getAdapter().notifyDataSetChanged();
                    dialog.dismiss();
                });

                close.setOnClickListener(e->{
                    //recyclerView.getAdapter().notifyDataSetChanged();
                    dialog.dismiss();
                });



                dialog.show();
            }

            /*
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String messagetext = input.getText().toString();
                    textmsg.add(messagetext);
                    name.add("ICH");
                    time.add("10:25 AM");
                }
            });

             */
        });




    }

    void showDialog(){
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog);

        TextInputEditText input = dialog.findViewById(R.id.textinputlayout);
        Button send = dialog.findViewById(R.id.button);

        send.setOnClickListener(e -> {
            String messagetext = input.getText().toString();
            //textmsg.add(messagetext);
            //name.add("ICH");
            //time.add("10:25 AM");
        });

        dialog.show();
    }


}

