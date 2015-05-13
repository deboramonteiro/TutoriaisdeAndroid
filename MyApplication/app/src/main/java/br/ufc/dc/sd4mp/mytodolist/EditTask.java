package br.ufc.dc.sd4mp.mytodolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Debora on 12/05/2015.
 */
public class EditTask extends Activity {

    private TaskDAO dao;
    private TaskBean bean;
    private EditText etTitle;
    private EditText etDesc;
    private CheckBox checkStatus;
    private TextView tvData;
    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.layout_edit);


        etTitle = (EditText)findViewById(R.id.editTextTitle);
        etDesc = (EditText)findViewById(R.id.editTextDesc);
        tvData = (TextView)findViewById(R.id.tvData);
        checkStatus = (CheckBox)findViewById(R.id.checkBoxStatus);

            int id = getIntent().getExtras().getInt("id");

            dao = new TaskDAO(this);

            bean = dao.retrieve(id);
            etTitle.setText(bean.getTitulo());
            etDesc.setText(bean.getDescricao());
            tvData.setText("Criada em: "+bean.getData_creation());

            if(bean.getStatus() == 1)
                checkStatus.setChecked(true);
            else
                checkStatus.setChecked(false);
            etTitle.requestFocus();



    }

    @Override
    public void onBackPressed() {

        bean.setDescricao(etDesc.getText().toString());
        bean.setTitulo(etTitle.getText().toString());
        bean.setStatus((checkStatus.isChecked() == true) ? 1 : 0);
        dao.update(bean);
        Toast.makeText(EditTask.this,"Alterações salvas!",Toast.LENGTH_SHORT).show();
        Intent it = new Intent(EditTask.this,MainActivity.class);
        startActivity(it);
    }
}
