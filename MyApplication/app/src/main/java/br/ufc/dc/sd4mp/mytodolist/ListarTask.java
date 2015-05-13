package br.ufc.dc.sd4mp.mytodolist;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.DataOutputStream;

/**
 * Created by Debora on 12/05/2015.
 */
public class ListarTask extends Activity {

    private ListView lv;
    private TaskBaseAdapter adapter;
    private TaskDAO dao;
    private TaskBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bean = new TaskBean();
        setContentView(R.layout.activity_list_task);
        lv = (ListView)findViewById(R.id.listTask);
        dao = new TaskDAO(this);
        adapter = new TaskBaseAdapter(this,dao.listByCreationTime());
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TaskBean task = (TaskBean)parent.getAdapter().getItem(position);

                Intent i = new Intent(ListarTask.this, EditTask.class);
                i.putExtra("id",task.getId());
                i.putExtra("title",task.getTitulo());
                i.putExtra("desc",task.getDescricao());
                i.putExtra("status",task.getStatus());
                i.putExtra("data",task.getData_creation());

                startActivity(i);

            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, final long id) {

                final TaskBean task = (TaskBean)parent.getAdapter().getItem(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(ListarTask.this);
                builder.setTitle("Excluir Task");
                builder.setMessage("Deseja realmente excluir essa Task?");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        /*if(dao.delete(task.getId()) > 0)
                        {
                            Toast.makeText(ListarTask.this,"Excluido com sucesso!",Toast.LENGTH_SHORT).show();
                            Intent it = new Intent(ListarTask.this,MainActivity.class);
                            startActivity(it);
                        }*/

                    }
                });

                builder.setNegativeButton("Não",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                //AlertDialog al = builder.create();
                builder.show();
                return false;
            }
        });
    }
}
