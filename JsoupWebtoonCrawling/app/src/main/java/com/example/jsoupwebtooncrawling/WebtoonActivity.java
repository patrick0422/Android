package com.example.jsoupwebtooncrawling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class WebtoonActivity extends AppCompatActivity {
    private String TAG = "JsoupWebtoon";

    private String TargetURL = "https://comic.naver.com/webtoon/weekdayList.nhn?week=";

    private String[] week = { "mon", "tue", "wed", "thu", "fri", "sat", "sun" };
    private String[] weekKor = { "월", "화", "수", "목", "금", "토", "일" };

    private ArrayList<Webtoon> webtoons = new ArrayList<>();
    private WebtoonAdapter adapter;
    private WebtoonActivity.JsoupAsyncTask jsoupAsyncTask;

    private EditText etSearch;
    private Button btnSearch;
    private ImageButton btnRefresh;
    private RadioGroup rg1;

    private int dayOfWeek = 0;

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webtoon);

        //1
        etSearch = findViewById(R.id.etSearch);
        // 2. 검색 버튼 클릭시 이벤트
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 3. 리스트 아이템 선택시 이벤트
        jsoupAsyncTask = new WebtoonActivity.JsoupAsyncTask();
        jsoupAsyncTask.execute();

        adapter = new WebtoonAdapter(webtoons);
        list = findViewById(R.id.webtoonList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webtoons.get(position).WebtoonURL()));
                startActivity(webIntent);
            }
        });

        // 4. 요일 선택 접는 버튼
//        btnRefresh = findViewById(R.id.btnRefresh);
//        btnRefresh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (rg1.getVisibility() == GONE)
//                    rg1.setVisibility(VISIBLE);
//                else
//                    rg1.setVisibility(GONE);
//            }
//        });

        // 5. 요일 선택 시 이벤트
        rg1 = findViewById(R.id.rg1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(rg1.getCheckedRadioButtonId());
                
                switch(rb.getText().toString()) {
                    case "월":
                        dayOfWeek = 0;
                        break;
                    case "화":
                        dayOfWeek = 1;
                        break;
                    case "수":
                        dayOfWeek = 2;
                        break;
                    case "목":
                        dayOfWeek = 3;
                        break;
                    case "금":
                        dayOfWeek = 4;
                        break;
                    case "토":
                        dayOfWeek = 5;
                        break;
                    case "일":
                        dayOfWeek = 6;
                        break;
                }

                jsoupAsyncTask = new WebtoonActivity.JsoupAsyncTask();
                jsoupAsyncTask.execute();
            }
        });

        //

    }




    protected class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {
        private Document doc;
        private Elements titles;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                doc = Jsoup.connect(TargetURL + week[dayOfWeek]).get();

                // 리스트 초기화
                webtoons.clear();
                Log.d(TAG, "리스트 초기화 완료");

                titles = doc.select("ul.img_list li");

                for(Element e: titles) {
                    Webtoon webtoon = new Webtoon(
                            //title
                            e.select("dl dt a").attr("title"),
                            //writer
                            e.select("dl dd.desc a").text(),
                            //star
                            e.select("dl dd div.rating_type strong").text(),
                            //thumbnailSrc
                            e.select("div.thumb a img").attr("src"),
                            //webtoonURL
                            "https://comic.naver.com" + e.select("div.thumb a").attr("href")
                    );
                    webtoons.add(webtoon);
                    list.deferNotifyDataSetChanged();
                }
                Log.d(TAG, weekKor[dayOfWeek] + "요일 웹툰 목록 저장 완료");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            adapter.notifyDataSetChanged();
        }
    }
}