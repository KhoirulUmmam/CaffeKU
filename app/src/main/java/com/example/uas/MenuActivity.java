package com.example.uas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uas.Adapter.FoodAdapter;
import com.example.uas.Models.Food;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    FoodAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("BATAGOR",R.drawable.batagor, 5000,"Batagor merupakan nama makanan dari singkatan bakso, tahu, dan goreng. Makanan khas Sunda ini adalah adaptasi dari hidangan Tionghoa-Indonesia."));
        foods.add(new Food("CAPPUCCINO",R.drawable.cappuchino, 15000,"Cappuccino merupakan kopi yang populer dari Italia karena lebih sering dan lebih banyak dikonsumsi. Rasanya yang tidak terlalu pahit seperti espresso, membuat cappuccino lebih mudah diterima oleh lidah semua orang khususnya kalangan muda."));
        foods.add(new Food("CHEESECAKE",R.drawable.cheesecake, 18000,"Cheesecake adalah kue yang biasanya dimakan sebagai hidangan penutup, dibuat dengan mencampurkan keju yang bertekstur lembut, telur, susu, dan gula.["));
        foods.add(new Food("CIRENG",R.drawable.cireng, 5000,"Cireng (aci digoreng) adalah makanan ringan yang berasal dari daerah Sunda yang dibuat dengan cara menggoreng campuran adonan yang berbahan utama tepung kanji atau tapioka."));
        foods.add(new Food("DONUT",R.drawable.donut, 3000,"Donut adalah sejenis cake mini ataupun kue kering dengan bentuk yang khas, yaitu berlubang di tengah seperti cincin dan berbentuk bulat jika diisi sesuatu."));
        foods.add(new Food("NASI GORENG",R.drawable.nasigoreng, 12000,"Nasi goreng adalah sebuah makanan berupa nasi yang digoreng dan diaduk dalam minyak goreng, margarin, atau mentega."));

        adapter = new FoodAdapter(this, foods);
        ListView orderListView = (ListView) findViewById(R.id.order_list_view);
        orderListView.setAdapter(adapter);
        orderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MenuActivity.this,FoodDetailActivity.class);

                Food currentFood = foods.get(position);
                Log.e("FOOD NAME", currentFood.getFoodName());
                i.putExtra("name", currentFood.getFoodName());
                i.putExtra("image", currentFood.getmImageResource());
                i.putExtra("price", currentFood.getFoodPrice());
                i.putExtra("type", currentFood.getType());
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_cart: Intent i = new Intent(MenuActivity.this, CartListActivity.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

