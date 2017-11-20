package csc214.project3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddClothes extends AppCompatActivity {
    Button tShirt, hoodie, longSleeves, jacket, coat, shorts, jeans, longPants;
    Button red, blue, yellow, grey, brown, black, green, pink, orange, purple, white, other;
    Button done, brandSubmit;
    EditText brandET;
    DatabaseHelper myDb;
    DBFunctions dbf;

    int mTypeDone = 0;
    int mColorDone = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbf = new DBFunctions(this, null);
        myDb = new DatabaseHelper(this);

        tShirt = (Button)findViewById(R.id.Butt_addClothes_Tshirt);
        hoodie = (Button)findViewById(R.id.Butt_addClothes_hoodie);
        longSleeves = (Button)findViewById(R.id.Butt_addClothes_longSleeves);
        jacket = (Button)findViewById(R.id.Butt_addClothes_jacket);
        coat = (Button)findViewById(R.id.Butt_addClothes_coat);
        shorts = (Button)findViewById(R.id.Butt_addClothes_shorts);
        jeans = (Button)findViewById(R.id.Butt_addClothes_jeans);
        longPants = (Button)findViewById(R.id.Butt_addClothes_longPants);

        brandET = (EditText)findViewById(R.id.ET_addClothes_brand);
        brandSubmit = (Button)findViewById(R.id.Butt_addClothes_brandSubmit);

        red = (Button)findViewById(R.id.Butt_addClothes_red);
        blue = (Button)findViewById(R.id.Butt_addClothes_blue);
        yellow = (Button)findViewById(R.id.Butt_addClothes_yellow);
        grey = (Button)findViewById(R.id.Butt_addClothes_grey);
        brown = (Button)findViewById(R.id.Butt_addClothes_brown);
        black = (Button)findViewById(R.id.Butt_addClothes_black);
        green = (Button)findViewById(R.id.Butt_addClothes_green);
        pink = (Button)findViewById(R.id.Butt_addClothes_pink);
        orange = (Button)findViewById(R.id.Butt_addClothes_orange);
        purple = (Button)findViewById(R.id.Butt_addClothes_purple);
        white = (Button)findViewById(R.id.Butt_addClothes_white);
        other = (Button)findViewById(R.id.Butt_addClothes_other);

        done = (Button)findViewById(R.id.Butt_addClothes_done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbf.addClothes();
                mTypeDone = 0;
                mColorDone = 0;
            }
        });
        brandSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String brand = brandET.getText().toString();
                dbf.getBrand(brand);
                Toast.makeText(getApplicationContext(), "Brand Submitted!", Toast.LENGTH_SHORT).show();
            }
        });
        tShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTypeDone == 0) {
                    dbf.getType("tshirt");
                    Toast.makeText(getApplicationContext(), "T-shirt selected!", Toast.LENGTH_SHORT).show();
                    mTypeDone = 1;
                } else{
                    Toast.makeText(getApplicationContext(), "You already pressed on a type!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        hoodie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTypeDone == 0) {
                    dbf.getType("hoodie");
                    Toast.makeText(getApplicationContext(), "Hoodie selected!", Toast.LENGTH_SHORT).show();
                    mTypeDone = 1;
                } else{
                    Toast.makeText(getApplicationContext(), "You already pressed on a type!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        longSleeves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTypeDone == 0) {
                    dbf.getType("longsleeves");
                    Toast.makeText(getApplicationContext(), "Long-Sleeves selected!", Toast.LENGTH_SHORT).show();
                    mTypeDone = 1;
                } else{
                    Toast.makeText(getApplicationContext(), "You already pressed on a type!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        jacket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTypeDone == 0) {
                    dbf.getType("jacket");
                    Toast.makeText(getApplicationContext(), "Jacket selected!", Toast.LENGTH_SHORT).show();
                    mTypeDone = 1;
                } else{
                    Toast.makeText(getApplicationContext(), "You already pressed on a type!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        coat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTypeDone == 0) {
                    dbf.getType("parka");
                    Toast.makeText(getApplicationContext(), "Parka selected!", Toast.LENGTH_SHORT).show();
                    mTypeDone = 1;
                } else{
                    Toast.makeText(getApplicationContext(), "You already pressed on a type!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        shorts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTypeDone == 0) {
                    dbf.getType("shorts");
                    Toast.makeText(getApplicationContext(), "Shorts selected!", Toast.LENGTH_SHORT).show();
                    mTypeDone = 1;
                } else{
                    Toast.makeText(getApplicationContext(), "You already pressed on a type!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        jeans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTypeDone == 0) {
                    dbf.getType("jeans");
                    Toast.makeText(getApplicationContext(), "Jeans selected!", Toast.LENGTH_SHORT).show();
                    mTypeDone = 1;
                } else{
                    Toast.makeText(getApplicationContext(), "You already pressed on a type!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        longPants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTypeDone == 0) {
                    dbf.getType("longpants");
                    Toast.makeText(getApplicationContext(), "Long Pants selected!", Toast.LENGTH_SHORT).show();
                    mTypeDone = 1;
                } else{
                    Toast.makeText(getApplicationContext(), "You already pressed on a type!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColorDone == 0){
                    dbf.getColor("red");
                    Toast.makeText(getApplicationContext(), "Color Red selected!", Toast.LENGTH_SHORT).show();
                    mColorDone = 1;
                } else {
                    Toast.makeText(getApplicationContext(), "You already pressed on a color!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColorDone == 0){
                    dbf.getColor("blue");
                    Toast.makeText(getApplicationContext(), "Color Blue selected!", Toast.LENGTH_SHORT).show();
                    mColorDone = 1;
                } else {
                    Toast.makeText(getApplicationContext(), "You already pressed on a color!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColorDone == 0){
                    dbf.getColor("yellow");
                    Toast.makeText(getApplicationContext(), "Color Yellow selected!", Toast.LENGTH_SHORT).show();
                    mColorDone = 1;
                } else {
                    Toast.makeText(getApplicationContext(), "You already pressed on a color!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        grey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColorDone == 0){
                    dbf.getColor("grey");
                    Toast.makeText(getApplicationContext(), "Color Grey selected!", Toast.LENGTH_SHORT).show();
                    mColorDone = 1;
                } else {
                    Toast.makeText(getApplicationContext(), "You already pressed on a color!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        brown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColorDone == 0){
                    dbf.getColor("brown");
                    Toast.makeText(getApplicationContext(), "Color Brown selected!", Toast.LENGTH_SHORT).show();
                    mColorDone = 1;
                } else {
                    Toast.makeText(getApplicationContext(), "You already pressed on a color!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColorDone == 0){
                    dbf.getColor("black");
                    Toast.makeText(getApplicationContext(), "Color Black selected!", Toast.LENGTH_SHORT).show();

                    mColorDone = 1;
                } else {
                    Toast.makeText(getApplicationContext(), "You already pressed on a color!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColorDone == 0){
                    dbf.getColor("green");
                    Toast.makeText(getApplicationContext(), "Color Green selected!", Toast.LENGTH_SHORT).show();

                    mColorDone = 1;
                } else {
                    Toast.makeText(getApplicationContext(), "You already pressed on a color!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        pink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColorDone == 0){
                    dbf.getColor("pink");
                    Toast.makeText(getApplicationContext(), "Color Pink selected!", Toast.LENGTH_SHORT).show();

                    mColorDone = 1;
                } else {
                    Toast.makeText(getApplicationContext(), "You already pressed on a color!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColorDone == 0){
                    dbf.getColor("orange");
                    Toast.makeText(getApplicationContext(), "Color Orange selected!", Toast.LENGTH_SHORT).show();

                    mColorDone = 1;
                } else {
                    Toast.makeText(getApplicationContext(), "You already pressed on a color!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColorDone == 0){
                    dbf.getColor("purple");
                    Toast.makeText(getApplicationContext(), "Color Purple selected!", Toast.LENGTH_SHORT).show();
                    mColorDone = 1;
                } else {
                    Toast.makeText(getApplicationContext(), "You already pressed on a color!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColorDone == 0){
                    dbf.getColor("orange");
                    Toast.makeText(getApplicationContext(), "Color Orange selected!", Toast.LENGTH_SHORT).show();
                    mColorDone = 1;
                } else {
                    Toast.makeText(getApplicationContext(), "You already pressed on a color!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColorDone == 0){
                    dbf.getColor("purple");
                    Toast.makeText(getApplicationContext(), "Color Purple selected!", Toast.LENGTH_SHORT).show();
                    mColorDone = 1;
                } else {
                    Toast.makeText(getApplicationContext(), "You already pressed on a color!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColorDone == 0){
                    dbf.getColor("white");
                    Toast.makeText(getApplicationContext(), "Color White selected!", Toast.LENGTH_SHORT).show();
                    mColorDone = 1;
                } else {
                    Toast.makeText(getApplicationContext(), "You already pressed on a color!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColorDone == 0){
                    dbf.getColor("other");
                    Toast.makeText(getApplicationContext(), "Other Color selected!", Toast.LENGTH_SHORT).show();
                    mColorDone = 1;
                } else {
                    Toast.makeText(getApplicationContext(), "You already pressed on a color!", Toast.LENGTH_SHORT).show();
                }
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
            case R.id.menu_main:
                Intent mainIntent = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(mainIntent);
                handled = true;
                break;
            case R.id.menu_manageClothes:
                Intent manageIntent = new Intent(getApplicationContext(), ManageClothes.class);
                startActivity(manageIntent);
                handled = true;
                break;
            case R.id.menu_viewWeather:
                Intent viewIntent = new Intent(getApplicationContext(), ViewClothesPagerActivity.class);
                startActivity(viewIntent);
                handled = true;
                break;
            default:
                handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }
}
