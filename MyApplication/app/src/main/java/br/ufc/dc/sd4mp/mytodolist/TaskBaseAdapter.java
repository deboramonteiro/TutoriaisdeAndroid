package br.ufc.dc.sd4mp.mytodolist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 0333399 on 11/05/15.
 */
public class TaskBaseAdapter extends BaseAdapter {


    private List<TaskBean> lista;
    private Context contexto;
    LayoutInflater inflater;

    public TaskBaseAdapter(Context context, List<TaskBean> itens)
    {
        if(itens != null)
            this.lista = itens;
        else
            this.lista = new ArrayList<TaskBean>();

        this.contexto = context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item_layout, null);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvStatus = (TextView) convertView.findViewById(R.id.tvStatus);

        TaskBean t = lista.get(position);
        if(t.getStatus() == 0)
        {
            tvStatus.setBackgroundColor(Color.parseColor("#FF0000"));
            tvStatus.setText("Pendente");
        }
        else{
            tvStatus.setBackgroundColor(Color.parseColor("#00FF00"));
            tvStatus.setText("Concluída");
        }
        tvTitle.setText(t.getTitulo());


        return convertView;
    }

    @Override
    public TaskBean getItem(int position) {
        return lista.get(position);
    }

}
