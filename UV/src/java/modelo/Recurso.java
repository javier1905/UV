package modelo;


public class Recurso {
    private  int id;
    private String titulo;
    private String detalle;
    private String formato;
    private byte[] archivo;
    private boolean pub_priv;
    private Materia materia;

    public Recurso() {
        materia=new Materia();
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getFormato() {
        return formato;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public boolean isPub_priv() {
        return pub_priv;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public void setPub_priv(boolean pub_priv) {
        this.pub_priv = pub_priv;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Recurso{" + "id=" + id + ", titulo=" + titulo + ", detalle=" + detalle + ", formato=" + formato + ", archivo=" + archivo + ", pub_priv=" + pub_priv + ", materia=" + materia + '}';
    }
    
    
}
