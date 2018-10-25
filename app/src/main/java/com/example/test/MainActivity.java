package com.example.test;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        //设置navigationview的menu监听
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        menuItem.setChecked(true);
        if (id == R.id.navigation_item_1) {
            showFragment("test1");
            Toast.makeText(MainActivity.this,"1",Toast.LENGTH_LONG).show();
        } else if (id == R.id.navigation_item_2) {
            showFragment("test2");
            Toast.makeText(MainActivity.this,"2",Toast.LENGTH_LONG).show();
        } else if (id == R.id.navigation_item_3) {
            showFragment("test3");
            Toast.makeText(MainActivity.this,"3",Toast.LENGTH_LONG).show();
        } else if (id == R.id.navigation_item_4) {
            showFragment("test4");
            Toast.makeText(MainActivity.this,"4",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_share) {
            showFragment("test5");
            Toast.makeText(MainActivity.this,"5",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_send) {
            showFragment("test6");
            Toast.makeText(MainActivity.this,"6",Toast.LENGTH_LONG).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(String text){
        Bundle bundle = new Bundle();
        bundle.putString("show_text",text);
        MyFragment myFragment = new MyFragment();
        myFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, myFragment).commit();
    }
}
