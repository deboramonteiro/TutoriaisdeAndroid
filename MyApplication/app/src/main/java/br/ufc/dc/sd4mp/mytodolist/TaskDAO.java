package br.ufc.dc.sd4mp.mytodolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Debora on 12/05/2015.
 */
public class TaskDAO extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyTask.db";
    public static final int DATABASE_VERSION = 1;

    public TaskDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public TaskDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuffer sql = new StringBuffer();
        sql.append("create table task (");
        sql.append("id integer primary key autoincrement,");
        sql.append("title text,");
        sql.append("descricao text,");
        sql.append("status integer,");
        sql.append("creation_time integer default current_timestamp)");
        db.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists task");
        onCreate(db);
    }

    public void create(TaskBean task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", task.getTitulo());
        contentValues.put("descricao", task.getDescricao());
        contentValues.put("status", task.getStatus());
        long id = db.insert("task", null, contentValues);
        Log.v("SQLite", "create id = " + id);
    }

    public TaskBean retrieve(Integer id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select id, title, descricao, status, strftime('%d-%m-%Y %H:%M:%S', creation_time) as time from task where id = ?", new String[]{Integer.toString(id)});
        TaskBean t = null;
        if (result != null && result.getCount() > 0) {
            result.moveToFirst();
            t = new TaskBean();
            t.setId(result.getInt(result.getColumnIndex("id")));
            t.setTitulo(result.getString(result.getColumnIndex("title")));
            t.setDescricao(result.getString(result.getColumnIndex("descricao")));
            t.setStatus(result.getInt(result.getColumnIndex("status")));
            t.setDataCreation(result.getString(result.getColumnIndex("time")));
        }
        return t;
    }

    public void update(TaskBean task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", task.getTitulo());
        contentValues.put("descricao", task.getDescricao());
        contentValues.put("status", task.getStatus());
        db.update("task", contentValues, " id = ? ", new String[]{Integer.toString(task.getId())});
    }

    public int delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("task", " id = ? ", new String[]{Integer.toString(id)});
    }

    public List<TaskBean> list() {
        List<TaskBean> tarefas = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select id, title, descricao,status, strftime('%d-%m-%Y %H:%M:%S', creation_time) as time from task order by id desc", null);
        if (result != null && result.getCount() > 0) {
            tarefas = new ArrayList<TaskBean>();
            result.moveToFirst();
            while (result.isAfterLast() == false) {
                TaskBean t = new TaskBean();
                t.setId(result.getInt(0));
                t.setTitulo(result.getString(1));
                t.setDescricao(result.getString(2));
                t.setStatus(result.getInt(3));
                t.setDataCreation(result.getString(4));
                tarefas.add(t);
                result.moveToNext();
            }
        }
        return tarefas;
    }

    public List<TaskBean> listByCreationTime() {
        List<TaskBean> tarefas = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select id, title, descricao, status, strftime('%d-%m-%Y %H:%M:%S', creation_time) as time from task order by creation_time", null);
        if (result != null && result.getCount() > 0) {
            tarefas = new ArrayList<TaskBean>();
            result.moveToFirst();
            while (result.isAfterLast() == false) {
                TaskBean t = new TaskBean();
                t.setId(result.getInt(0));
                t.setTitulo(result.getString(1));
                t.setDescricao(result.getString(2));
                t.setStatus(result.getInt(3));
                t.setDataCreation(result.getString(4));
                tarefas.add(t);
                result.moveToNext();
            }
        }
        return tarefas;
    }

    public List<TaskBean> TasksPendentes() {
        List<TaskBean> tasks = new ArrayList<TaskBean>();;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select id, title, descricao, status, strftime('%d-%m-%Y %H:%M:%S', creation_time) as time from task where status = 0", null);
        if (result != null && result.getCount() > 0) {
            //tasks = new ArrayList<Task>();
            result.moveToFirst();
            while (result.isAfterLast() == false) {
                TaskBean task = new TaskBean();
                task.setId(result.getInt(0));
                task.setTitulo(result.getString(1));
                task.setDescricao(result.getString(2));
                task.setStatus(result.getInt(3));
                task.setDataCreation(result.getString(4));
                tasks.add(task);
                result.moveToNext();
            }
        }
        return tasks;
    }

}
