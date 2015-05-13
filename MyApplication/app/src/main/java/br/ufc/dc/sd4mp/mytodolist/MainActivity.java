package br.ufc.dc.sd4mp.mytodolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);


    }

    public void listar(View v)
    {
        Intent it = new Intent(MainActivity.this,ListarTask.class);
        startActivity(it);
    }

    public void adicionar(View v)
    {
        Intent it = new Intent(MainActivity.this,AddTask.class);
        startActivity(it);
    }

    public void enviar(View v)
    {
        Intent it = new Intent(MainActivity.this,SendbyMail.class);
        startActivity(it);
    }



}
