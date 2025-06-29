
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Luis
 */


public class ConsultaMedica {

    private String paciente;
    private String  cuenta;
    private String tipoCita;
    private String medico;
    private LocalDateTime fechaHora;
    private String motivo;

    
    public ConsultaMedica(String paciente, String cuenta, String tipoCita, String medico, LocalDateTime fechaHora, 
                   String motivo) {
        this.paciente = paciente;
        this.cuenta = cuenta;
        this.tipoCita = tipoCita;
        this.medico = medico;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
    }
    
    // Getters y Setters
    public String getPaciente() { return paciente; }
    public void setPaciente(String paciente) { this.paciente = paciente; }
    
    public String getCuenta() { return cuenta; }
    public void setCuenta(String cuenta) { this.cuenta = cuenta; }   
    
    public String getTipoCita() { return tipoCita; }
    public void setTipoCita(String tipoCita) { this.tipoCita = tipoCita; }
    
    public String getMedico() { return medico; }
    public void setMedico(String medico) { this.medico = medico; }
    
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    
    @Override
    public String toString() {
        return "Consulta: " + paciente + " con Dr. " + medico + 
               " - " + fechaHora.toString();
    }
}