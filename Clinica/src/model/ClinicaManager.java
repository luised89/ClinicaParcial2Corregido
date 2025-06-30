
package model;

/**
 *
 * @author Luis
 */
import Conection.Accesbd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class ClinicaManager {

    private Accesbd database;

    public ClinicaManager() {
        this.database = new Accesbd();
        if (!"conexion".equals(database.consultageneral())) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            System.exit(1);
        }
    }

    //#################### Método genérico para ejecutar consultas de usuario####
    private List<Map<String, Object>> ejecutarConsulta(String tabla) {
        database.consultauser(tabla);
        return Accesbd.getListaUsuarios(); // SE necesita hacer pública la lista o agregar getter
    }

        //########## Método genérico para ejecutar consultas de pacientes########
    private List<Map<String, Object>> ejecutarConsultapct(String tabla) {
        database.consultarpaciente(tabla);
        return Accesbd.getListaPacientes(); // SE necesita hacer pública la lista o agregar getter
    }
    
        //########## Método genérico para ejecutar consultas de citas########
    private List<Map<String, Object>> ejecutarConsultacit(String tabla) {
        database.consultarcitas(tabla);
        return Accesbd.getListaCitas(); // SE necesita hacer pública la lista o agregar getter
    }
    
            //########## Método genérico para ejecutar consultas de medlistaricos########
    private List<Map<String, Object>> ejecutarConsultamedic(String tabla) {
        database.consultarMedico(tabla);
        return Accesbd.getListaMedicos(); // SE necesita hacer pública la lista o agregar getter
    }
    
    
    
    // Registrar nuevo paciente #########
    public boolean registrarPaciente(Paciente paciente) {
        try {
            String sql = "INSERT INTO pacientes (nombre, documento, cuenta, sangre, fecha_nacimiento, alergias) "
                    + "VALUES ('" + paciente.getNombre() + "', '" + paciente.getIdentificacion() + "', '"
                    + paciente.getCuenta() + "', '" + paciente.getTipoSangre() + "', '"
                    + paciente.getFechaNacimiento().toString() + "', '" + paciente.getAlergias() + "')";

            // Necesitarías agregar un método executeUpdate en Accesbd
            return database.executeUpdate(sql) > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar paciente: " + e.getMessage());
            return false;
        }
    }
    
    
        // Registrar nuevo medico ##############
    public boolean registrarMedico(Medico medico) {
        try {
            String sql = "INSERT INTO medico (nombre, documento, cuenta, pass, especialidad) "
                    + "VALUES ('" + medico.getNombre() + "', '" + medico.getIdentificacion() + "', '"
                    + medico.getCuenta() + "', '" + medico.getClave()+ "', '"
                    + medico.getEspecialidad().toString() + "')";

            // Necesitarías agregar un método executeUpdate en Accesbd
            return database.executeUpdate(sql) > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar medico: " + e.getMessage());
            return false;
        }
    }
    
            // Registrar nueva cita ##############
    public boolean registrarCita(ConsultaMedica cita) {
        try {
            String sql = "INSERT INTO citas (Paciente, Cuenta, TipoCita, Medico, CuentaMedica, FechaHora, Motivo) "
                    + "VALUES ('" + cita.getPaciente() + "', '" 
                + cita.getCuenta() + "', '" 
                + cita.getTipoCita() + "', '" 
                + cita.getMedico() + "', '" 
                + cita.getCuentaMedico() + "', '"  
                + cita.getFechaHora() + "', '" 
                + cita.getMotivo().toString() + "')";

            // Necesitarías agregar un método executeUpdate en Accesbd
            return database.executeUpdate(sql) > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar cita: " + e.getMessage());
            return false;
        }
    }
    
    
    
        // Registrar nuevo admin ##############
    public boolean registrarAdmin(Administrativomodel admin) {
        try {
            String sql = "INSERT INTO administrativo (nombre, documento, cuenta, pass, cargo) "
                    + "VALUES ('" + admin.getNombre() + "', '" + admin.getIdentificacion() + "', '"
                    + admin.getCuenta() + "', '" + admin.getClave()+ "', '"
                    + admin.getCargo().toString() + "')";

            // Necesitarías agregar un método executeUpdate en Accesbd
            return database.executeUpdate(sql) > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar admin: " + e.getMessage());
            return false;
        }
    }
    
    

    // Buscar paciente por identificación
    public Paciente buscarPaciente(String identificacion) {
        List<Map<String, Object>> resultados = ejecutarConsulta("pacientes");

        for (Map<String, Object> fila : resultados) {
            if (fila.get("Documento").equals(identificacion)) {
                return new Paciente(
                        (String) fila.get("Nombre"),
                        (String) fila.get("Documento"),
                        (String) fila.get("Cuenta"),
                        (String) fila.get("Sangre"),
                        (String) fila.get("Fecha_Nacimiento"),
                        (String) fila.get("alergias")
                );
            }
        }
        return null;
    }

    // Listar todos los pacientes
    public List<Paciente> listarPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        List<Map<String, Object>> resultados = ejecutarConsultapct("pacientes");

        for (Map<String, Object> fila : resultados) {
            pacientes.add(new Paciente(
                    (String) fila.get("Nombre"),
                    (String) fila.get("Documento"),
                    (String) fila.get("Cuenta"),
                    (String) fila.get("Sangre"),
                    (String) fila.get("Fecha_Nacimiento"),
                    (String) fila.get("Alergias")
            ));
        }
        return pacientes;
    }


       // Listar todos los medicos
    public List<Medico> listarMedicos() {
        List<Medico> medicos = new ArrayList<>();
        List<Map<String, Object>> resultados = ejecutarConsultamedic("medico");

        for (Map<String, Object> fila : resultados) {
            medicos.add(new Medico(
                    (String) fila.get("Nombre"),
                    (String) fila.get("Documento"),
                    (String) fila.get("Cuenta"),
                    (String) fila.get("Clave"),
                    (String) fila.get("Especialidad")
            ));
        }
        return medicos;
    }

    
        // Listar todas las citas
    public List<ConsultaMedica> listarCitas() {
        List<ConsultaMedica> citas = new ArrayList<>();
        List<Map<String, Object>> resultados = ejecutarConsultacit("citas");

        for (Map<String, Object> fila : resultados) {
            citas.add(new ConsultaMedica(
                    (String) fila.get("Paciente"),
                    (String) fila.get("Cuenta"),
                    (String) fila.get("TipoCita"),
                    (String) fila.get("Medico"),
                    (String) fila.get("CuentaMedico"),
                    (LocalDateTime) fila.get("FechaHora"), 
                    (String) fila.get("Motivo")
            ));
        }
        return citas;
    }
    
    
    ///## lista de citas con Id
    
    public List<Map<String, Object>> listarCitasComoMap() {
    List<Map<String, Object>> resultados = ejecutarConsultacit("citas");
    
    // Opcional: puedes transformar o filtrar los datos aquí si es necesario
    return new ArrayList<>(resultados); // Devuelve una copia
}
    
    
    public boolean editarCitaSiPendiente(int idCita, String nuevoEstado, String nuevaHistoria) {
    try {
        // Primero verificamos el estado actual
        String sqlVerificar = "SELECT Estado FROM citas WHERE Id = " + idCita;
        ResultSet resultado = database.executeQuery(sqlVerificar);
        
        if (!resultado.next()) {
            JOptionPane.showMessageDialog(null, "No se encontró la cita con ID: " + idCita, 
                                       "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        String estadoActual = resultado.getString("Estado");
        if (!"Pendiente".equalsIgnoreCase(estadoActual)) {
            JOptionPane.showMessageDialog(null, 
                "Solo se pueden editar citas en estado 'Pendiente'\nEstado actual: " + estadoActual, 
                "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Si está pendiente, procedemos con la actualización
        String sqlActualizar = "UPDATE citas SET "
                            + "Estado = '" + nuevoEstado + "', "
                            + "Historia = '" + (nuevaHistoria != null ? nuevaHistoria : "") + "' "
                            + "WHERE Id = " + idCita;
        
        return database.executeUpdate(sqlActualizar) > 0;
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al editar cita: " + e.getMessage(), 
                                   "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
    
    
    
    
    
    
    // Métodos similares para Médicos y Administrativos...
    // Autenticación de usuarios (usando el método existente en Accesbd)
    public boolean autenticarUsuario(String cuenta, String clave) {
        return Accesbd.buscarUsuario(cuenta, clave);
    }
}
