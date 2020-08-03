package com.example.menutable.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.menutable.R;
import com.example.menutable.model.FoodItem;

import java.util.ArrayList;

public class MenuListAdapter extends BaseAdapter {

    private Context context;

    ArrayList<FoodItem> foodItem = new ArrayList<FoodItem>();


    public MenuListAdapter(Context context) {
        this.context = context;
    }

    public void addItem(FoodItem fooditem){ foodItem.add(fooditem); }

    @Override
    public int getCount() { return foodItem.size(); }

    @Override
    public Object getItem(int position) { return foodItem.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null){
            LayoutInflater inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.menu_item, parent, false);
        }

        ImageView img = view.findViewById(R.id.food_image);
        TextView name = view.findViewById(R.id.food_name);
        TextView price = view.findViewById(R.id.food_price);

        img.setImageResource(R.drawable.default_image);
        name.setText("네임셋");
        price.setText("가격셋");

        return view;
    }

}

/*

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        */
/* 'listview_custom' Layout을 inflate하여 convertView 참조 획득 *//*

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.bus_line_listview, parent, false);
        }

        */
/* 'listview_custom'에 정의된 위젯에 대한 참조 획득 *//*

        ImageView busImg = (ImageView) convertView.findViewById(R.id.busImg) ;
        TextView busNum = (TextView) convertView.findViewById(R.id.busNum) ;
        TextView busDir = (TextView) convertView.findViewById(R.id.busDir) ;

        */
/* 각 리스트에 뿌려줄 아이템을 받아오는데 mMyItem 재활용 *//*

        ListNode bus = getItem(position);

        */
/* 각 위젯에 세팅된 아이템을 뿌려준다 *//*

        busImg.setImageDrawable(bus.getIcon());
        busNum.setText(bus.getNumber());
        busDir.setText(bus.getDirection());

        */
/* (위젯에 대한 이벤트리스너를 지정하고 싶다면 여기에 작성하면된다..)  *//*

        return convertView;
    }

    */
/* 아이템 데이터 추가를 위한 함수. 자신이 원하는대로 작성 *//*

    public void addList(Drawable img, String num, String direction) {
        ListNode bus = new ListNode();
        bus.setIcon(img);
        bus.setNumber(num);
        bus.setDirection(direction);
        mItems.add(bus);
    }
    public void addList(String num, String direction) {
        ListNode bus = new ListNode();
        bus.setNumber(num);
        bus.setDirection(direction);
        mItems.add(bus);
    }


    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public ListNode getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
*/
