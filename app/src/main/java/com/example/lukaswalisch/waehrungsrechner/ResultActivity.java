package com.example.lukaswalisch.waehrungsrechner;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultActivity extends ActionBarActivity implements View.OnClickListener
{

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        button = (Button) findViewById(R.id.result_button);
        textView= (TextView) findViewById(R.id.result_textView);
        Intent intent = this.getIntent();
        double input = intent.getDoubleExtra("input", 0.0);
        double result = intent.getDoubleExtra("result",0.0);
        String currency = intent.getStringExtra("currency");
        textView.setText(input + " EUR  = " + result + " " + currency);
        button.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent(this.getApplicationContext(),StartActivity.class);
        this.startActivity(intent);
    }
}
