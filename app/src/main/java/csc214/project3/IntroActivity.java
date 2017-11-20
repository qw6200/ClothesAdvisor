package csc214.project3;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class IntroActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    Button manageClothesButton;
    CurrentWeather currentWeather;
    DailyWeather dailyWeather;
    public static int mLowTemp;
    public static int mHighTemp;
    public static String mCondition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myDb = new DatabaseHelper(this);

        Bundle bundle = getIntent().getExtras();
        String zipCode = bundle.getString("zip");

        currentWeather = new CurrentWeather();
        dailyWeather = new DailyWeather(this);

        // gets API for weather
        currentWeather.execute("http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + ",us&appid=c72d4e508418dc29546323f417848185");
        dailyWeather.execute("http://api.openweathermap.org/data/2.5/forecast/daily?zip=" + zipCode + "&appid=c72d4e508418dc29546323f417848185");



        manageClothesButton = (Button) findViewById(R.id.Butt_main_manageClothes);

        manageClothesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, ManageClothes.class);
                startActivity(intent);
            }
        });


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
            case R.id.menu_addClothes:
                Intent addIntent = new Intent(IntroActivity.this, AddClothes.class);
                startActivity(addIntent);
                handled = true;
                break;
            case R.id.menu_manageClothes:
                Intent manageIntent = new Intent(IntroActivity.this, ManageClothes.class);
                startActivity(manageIntent);
                handled = true;
                break;
            case R.id.menu_viewWeather:
                Intent viewIntent = new Intent(IntroActivity.this, ViewClothesPagerActivity.class);
                startActivity(viewIntent);
                handled = true;
                break;
            default:
                handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }
    public void startFragment(){
        SuitableClothesFragment fragment = new SuitableClothesFragment();
        getFragmentManager()
                .beginTransaction()
                .add(R.id.frame_intro, fragment, "FragmentTag")
                .commit();
    }
}
