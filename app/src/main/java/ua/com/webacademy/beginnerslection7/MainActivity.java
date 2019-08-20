package ua.com.webacademy.beginnerslection7;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View v){
        Intent intent = null;

        switch (v.getId()){
            case R.id.button:
                intent = new Intent(this, Activity2.class);
                break;
            case R.id.button2:
                intent = new Intent(this, Activity3.class);
                break;
            case R.id.button3:
                intent = new Intent(this, Activity4.class);
                break;
            case R.id.button4:
                intent = new Intent(this, Activity5.class);
                break;
        }

        startActivity(intent);
    }
}
