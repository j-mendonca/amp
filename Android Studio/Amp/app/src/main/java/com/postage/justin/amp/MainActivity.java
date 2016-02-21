package com.postage.justin.amp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Amp amp;

    EditText lengthText;
    EditText widthText;
    EditText heightText;
    EditText weightText;
    EditText priceText;

    Button calculate;

    int length;
    int width;
    int height;
    int weight;
    double price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lengthText = (EditText) findViewById(R.id.editText);
        widthText = (EditText) findViewById(R.id.editText2);
        heightText = (EditText) findViewById(R.id.editText4);
        weightText = (EditText) findViewById(R.id.editText6);
        priceText = (EditText) findViewById(R.id.editText5);

        calculate = (Button) findViewById(R.id.button);

        calculate.setOnClickListener(calculateListener);
    }

    private View.OnClickListener calculateListener = new View.OnClickListener(){

        public void onClick(View v)
        {

//            try {
//                length = Integer.parseInt(lengthText.getText().toString());
//                width = Integer.parseInt(widthText.getText().toString());
//                height = Integer.parseInt(heightText.getText().toString());
//                weight = Integer.parseInt(weightText.getText().toString());
//            } catch (Exception e){
//                lengthText.setText("0");
//                widthText.setText("0");
//                heightText.setText("0");
//                weightText.setText("0");
//            }
            try{
                length = Integer.parseInt(lengthText.getText().toString());
                width = Integer.parseInt(widthText.getText().toString());
                height = Integer.parseInt(heightText.getText().toString());
                weight = Integer.parseInt(weightText.getText().toString());
                amp = new Amp(length,width,height,weight);

                price = amp.calculate();
                priceText.setText(""+price);
            } catch (OutOfRangeException e){
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Invalid Parameters: Please double check your values");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        }

    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
