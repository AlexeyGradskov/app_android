package com.example.school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        ArrayList<Service> services = new ArrayList<Service>();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setInitialData();
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
            ServiceAdapter adapter = new ServiceAdapter(this, services);
            recyclerView.setAdapter(adapter);
        }
        private void setInitialData(){

            services.add(new Service (0, "Занятие с репетитором-носителем китайского языка", 1950, 7200, "пусто", 10, R.drawable.chinese));
            services.add(new Service (0, "Индивидуальный урок немецкого языка с преподавателем-носителем языка", 1340, 6600, "пусто", 0, R.drawable.germany));
            services.add(new Service (0, "Индивидуальный онлайн-урок японского языка по Skype", 1000, 4800, "пусто", 20, R.drawable.japan));
            services.add(new Service (0, "Занятие с русскоязычным репетитором испанского языка", 1450, 3000, "пусто", 15, R.drawable.spanish));
        }

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+79513582788"));
        startActivity(intent);
    }
}