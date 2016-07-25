package ua.com.webacademy.beginnerslection7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textView1 = (TextView) findViewById(R.id.textView1);

        registerForContextMenu(textView);
        registerForContextMenu(textView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity5, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                Toast.makeText(this, "Menu 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(this, "Menu 2 clicked", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.textView:
                menu.add(0, R.id.menu1, 0, "context menu 1");
                menu.add(0, R.id.menu2, 1, "context menu 2");

                SubMenu subMenu = menu.addSubMenu(0, 2, 2, "Submenu 1");
                subMenu.add(0, 3, 3, "context menu 3");
                subMenu.add(0, 4, 4, "context menu 4");
                break;
            case R.id.textView1:
                MenuInflater inflater = getMenuInflater();

                inflater.inflate(R.menu.menu_activity5, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                Toast.makeText(this, "Menu 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(this, "Menu 2 clicked", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                PopupMenu popupMenu = new PopupMenu(this, v);
                popupMenu.inflate(R.menu.menu_activity5);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.menu1:
                                Toast.makeText(Activity5.this, "Menu 1 clicked", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.menu2:
                                Toast.makeText(Activity5.this, "Menu 2 clicked", Toast.LENGTH_SHORT).show();
                                return true;
                        }

                        return false;
                    }
                });

                popupMenu.show();
                break;
            case R.id.button2:
                PopupMenu popupMenu1 = new PopupMenu(this, v);
                Menu menu = popupMenu1.getMenu();

                menu.add(0, R.id.menu1, 0, "context menu 1");
                menu.add(0, R.id.menu2, 1, "context menu 2");

                SubMenu subMenu = menu.addSubMenu(0, 2, 2, "Submenu 1");
                subMenu.add(0, 3, 3, "context menu 3");
                subMenu.add(0, 4, 4, "context menu 4");

                popupMenu1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.menu1:
                                Toast.makeText(Activity5.this, "Menu 1 clicked", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.menu2:
                                Toast.makeText(Activity5.this, "Menu 2 clicked", Toast.LENGTH_SHORT).show();
                                return true;
                        }

                        return false;
                    }
                });

                popupMenu1.show();
                break;
        }
    }
}
