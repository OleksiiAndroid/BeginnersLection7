package ua.com.webacademy.beginnerslection7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void OnClick(View v) {
        Toast toast;

        switch (v.getId()) {
            case R.id.button:
                Toast.makeText(this, "Hello world", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast.makeText(this, R.string.hello_world, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                toast = Toast.makeText(this, R.string.hello_world, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
                break;
            case R.id.button4:
                toast = Toast.makeText(this, R.string.hello_world, Toast.LENGTH_SHORT);

                LinearLayout toastContainer = (LinearLayout) toast.getView();

                ImageView catImageView = new ImageView(this);
                catImageView.setImageResource(R.mipmap.ic_launcher);

                toastContainer.addView(catImageView);

                toast.show();
                break;
            case R.id.button5:
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.toast, null);

                TextView textView = (TextView) view.findViewById(R.id.text);
                textView.setText(R.string.hello_world);

                toast = new Toast(this);
                toast.setDuration(Toast.LENGTH_SHORT);

                toast.setView(view);
                toast.show();
                break;
        }
    }
}
