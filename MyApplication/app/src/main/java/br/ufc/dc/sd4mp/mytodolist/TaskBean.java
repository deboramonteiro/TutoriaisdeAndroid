package br.ufc.dc.sd4mp.mytodolist;

/**
 * Created by 0333399 on 11/05/15.
 */
public class TaskBean {

    private String titulo;
    private String descricao;
    private String dataCreation;
    private int status;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData_creation() {
        return dataCreation;
    }

    public void setDataCreation(String data_creation) {
        this.dataCreation = data_creation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String printDados()
    {
        String strStatus = (status == 1)? "Concluída":"Pendente";
        return "id:\t"+id+"\nTítulo:\t"+titulo+"\nDescrição:\t"+descricao+"\nStatus:\t"+strStatus+"\nCriada em:\t"+dataCreation+"\n\n";
    }




}
