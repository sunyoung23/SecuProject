package org.techtown.secuproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static final int OK = 100;
    ViewFlipper v_fllipper;

    Toolbar toolbar;
    CollapsingToolbarLayout toolbarLayout;
    ListView list1;

    int images[] = {
            R.drawable.mainimage,
            R.drawable.mainimage2,
            R.drawable.mainimage3
    };

    int [] img = {
            R.drawable.bitcoin,R.drawable.bookmark,R.drawable.bug,R.drawable.chat,
            R.drawable.contact,R.drawable.date
    };
    int [] btn = {
            R.drawable.bitcoin,R.drawable.bookmark,R.drawable.bug,R.drawable.chat,
            R.drawable.contact,R.drawable.date
    };
    String [] data1 = {
            "운동","활동시간","음식","수면","체중","물"
    };

    String [] data2 = {
            "운동","활동시간","음식","수면","체중","물"
    };



    ArrayList<View> viewList = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbarLayout = findViewById(R.id.toobal_layout); // 툴바레이아웃주소
        toolbarLayout.setCollapsedTitleTextColor(Color.WHITE);//접혀졌을때 글자색상
        toolbarLayout.setExpandedTitleColor(Color.BLACK);//펼쳐졌을때 글자 색상
        setSupportActionBar(toolbar);


        list1 = findViewById(R.id.list1);




        ArrayList<HashMap<String, Object>> data_list = new ArrayList<HashMap<String, Object>>();

        for(int i = 0; i < data2.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("img", img[i]);
            map.put("btn", btn[i]);
            map.put("data1", data1[i]);
            map.put("data2", data2[i]);

            data_list.add(map);
        }

        String [] keys = {"img","btn","data1","data2"};

        int [] ids = {R.id.imageView, R.id.button,R.id.textView,R.id.textView2};

        SimpleAdapter adapter = new SimpleAdapter(this, data_list,R.layout.listview, keys, ids);
        list1.setAdapter(adapter);

        ListListner listner = new ListListner();
        list1.setOnItemClickListener(listner);

        v_fllipper = findViewById(R.id.image_slide);

        for(int image : images) {
            fllipperImages(image);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //사용자가 터치한 항목 객체의 id를 추출한다
        int id = item.getItemId();

        switch (id) {
            case R.id.search:

                break;
            case R.id.dial:
                DialFragment frg1 = new DialFragment();
                FragmentManager manager = getSupportFragmentManager();
                //프래그먼트 다이얼로그 띄운다
                frg1.show(manager, "tag");
                break;
            case R.id.mydata:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    class ListListner implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }

    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_fllipper.addView(imageView);      // 이미지 추가
        v_fllipper.setFlipInterval(4000);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        v_fllipper.setAutoStart(true);          // 자동 시작 유무 설정

        // animation
        v_fllipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_fllipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }

}
