package br.ufc.dc.sd4mp.alertnotification;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    public static int options[] = new int[]{0,0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


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

    public void checkboxChecked(View v)
    {
        boolean checked = ((CheckBox)v).isChecked();

        switch (v.getId())
        {
            case R.id.checkBox1:

                if(checked)
                    options[0] = 1;

                else
                    options[0] = 0;


            break;

            case R.id.checkBox2:

                if(checked)

                    options[1] = 1;

                else
                    options[1] = 0;

            break;

            case R.id.checkBox3:

                if(checked)

                    options[2] = 1;

                else
                    options[2] = 0;

            break;

            case R.id.checkBox4:

                if(checked)

                    options[3] = 1;

                else
                    options[3] = 0;

            break;
        }
    }
}
