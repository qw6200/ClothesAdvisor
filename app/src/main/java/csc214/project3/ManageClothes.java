package csc214.project3;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ManageClothes extends AppCompatActivity {

    Button addClothes, deleteClothes, seeClothes;
    EditText ETdeleteClothing;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_clothes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myDb = new DatabaseHelper(this);

        addClothes = (Button)findViewById(R.id.Butt_manageClothes_addClothes);
        deleteClothes = (Button)findViewById(R.id.Butt_manageClothes_deleteClothing);
        seeClothes = (Button)findViewById(R.id.Butt_manageClothes_seeClothes);

        ETdeleteClothing = (EditText)findViewById(R.id.ET_manageClothes_delete);

        addClothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManageClothes.this, AddClothes.class);
                startActivity(intent);
            }
        });
        deleteClothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData(ETdeleteClothing.getText().toString());
                if (deletedRows > 0){
                    Toast.makeText(ManageClothes.this, "Clothing Deleted", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(ManageClothes.this, "NOT DELETED", Toast.LENGTH_LONG).show();
            }
        });

        seeClothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = myDb.getAllData();
                if(cursor.getCount() == 0){
                    showMessage("Error", "No Data Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(cursor.moveToNext()){
                    buffer.append("Id :" + cursor.getString(0) + "\n");
                    buffer.append("Type :" + cursor.getString(1) + "\n");
                    buffer.append("Color: " + cursor.getString(2) + "\n");
                    buffer.append("Brand: " + cursor.getString(3) + "\n\n");
                }
                showMessage("Data", buffer.toString());
            }
        });
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
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
                Intent addIntent = new Intent(ManageClothes.this, AddClothes.class);
                startActivity(addIntent);
                handled = true;
                break;
            case R.id.menu_main:
                Intent manageIntent = new Intent(ManageClothes.this, IntroActivity.class);
                startActivity(manageIntent);
                handled = true;
                break;
            case R.id.menu_viewWeather:
                Intent viewIntent = new Intent(ManageClothes.this, ViewClothesPagerActivity.class);
                startActivity(viewIntent);
                handled = true;
                break;
            default:
                handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }
}
