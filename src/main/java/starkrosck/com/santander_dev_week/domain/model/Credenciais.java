package starkrosck.com.santander_dev_week.domain.model;

public class Credenciais {

    private int id;
    private String senha;

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getSenha(){
        return this.senha ;
    }
}
