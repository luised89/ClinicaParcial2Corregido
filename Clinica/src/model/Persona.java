
package model;

/**
 *
 * @author Luis
 */

public abstract class Persona {
    protected String nombre;
    protected String identificacion;
    protected String cuenta;
    
    
    public Persona(String nombre, String identificacion, String cuenta) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.cuenta = cuenta;
        
    }
    
    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }
    
    public String getCuenta() { return cuenta; }
    public void setCuenta(String cuenta) { this.cuenta = cuenta; }
    
    @Override
    public String toString() {
        return nombre + " "+"(" + identificacion + ") " + cuenta;
    }
}