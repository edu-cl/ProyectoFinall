package Model;

public class Enemigo {

    private String codigo;
    private String nombre;
    private String ataque;
    private String defensa;
    private String vida;

    public Enemigo() {
    }

    public Enemigo(String codigo, String nombre, String ataque, String defensa, String vida) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
    }

    public Enemigo(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.vida = generarVida();
        this.ataque = generarAtaque();
        this.defensa = generarDefensa();
    }

    public Enemigo(String nombre) {
        this.nombre = nombre;
        this.vida = generarVida();
        this.ataque = generarAtaque();
        this.defensa = generarDefensa();
    }

    public String generarVida() {
        int Calculo = (int) Math.floor(Math.random() * 100 + 1);
        String vida = Integer.toString(Calculo);
        return vida;
    }

    public String generarAtaque() {
        int Calculo = (int) Math.floor(Math.random() * 30 + 1);
        String ataque = Integer.toString(Calculo);
        return ataque;
    }

    public String generarDefensa() {
        int Calculo = (int) Math.floor(Math.random() * 20 + 1);
        String defensa = Integer.toString(Calculo);
        return defensa;
    }

    public String getVida() {
        return vida;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public String getDefensa() {
        return defensa;
    }

    public void setDefensa(String defensa) {
        this.defensa = defensa;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Enemigo other = (Enemigo) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    public int compareTo(Enemigo e) {
        int result = 0;
        if (e != null) {
            if (this.nombre.toLowerCase().equals(e.getNombre().toLowerCase())) {
                result = 0;
            } else if (this.nombre.toLowerCase().compareTo(e.getNombre().toLowerCase()) > 0) {
                result = 1;
            } else if (this.nombre.toLowerCase().compareTo(e.getNombre().toLowerCase()) < 0) {
                result = -1;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Enemigo{" + "codigo=" + codigo + ", nombre=" + nombre + ", ataque=" + ataque + ", defensa=" + defensa + '}';
    }

}