package com.example.menutable;

import android.app.LauncherActivity;
import android.os.Bundle;

import com.example.menutable.adapter.BtnListAdapter;
import com.example.menutable.adapter.MenuListAdapter;
import com.example.menutable.model.BtnList;
import com.example.menutable.model.FoodItem;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView ;
    private BtnListAdapter btnAdapter;
    private LinearLayoutManager mLayoutManager;
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        //리사이클러뷰
        mRecyclerView = findViewById(R.id.BtnListView);
        ArrayList<BtnList> data = new ArrayList<>();
        int i = 0;
        while (i < 4) {
            data.add(new BtnList(R.mipmap.ic_launcher, i+"번째 데이터"));
            i++;
        }
        mLayoutManager = new LinearLayoutManager(this);// init LayoutManager
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // 기본값이 VERTICAL
        mRecyclerView.setLayoutManager(mLayoutManager); // setLayoutManager

        btnAdapter = new BtnListAdapter(getApplicationContext());// init Adapter
        btnAdapter.setList(data); // set Data
        mRecyclerView.setAdapter(btnAdapter);  // set Adapter*/

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition() ;
                changeTabView(pos) ;
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        //그리드뷰
        GridView gv = (GridView)findViewById(R.id.MenuList);
        MenuListAdapter menuAdapter = new MenuListAdapter (getApplicationContext());

        menuAdapter.addItem(new FoodItem("11", 22));
        menuAdapter.addItem(new FoodItem("11", 22));
        menuAdapter.addItem(new FoodItem("14", 22));

        gv.setAdapter(menuAdapter);  // 커스텀 아답타를 GridView 에 적용

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "!!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void changeTabView(int index) {
        TextView textView1 = (TextView) findViewById(R.id.tv1) ;
        TextView textView2 = (TextView) findViewById(R.id.tv2) ;

        switch (index) {
            case 0 :
                textView1.setVisibility(View.VISIBLE) ;
                textView2.setVisibility(View.INVISIBLE) ;
                break ;
            case 1 :
                textView1.setVisibility(View.INVISIBLE) ;
                textView2.setVisibility(View.VISIBLE) ;
                break ;

        }
    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
