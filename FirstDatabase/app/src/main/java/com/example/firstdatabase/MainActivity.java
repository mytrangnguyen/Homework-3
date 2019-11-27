package com.example.firstdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    UserDatabase db;
    TextView tvUser;
    RecyclerView recyclerViewNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewNumber = findViewById(R.id.recyclerViewUser);
        recyclerViewNumber.setLayoutManager(new LinearLayoutManager(this));
//        tvUser = findViewById(R.id.text_user);
        db = Room.databaseBuilder(getApplicationContext(),
                UserDatabase.class, "database-name").build();
        tvUser = findViewById(R.id.userItem);

        //có 2 cách tạo thread


        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                User user = new User("chang");
                db.userDao().insert(user);

                User user1 = new User("Huy");
                db.userDao().insert(user1);

                final List<User> users = db.userDao().getAll();
                Log.d("tag1", "size " + users.size());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayUser(users);
                    }
                });
                return null;
            }
        }.execute();
    }

    String name ="";
    void displayUser(List<User> users){
        final List<String> nameList = new ArrayList<>();
        for(int i = 0, len = users.size();i< len ;i++){
            Log.d("tag11",users.get(i).name);
            nameList.add(users.get(i).name);
        }
        final userAdapter adapter = new userAdapter();
        Log.d("tag111",nameList.get(0));
        adapter.userList= nameList;
        recyclerViewNumber.setAdapter(adapter);



    }
}
