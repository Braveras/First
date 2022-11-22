package com.example.fundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    private WebView mycontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mycontext = (WebView) findViewById(R.id.vistaweb);
        registerForContextMenu(mycontext);
        mycontext.getSettings().setBuiltInZoomControls(true);
        mycontext.loadUrl("https://thispersondoesnotexist.com");

        SwipeRefreshLayout swipeLayout = findViewById(R.id.swipey);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
    }

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(MainActivity.this, "Hi there! I dont exist =)", Toast.LENGTH_LONG);
            toast0.show();
            mycontext.reload();
            swipeLayout.setRefreshing(false);
        }
    };

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.menu_context, menu);

    }

    public boolean onContextItemSelected(MenuItem item) {


        switch(item.getItemId()) {
            case R.id.item1:
                //Toast toast = Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
                //toast.show();

                final ConstraintLayout mLayout = findViewById(R.id.myswipe);

                Snackbar snackbar = Snackbar
                        .make(mLayout, "Imagen copiada", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });

                snackbar.show();

                return true;
            case R.id.item2:
                Toast tostada = Toast.makeText(this, "Downloading item...", Toast.LENGTH_LONG);
                tostada.show();
                return true;
            default:
                //return super.onContextItemSelected(item);
                return false;
        }

    }
}