package com.example.fundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

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

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipey);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
    }

    public void showAlertDialogButtonClicked(MainActivity mainActivity) {

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        String[] singleChoiceItems = getResources().getStringArray(R.array.lista);
        int itemSelected = 0;

        builder.setTitle("How much did you like this picture?");
        //builder.setMessage("Choose something");
        builder.setIcon(R.drawable.pepito);
        builder.setCancelable(false);
        builder.setSingleChoiceItems(singleChoiceItems, itemSelected, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int selectedIndex) {

                    }
                });

        builder.setPositiveButton("Signup", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Nanay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast0 = Toast.makeText(MainActivity.this, "Hello i do switch you to bab activity", Toast.LENGTH_LONG);
                toast0.show();
                openBab();
            }
        });

        builder.setNeutralButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.item1) {
            showAlertDialogButtonClicked(MainActivity.this);
            Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id == R.id.item2) {
            Toast toast = Toast.makeText(this, "Fixing", Toast.LENGTH_LONG);
            toast.show();
        }

        if (id == R.id.item3) {
            Intent intent = new Intent(MainActivity.this, MainBab.class);
            startActivity(intent);
        }

        if (id == R.id.item4) {
            Intent intent = new Intent(this, MainBn.class);
            startActivity(intent);
        }

        if (id == R.id.item5) {
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }

    public void openBab() {
        Intent intent = new Intent(MainActivity.this, MainBab.class);
        startActivity(intent);
    }
}