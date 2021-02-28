package com.example.jsoupwebtooncrawling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] week = { "mon", "tue", "wed", "thu", "fri", "sat", "sun" };
    private String TargetURL = "https://comic.naver.com/webtoon/weekdayList.nhn?week=";
    private String TAG = "JsoupMain";
    private String htmlContentInStringFormat="";

    ArrayList<Webtoon> webtoons = new ArrayList<>();

    private Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
                jsoupAsyncTask.execute();
            }
        });
    }

    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                int dayOfWeek = 1;
                Document doc = Jsoup.connect(TargetURL + week[dayOfWeek]).get();

                Elements titles= doc.select("ul.img_list li");

                System.out.println("-------------------------------------------------------------");
                for(Element e: titles) {
                    String title = e.select("dl dt a").attr("title");
                    String writer = e.select("dl dd.desc a").text();
                    String star = e.select("dl dd div.rating_type strong").text();
                    String thumbnailSrc = e.select("div.thumb a img").attr("src");
                    String webtoonURL = "https://comic.naver.com" + e.select("div.thumb a").attr("href");

                    webtoons.add(new Webtoon(title, writer, star, thumbnailSrc, webtoonURL));
                    Log.d(TAG, title + ", " + writer + ", " + star + ", " + thumbnailSrc + ", " + webtoonURL);
                }
                Intent intent = new Intent(getApplicationContext(), WebtoonActivity.class);
                intent.putExtra("webtoons", webtoons);
                startActivity(intent);
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), "정보를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

        }

    }
}