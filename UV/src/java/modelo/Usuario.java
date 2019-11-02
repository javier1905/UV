package modelo;

public class Usuario {
    private int id;
    private int usuario;
    private int pass;
    private String tipoUsuario;

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public Usuario() {
        usuario=-1;
    }

    public int getId() {
        return id;
    }

    public int getUsuario() {
        return usuario;
    }

    public int getPass() {
        return pass;
    }

  

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }



    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", pass=" + pass + ", id_tipoUsuario=" + tipoUsuario + '}';
    }
    
}
