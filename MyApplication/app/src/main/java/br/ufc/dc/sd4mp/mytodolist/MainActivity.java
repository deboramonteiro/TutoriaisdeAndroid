package br.ufc.dc.sd4mp.mytodolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;


public class MainActivity extends Activity {

    private TaskDAO dao;
    private List<TaskBean> pendentes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        dao = new TaskDAO(this);


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
        final String email = "debymontinfo@gmail.com";
        final String assunto = "Tarefas Pendentes";
        String corpo = new String();

        pendentes = dao.TasksPendentes();

        for(TaskBean b:pendentes)
        {
            corpo+= b.printDados();

        }
        Intent it = new Intent(Intent.ACTION_SEND);
        it.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
        it.putExtra(Intent.EXTRA_SUBJECT, assunto);
        it.putExtra(Intent.EXTRA_TEXT,corpo);
        it.setType("plain/text");
        startActivity(Intent.createChooser(it,"Enviar email..."));
        startActivity(it);
    }



}
