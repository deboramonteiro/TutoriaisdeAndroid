package br.ufc.dc.sd4mp.mytodolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 0333399 on 11/05/15.
 */
public class AddTask extends Activity {

    private EditText etTitle;
    private EditText etDesc;
    private TaskDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task_layout);
        etTitle = (EditText)findViewById(R.id.etTitle);
        etDesc = (EditText)findViewById(R.id.etDesc);
        dao = new TaskDAO(this);

    }

    public void saveTaskOnclick(View v)
    {
        TaskBean bean = new TaskBean();
        bean.setTitulo(etTitle.getText().toString());
        bean.setDescricao(etDesc.getText().toString());
        bean.setStatus(0);
        dao.create(bean);
        Toast.makeText(AddTask.this,"Criado com sucesso!",Toast.LENGTH_SHORT).show();
        finish();


    }
    public void cancelOnclick(View v)
    {
        finish();
    }
}
