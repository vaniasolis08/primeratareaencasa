package electrodomesticos;

public class tienda {

    private int codigo;
    private String nombre, marca;

    public tienda(int codigo, String nombre, String marca) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
