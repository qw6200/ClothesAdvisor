package csc214.project3;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ViewClothesPagerActivity extends AppCompatActivity {
    CustomPagerAdapter adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_clothes_pager);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        adapter = new CustomPagerAdapter(this);
        viewPager.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        boolean handled;
        switch(item.getItemId()){
            case R.id.menu_main:
                Intent mainIntent = new Intent(ViewClothesPagerActivity.this, IntroActivity.class);
                startActivity(mainIntent);
                handled = true;
                break;
            case R.id.menu_manageClothes:
                Intent manageIntent = new Intent(ViewClothesPagerActivity.this, ManageClothes.class);
                startActivity(manageIntent);
                handled = true;
                break;
            case R.id.menu_addClothes:
                Intent addIntent = new Intent(ViewClothesPagerActivity.this, AddClothes.class);
                startActivity(addIntent);
                handled = true;
                break;
            default:
                handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }
}
