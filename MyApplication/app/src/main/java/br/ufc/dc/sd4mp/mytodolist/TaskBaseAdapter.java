package br.ufc.dc.sd4mp.mytodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by 0333399 on 11/05/15.
 */
public class TaskBaseAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<TaskBean> lista;

    public TaskBaseAdapter(Context context, List<TaskBean> itens)
    {
        this.lista = itens;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

}
