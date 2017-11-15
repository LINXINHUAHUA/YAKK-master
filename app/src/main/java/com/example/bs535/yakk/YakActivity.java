package com.example.bs535.yakk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bs535.yakk.auxiliary.HttpUtil;
import com.example.bs535.yakk.auxiliary.Utilty;
import com.example.bs535.yakk.content.Yak;
import com.example.bs535.yakk.content.YakInfo;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.R.id.list;
import static com.example.bs535.yakk.auxiliary.Url.URL_Yak;
import static com.example.bs535.yakk.auxiliary.Url.URL_Yakinfo;


/**
 * Created by BS535 on 2017/11/7.
 */

public class YakActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final int LEVEL_Yak= 0;
    private static final int LEVEL_Yakinfo= 1;
    private static final String NUMBER_ID = "com.swun.student.activity.id";

    private int current;//当前选中的级别
    private Yak selectedYak;//选中的牦牛
    private int yakcode;//牦牛代号

    private TextView title;
    private Toolbar toolbar;
    private ListView list;
    private ProgressBar progressbar;
    private ArrayAdapter<String> adapter;

    private List<String> dataList = new ArrayList<>();
    private List<YakInfo> yakInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yaklist);

        //标题 toolbar
        initView();
        title.setText("我的牦牛");
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //获取传入的userid
        Intent intent = getIntent();
        yakcode = intent.getIntExtra(NUMBER_ID, 0);

        adapter = new ArrayAdapter<>(YakActivity.this, android
                .R.layout.simple_list_item_1, dataList);
        list.setAdapter(adapter);
        queryYakinfo();
    }
    private void initView() {
        title = (TextView) findViewById(R.id.toolbar_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        list = (ListView) findViewById(R.id.yak_list);
        progressbar = (ProgressBar) findViewById(R.id.yak_progressbar);

        list.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
    private void queryYakinfo() {
        yakInfoList = DataSupport.where("yakCode = ?", String.valueOf(yakcode)).find(YakInfo.class);
        if (yakInfoList.size() > 0) {
            dataList.clear();
            for (YakInfo yak : yakInfoList) {
                dataList.add(yak.getId());
            }
            adapter.notifyDataSetChanged();
            list.setSelection(0);
            current = LEVEL_Yak;
            progressbar.setVisibility(View.GONE);
        } else {
            String url = URL_Yakinfo + "?yakcode=" + yakcode;
            queryFromserver(url, "yakinfo");
        }
    }

    //从服务器查询
    private void queryFromserver(String address, final String type) {
        HttpUtil.sendOkhttpRequest(address, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressbar.setVisibility(View.GONE);
                        Toast.makeText(YakActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                boolean result = false;
                String responseText = response.body().string();
                if ("building".equals(type)) {
                    result = Utilty.handleYakinfoResponse(responseText,yakcode);
                }
                if (result) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if ("yakinfo".equals(type)) {
                                queryYakinfo();
                            }
                        }
                    });
                }
            }
        });
    }



}
