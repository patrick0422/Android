package com.example.jsoupwebtooncrawling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class WebtoonActivity extends AppCompatActivity {
    private ArrayList<Webtoon> webtoons;
    private String TAG = "JsoupWebtoon";

    private EditText etSearch;
    private Button btnSearch;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webtoon);

        Intent intent = getIntent();
        webtoons = (ArrayList<Webtoon>)intent.getSerializableExtra("webtoons");
        Log.d(TAG, webtoons.get(0).toString());

        etSearch = findViewById(R.id.etSearch);
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "아직 안만듬", Toast.LENGTH_SHORT).show();
            }
        });

        list = findViewById(R.id.lvWebtoon);
        final WebtoonAdapter adapter = new WebtoonAdapter(webtoons);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webtoons.get(position).WebtoonURL()));
                startActivity(webIntent);
            }
        });
    }
}