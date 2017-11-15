package com.example.bs535.yakk.content;


import android.os.Bundle;



import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;



import com.example.bs535.yakk.R;

import java.util.ArrayList;
import java.util.List;


public class MallActivity extends AppCompatActivity {   //cardview

        private Mall[] fruits = {
                new Mall("宝宝睡不好 难受",R.drawable.shuijiao),
                new Mall("儿童生长痛的治疗",R.drawable.shengzhangtong),
                new Mall("父母怎样聪明护犊",R.drawable.fumuhudu),
                new Mall("关于儿童发烧 家长最想知道这些",R.drawable.fashao),
                new Mall("孩子记不住 可以练出来",R.drawable.jibuzhu),
                new Mall("孩子胖怎么办",R.drawable.pang),
                new Mall("孩子伤口的处理",R.drawable.shangkou),
                new Mall("好习惯养成法",R.drawable.xiguan),
                new Mall("如何化解孩子的委屈",R.drawable.weiqu),
                new Mall("用镇咳药 儿童应区别于成人",R.drawable.kesou)};
        private List<Mall> fruitList = new ArrayList<>();
        private MallAdapter adapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //cardviev布局
            initFruits();
            RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycier_view);
            GridLayoutManager layoutManager = new GridLayoutManager(this,2);
            recyclerView.setLayoutManager(layoutManager);
            adapter = new MallAdapter(fruitList);
            recyclerView.setAdapter(adapter);}
        private void initFruits(){
            fruitList.clear();
            // for (int i=0;i<50;i++){
            // Random random = new Random();
            // int index = random.nextInt(fruits.length);
            fruitList.add(fruits[0]);
            fruitList.add(fruits[1]);
            // }

        }



}