package com.example.school;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private static final String DRIVER = "net.sourceforge.jtds.jdbc.Driver";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.INTERNET},
                PackageManager.PERMISSION_GRANTED);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName(DRIVER);
            RecyclerView recyclerView = findViewById(R.id.list);
            ServiceAdapter adapter = new ServiceAdapter(this, Connector.getServices());
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void setInitialData() {
//
//        services.add(new Service(0, "Занятие с репетитором-носителем китайского языка", 1950, 7200, "пусто", 10, R.drawable.chinese));
//        services.add(new Service(0, "Индивидуальный урок немецкого языка с преподавателем-носителем языка", 1340, 6600, "пусто", 0, R.drawable.germany));
//        services.add(new Service(0, "Индивидуальный онлайн-урок японского языка по Skype", 1000, 4800, "пусто", 20, R.drawable.japan));
//        services.add(new Service(0, "Занятие с русскоязычным репетитором испанского языка", 1450, 3000, "пусто", 15, R.drawable.spanish));
//    }

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+79513582788"));
        startActivity(intent);
    }
}