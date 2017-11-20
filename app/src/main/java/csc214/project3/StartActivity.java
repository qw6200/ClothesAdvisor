package csc214.project3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {
    Button submitButton;
    EditText ETzip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        submitButton = (Button)findViewById(R.id.Butt_start_submit);
        ETzip = (EditText)findViewById(R.id.ET_start_zip);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            // pass zip code to activity
            public void onClick(View v) {
                String zipCode = ETzip.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("zip", zipCode);

                Intent intent = new Intent(StartActivity.this, IntroActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
