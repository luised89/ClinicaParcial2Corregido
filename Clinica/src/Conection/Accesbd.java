package Conection;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Accesbd {
    
    public static String usuarioEncontrado;
    
    private static Connection con;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String url = "jdbc:mysql://localhost:3306/clinica";
    private static List<Map<String, Object>> listaUsuarios = new ArrayList<>(); // Lista para almacenar usuarios
    private static List<Map<String, Object>> listaPacientes = new ArrayList<>(); // Lista para almacenar pacientes
    private static List<Map<String, Object>> listaCitas = new ArrayList<>(); // Lista para almacenar citas

    public String consultageneral() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexion establecida");
                return "conexion";
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion" + e);
            return "fallo";
        }
        return null;
    }

//##### CONSULTAR USUARIOS Y PONERLOS EN EL MAPA    
    
    
    public void consultauser(String tabla) {
        listaUsuarios.clear(); // Limpiar lista antes de nueva consulta
        
        try {
            PreparedStatement consulta = con.prepareStatement(
                "SELECT Id, Nombre, Documento, Cuenta, Pass FROM " + tabla); // quitamos cargo para evitar conflicto entre admin y medic
            
            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()) {
                Map<String, Object> usuario = new LinkedHashMap<>(); // Nuevo mapa por cada usuario
                usuario.put("Id", resultado.getInt("Id"));
                usuario.put("Nombre", resultado.getString("Nombre"));
                usuario.put("Documento", resultado.getString("Documento"));
                usuario.put("Cuenta", resultado.getString("Cuenta"));
                usuario.put("Pass", resultado.getString("Pass"));
                //usuario.put("Cargo", resultado.getString("Cargo"));            
                
                listaUsuarios.add(usuario);
                
                // Mostrar en consola
                System.out.printf("%-5d %-30s %-20s %-20s %-20s%n", //quitamos el espacio de cargo
                    usuario.get("Id"),
                    usuario.get("Nombre"),
                    usuario.get("Documento"),
                    usuario.get("Cuenta"),
                    usuario.get("Pass"));
                    //usuario.get("Cargo"));
            }
        } catch (SQLException ex) {
            System.err.println("Error al recuperar usuarios: " + ex.getMessage());
        }
    }

    
    
    //#######BUSCAR USUARIOS EN EL MAPA
    
    public static boolean buscarUsuario(String cuenta, String clavein) {
        if (cuenta == null || clavein == null) {
            System.out.println("Datos de acceso incompletos");
            return false;
        }

        for (Map<String, Object> mapadeusuario : listaUsuarios) {
            String cuentaobt = (String) mapadeusuario.get("Cuenta");
            String passobt = (String) mapadeusuario.get("Pass");
            
            if (cuenta.equalsIgnoreCase(cuentaobt)) {
                if (clavein.equals(passobt)) {
                    System.out.println("\nUsuario autenticado:");
                    System.out.println("Cuenta: " + cuentaobt);
                    usuarioEncontrado = cuentaobt;
                    return true;
                } else {
                    System.out.println("Contraseña incorrecta");
                    JOptionPane.showMessageDialog(null, "❌ Contraseña incorrecta");
                    return false;
                }
            }
        }
        
        System.out.println("No se encontró el usuario '" + cuenta + "'");
        return false;
    }
    
    
    //##### CONSULTAR pACIENTES Y PONERLOS EN EL MAPA    
    
    
    public void consultarpaciente(String tabla) {
        listaPacientes.clear(); // Limpiar lista antes de nueva consulta
        
        try {
            PreparedStatement consulta = con.prepareStatement(
                "SELECT Id, Nombre, Documento, Cuenta, Sangre, Fecha_Nacimiento, Alergias FROM " + tabla);
            
            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()) {
                Map<String, Object> usuario = new LinkedHashMap<>(); // Nuevo mapa por cada usuario
                usuario.put("Id", resultado.getInt("Id"));
                usuario.put("Nombre", resultado.getString("Nombre"));
                usuario.put("Documento", resultado.getString("Documento"));
                usuario.put("Cuenta", resultado.getString("Cuenta"));
                usuario.put("Sangre", resultado.getString("Sangre"));
                usuario.put("Fecha_Nacimiento", resultado.getString("Fecha_Nacimiento")); 
                usuario.put("Alergias", resultado.getString("Alergias"));
                
                listaPacientes.add(usuario);
                
                // Mostrar en consola
                System.out.printf("%-5d %-30%n",
                    usuario.get("Id"),
                    usuario.get("Nombre"));                    
            }
        } catch (SQLException ex) {
            System.err.println("Error al recuperar pacientes: " + ex.getMessage());
        }
    }
    
    
    
        //##### CONSULTAR CITAS Y PONERLAS EN EL MAPA    
    
    
    public void consultarcitas(String tabla) {
        listaCitas.clear(); // Limpiar lista antes de nueva consulta
        
        try {
            PreparedStatement consulta = con.prepareStatement(
                "SELECT Id, Paciente, Cuenta, TipoCita, Medico, FechaHora, Motivo FROM " + tabla);
            
            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()) {
                Map<String, Object> usuario = new LinkedHashMap<>(); // Nuevo mapa por cada usuario
                usuario.put("Id", resultado.getInt("Id"));
                usuario.put("Paciente", resultado.getString("Paciente"));
                usuario.put("Cuenta", resultado.getString("Cuenta"));
                usuario.put("TipoCita", resultado.getString("TipoCita"));
                usuario.put("Medico", resultado.getString("Medico")); 
                usuario.put("FechaHora", resultado.getString("FechaHora"));
                usuario.put("Motivo", resultado.getString("Motivo"));
                
                listaCitas.add(usuario);
                
                // Mostrar en consola
                System.out.printf("%-5d %-30%n",
                    usuario.get("Id"),
                    usuario.get("Paciente"));                    
            }
        } catch (SQLException ex) {
            System.err.println("Error al recuperar citas: " + ex.getMessage());
        }
    }
    
    /**########################
     * Ejecuta una consulta SQL de actualización (INSERT, UPDATE, DELETE)
     * @param sql La consulta SQL a ejecutar
     * @return Cantidad de filas afectadas
     * @throws SQLException Si ocurre un error en la base de datos
     */
    public int executeUpdate(String sql) throws SQLException {
        try (Statement stmt = con.createStatement()) {
            return stmt.executeUpdate(sql);
        }
    }

    /**
     * Obtiene la lista de usuarios cargada en memoria
     * @return Lista de usuarios como Mapas
     */
    public static List<Map<String, Object>> getListaUsuarios() {
        return listaUsuarios;
    }
    
    public static List<Map<String, Object>> getListaPacientes() {
        return listaPacientes;
    }
    
    public static List<Map<String, Object>> getListaCitas() {
        return listaCitas;
    }
    
}