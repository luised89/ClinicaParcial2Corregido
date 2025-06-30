package view;

/**
 *
 * @author Luis
 */
import Conection.Accesbd;
import static Conection.Accesbd.usuarioEncontrado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.ClinicaManager;
import model.Paciente;
import model.Medico;
import model.Administrativomodel;
import model.ConsultaMedica;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;


public class Administrativo extends javax.swing.JFrame {
    
    
    String usrt = Accesbd.usuarioEncontrado;
    String pacent = Accesbd.pacienteEncontrado;
    String fechaHoraStr = null;
    String namePaciente = null;
    LocalDateTime fechaHoraSolicitada = null;
    
    
    private ClinicaManager manager;
    public Administrativo() {
        initComponents();
        this.manager = new ClinicaManager();
        cargarDatosIniciales();
        cargarCitas();
        cargarMedicos();
    }
    
    
    public String[] obtenerNombresMedicosPorEspecialidad(String tipoEspecialidad) {
    List<Medico> medicos = manager.listarMedicos();
    
    // Filtrar médicos por especialidad y mapear a sus nombres
    List<String> nombres = medicos.stream()
        .filter(medico -> tipoEspecialidad.equals(medico.getEspecialidad()))
        .map(Medico::getNombre)
        .collect(Collectors.toList());
    
    // Convertir la lista a array String[]
    return nombres.toArray(new String[0]);
                                                }
    
    
public String obtenerCuentaMedica(String nombre) {
    return manager.listarMedicos().stream()
            .filter(medico -> nombre.equals(medico.getNombre()))
            .map(Medico::getCuenta)
            .findFirst()
            .orElse(null);  // Devuelve null si no encuentra al médico
    }
    

    
    //########## SE CARGAN DATOS DE PACIENTES
    private void cargarDatosIniciales() {
        try {
        List<Paciente> pacientes = manager.listarPacientes();
        /**System.out.println("=== LISTADO DE PACIENTES ===");
        System.out.printf("%-20s %-15s %-10s %-10s %-15s %s%n", 
            "Nombre", "Documento", "Cuenta", "Tipo Sangre", "Nacimiento", "Alergias");
        
        pacientes.forEach(p -> {
            System.out.printf("%-20s %-15s %-10s %-10s %-15s %s%n", 
                p.getNombre(),
                p.getIdentificacion(),
                p.getCuenta(),
                p.getTipoSangre(),
                p.getFechaNacimiento(),
                p.getAlergias());
                * 
        
        });
        */
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al cargar pacientes: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    }
    

    
    //########## SE CARGAN DATOS DE CITAS
    private void cargarCitas() {
        try {
        List<ConsultaMedica> citas = manager.listarCitas();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al cargar citas: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    }
    
//#########ARRAY CON LISTA DE CITAS
    
    private List<ConsultaMedica> ListaDeCitas() {
    try {
        return manager.listarCitas(); // Devuelve la lista directamente
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al cargar citas: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        return new ArrayList<>(); // Devuelve lista vacía en caso de error
    }
        }


        // Cambia el método para usar ConsultaMedica en lugar de Cita
    public String verificarDisponibilidad(String medicoBuscado, String fechaHoraStr, 
                                        List<ConsultaMedica> citasExistentes) {
        try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaHoraBuscada = LocalDateTime.parse(fechaHoraStr, formatter);
                    
            for (ConsultaMedica cita : citasExistentes) {
                // Verificar si es el mismo médico
                if (cita.getMedico().equals(medicoBuscado)) {
                    // Comparar directamente los LocalDateTime
                    if (cita.getFechaHora().equals(fechaHoraBuscada)) {
                        return "Error: No disponible - El médico ya tiene cita programada en ese horario";
                    }
                }
            }
            return "Disponible";
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                "Error al verificar disponibilidad: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return "Error en verificación";
                                        }
    }
    
    
    
    
        //########## SE CARGAN DATOS DE MEDICOS
    private void cargarMedicos() {
        try {
        List<Medico> medicos = manager.listarMedicos();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al cargar medicos: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        crearmedico = new javax.swing.JMenu();
        CrearPaciente = new javax.swing.JMenuItem();
        crearmedic = new javax.swing.JMenuItem();
        crearadmin = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        VerPacientes = new javax.swing.JMenuItem();
        verMedicos = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Acceso Administrativo");

        jLabel2.setText(usrt);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(92, 92, 92)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jMenu1.setText("Usuario");

        jMenuItem1.setText("Cambiar de Usuario ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Servicio");

        jMenuItem4.setText("Agenda");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem3.setText("Agendar Cita  ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        crearmedico.setText("Crear Perfil ");

        CrearPaciente.setText("Paciente");
        CrearPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearPacienteActionPerformed(evt);
            }
        });
        crearmedico.add(CrearPaciente);

        crearmedic.setText("Médico");
        crearmedic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearmedicActionPerformed(evt);
            }
        });
        crearmedico.add(crearmedic);

        crearadmin.setText("Administrativo");
        crearadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearadminActionPerformed(evt);
            }
        });
        crearmedico.add(crearadmin);

        jMenuBar1.add(crearmedico);

        jMenu3.setText("Consulta");

        VerPacientes.setText("Paciente");
        VerPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerPacientesActionPerformed(evt);
            }
        });
        jMenu3.add(VerPacientes);

        verMedicos.setText("Medico");
        verMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verMedicosActionPerformed(evt);
            }
        });
        jMenu3.add(verMedicos);

        jMenuItem6.setText("Peticiones hechas por medico");
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Historial");

        jMenuItem7.setText("Paciente");
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Médico");
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void crearmedicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearmedicActionPerformed
      
        // ######## Registrar nuevo Medico
        
        
        String nombre = JOptionPane.showInputDialog("Nombre del médico:");
        String identificacion = JOptionPane.showInputDialog("Identificación:");
        String cuentasin = JOptionPane.showInputDialog("Cuenta sin @medic:");
        String clave1 = JOptionPane.showInputDialog("clave:");
        String clave2 = JOptionPane.showInputDialog("repetir clave:");
        String especialidad = JOptionPane.showInputDialog("Especialidad:");
        String cuenta = cuentasin + ("@medic");
        
        if(clave1.equals(clave2)){
        
        Medico nuevo = new Medico(nombre, identificacion, cuenta, 
                                   clave1, especialidad);
        if (manager.registrarMedico(nuevo)) {
            JOptionPane.showMessageDialog(this, "Médico registrado!");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        }else{JOptionPane.showMessageDialog(this, "Las claves no coinciden", "Error", JOptionPane.ERROR_MESSAGE);}
        
        
        
    }//GEN-LAST:event_crearmedicActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       
        try {
            // Crear y mostrar nuevo frame
            VentanaPrincipal nuevoFrame = new VentanaPrincipal();
            nuevoFrame.setLocationRelativeTo(null); // Centrar en pantalla
            nuevoFrame.setVisible(true);

            // Cerrar el frame actual
            this.dispose();
        } catch (Exception e) {

        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void CrearPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearPacienteActionPerformed
        // 1. Definir los tipos de sangre válidos
    String[] tiposSangre = {"O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-"};
    
    // 2. Crear cuadros de diálogo para cada dato
    String nombre = JOptionPane.showInputDialog(this, "Nombre del paciente:");
    if (nombre == null || nombre.trim().isEmpty()) return;
    
    String identificacion = JOptionPane.showInputDialog(this, "Identificación:");
    if (identificacion == null || identificacion.trim().isEmpty()) return;
    
    String cuentasin = JOptionPane.showInputDialog(this, "Cuenta sin @paciente:");
    if (cuentasin == null || cuentasin.trim().isEmpty()) return;
    
    // 3. Cuadro de diálogo especial para tipo de sangre

    JComboBox<String> sangreComboBox = new JComboBox<>(tiposSangre);
    JPanel panelSangre = new JPanel();
    panelSangre.add(new JLabel("Tipo de Sangre:"));
    panelSangre.add(sangreComboBox);
    
    int resultado = JOptionPane.showConfirmDialog(
        this, 
        panelSangre, 
        "Seleccione Tipo de Sangre", 
        JOptionPane.OK_CANCEL_OPTION
    );
    
    if (resultado != JOptionPane.OK_OPTION) return;
    String tipoSangre = (String)sangreComboBox.getSelectedItem();
    
   
    // Configurar el JSpinner con modelo de fecha
    String FNacimiento = null;
    SpinnerDateModel spinnerModel = new SpinnerDateModel();
    JSpinner spinner = new JSpinner(spinnerModel);
    JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "yyyy/MM/dd");
    spinner.setEditor(editor);

    // Mostrar el diálogo con el JSpinner
    int option = JOptionPane.showConfirmDialog(
        this, 
        spinner, 
        "Seleccione la fecha de nacimiento - yyyy/MM/dd", 
        JOptionPane.OK_CANCEL_OPTION
                                    );

    // Procesar la fecha seleccionada
    if (option == JOptionPane.OK_OPTION) {
        Date fechaSeleccionada = (Date) spinner.getValue();
    
        // Formatear la fecha como String (dd/MM/yyyy)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        FNacimiento = sdf.format(fechaSeleccionada);
    
        JOptionPane.showMessageDialog(this, "Fecha seleccionada: " + FNacimiento);
        }
    
      
    //#### registrar alergias
    String alergias = JOptionPane.showInputDialog(this, "Alergias:");
    
    // 5. Registrar paciente
    String cuenta = cuentasin + "@paciente";
    Paciente nuevo = new Paciente(nombre, identificacion, cuenta, 
                               tipoSangre, FNacimiento, alergias);
    
    if (manager.registrarPaciente(nuevo)) {
        JOptionPane.showMessageDialog(this, "Paciente registrado!");
    } else {
        JOptionPane.showMessageDialog(this, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_CrearPacienteActionPerformed

    private void crearadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearadminActionPerformed
        
            // ######## Registrar nuevo Administrativo
        
        
        String nombre = JOptionPane.showInputDialog("Nombre del Admin:");
        String identificacion = JOptionPane.showInputDialog("Identificación:");
        String cuentasin = JOptionPane.showInputDialog("Cuenta sin @admin:");
        String clave1 = JOptionPane.showInputDialog("clave:");
        String clave2 = JOptionPane.showInputDialog("repetir clave:");
        String cargo = JOptionPane.showInputDialog("cargo:");
        String cuenta = cuentasin + ("@admin");
        
        if(clave1.equals(clave2)){
        
        Administrativomodel nuevo = new Administrativomodel(nombre, identificacion, cuenta, 
                                   clave1, cargo);
        if (manager.registrarAdmin(nuevo)) {
            JOptionPane.showMessageDialog(this, "Administrativo registrado!");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        }else{JOptionPane.showMessageDialog(this, "Las claves no coinciden", "Error", JOptionPane.ERROR_MESSAGE);}
        
        
    
    }//GEN-LAST:event_crearadminActionPerformed

    private void VerPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerPacientesActionPerformed
   
        try {
        // 1. Obtener lista de pacientes
        List<Paciente> pacientes = manager.listarPacientes();
        
        // 2. Crear modelo de tabla
        DefaultTableModel model = new DefaultTableModel();
        
        // 3. Configurar columnas
        model.addColumn("Nombre");
        model.addColumn("Documento");
        model.addColumn("Cuenta");
        model.addColumn("Sangre");
        model.addColumn("Fecha_Nacimiento");
        model.addColumn("Alergias");
        
        // 4. Llenar datos
        for(Paciente p : pacientes) {
            model.addRow(new Object[]{
                p.getNombre(),
                p.getIdentificacion(),
                p.getCuenta(),
                p.getTipoSangre(),
                p.getFechaNacimiento(),
                p.getAlergias()
            });
        }
        
        // 5. Crear y configurar tabla
        JTable tabla = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabla);
        
        // 6. Mostrar en un diálogo (opción simple)
        JOptionPane.showMessageDialog(
            this,
            scrollPane,
            "Listado de Pacientes",
            JOptionPane.PLAIN_MESSAGE
        );
        
        // Alternativa: Mostrar en el JFrame principal
        // jPanel1.removeAll();
        // jPanel1.add(scrollPane, BorderLayout.CENTER);
        // jPanel1.revalidate();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al cargar pacientes: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
        
        
        
    }//GEN-LAST:event_VerPacientesActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        
        //######### Lista de citas   
         
        try {
        // 1. Obtener lista de citas
        List<ConsultaMedica> citas = manager.listarCitas();
        
        // 2. Crear modelo de tabla
        DefaultTableModel model = new DefaultTableModel();
        
        // 3. Configurar columnas
        model.addColumn("Paciente");
        model.addColumn("Cuenta");
        model.addColumn("Tipo de Cita");
        model.addColumn("Medico");
        model.addColumn("Fecha y Hora");
        model.addColumn("Motivo");
        
        // 4. Llenar datos
        for(ConsultaMedica p : citas) {
            model.addRow(new Object[]{
                p.getPaciente(),
                p.getCuenta(),
                p.getTipoCita(),
                p.getMedico(),
                p.getFechaHora(),
                p.getMotivo()
            });
        }
        
        // 5. Crear y configurar tabla
        JTable tabla = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabla);
        
        // 6. Mostrar en un diálogo (opción simple)
        JOptionPane.showMessageDialog(
            this,
            scrollPane,
            "Listado de Citas",
            JOptionPane.PLAIN_MESSAGE
        );
        
        // Alternativa: Mostrar en el JFrame principal
        // jPanel1.removeAll();
        // jPanel1.add(scrollPane, BorderLayout.CENTER);
        // jPanel1.revalidate();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al cargar citas: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }

        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        String[] tiposCita = {"Fisioterapia", "General", "Odontologia", "Optometria"};
        String[] hora = {"09:00:00", "09:30:00", "10:00:00", "10:30:00", "11:00:00", "11:30:00", "13:00:00", "13:30:00",
                            "14:00:00", "14:30:00", "15:00:00", "15:30:00"};
        
           // ######## Registrar nueva Cita

        
        String cuentapaciente = JOptionPane.showInputDialog("Digite la cuenta:");
        
            Accesbd busq = new Accesbd();
            boolean Acceso = busq.buscarPacientes(cuentapaciente);
            if (Acceso == true){System.out.println("Cuenta verificada");
                                pacent = Accesbd.pacienteEncontrado;
                                System.out.println(pacent);
                                
                                try { namePaciente = pacent;
                                    } catch (Exception e) {   
                                                        }
            } 
        
        JComboBox<String> tipoComboBox = new JComboBox<>(tiposCita);
        JPanel paneltipoCita = new JPanel();
        paneltipoCita.add(new JLabel("Tipo de Cita:"));
        paneltipoCita.add(tipoComboBox);
    
        int resultado = JOptionPane.showConfirmDialog(
        this, 
        paneltipoCita, 
        "Seleccione Tipo de Cita", 
        JOptionPane.OK_CANCEL_OPTION
                                        );
        
        if (resultado != JOptionPane.OK_OPTION) return;
        String tipoCita = (String)tipoComboBox.getSelectedItem();    
        
        String[] NombresDeMedicos = obtenerNombresMedicosPorEspecialidad(tipoCita);
        
        JComboBox<String> namemedicComboBox = new JComboBox<>(NombresDeMedicos);
        JPanel panelmedics = new JPanel();
        panelmedics.add(new JLabel("Medicos:"));
        panelmedics.add(namemedicComboBox);
    
        int resultado2 = JOptionPane.showConfirmDialog(
        this, 
        panelmedics, 
        "Seleccione el medico", 
        JOptionPane.OK_CANCEL_OPTION
                                        );
        
        if (resultado2 != JOptionPane.OK_OPTION) return;
        String medicoSolicitado = (String)namemedicComboBox.getSelectedItem();    
        
        String ctamedica = obtenerCuentaMedica(medicoSolicitado);
        System.out.println("aqui va la cuenta "+ ctamedica);
        
 
        JComboBox<String> horaComboBox = new JComboBox<>(hora);
        JPanel panelhora = new JPanel();
        panelhora.add(new JLabel("Hora:"));
        panelhora.add(horaComboBox);
    
        int resultado3 = JOptionPane.showConfirmDialog(
        this, 
        panelhora, 
        "Seleccione la hora", 
        JOptionPane.OK_CANCEL_OPTION
                                        );
        
        if (resultado3 != JOptionPane.OK_OPTION) return;
        String horaSolicitada = (String)horaComboBox.getSelectedItem();    
 

    // Configurar el JSpinner con modelo de fecha
    String FSolicitada = null;
    SpinnerDateModel spinnerModel = new SpinnerDateModel();
    JSpinner spinner = new JSpinner(spinnerModel);
    JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "yyyy-MM-dd");
    spinner.setEditor(editor);

    // Mostrar el diálogo con el JSpinner
    int option = JOptionPane.showConfirmDialog(
        this, 
        spinner, 
        "Seleccione la fecha de la cita - yyyy-MM-dd", 
        JOptionPane.OK_CANCEL_OPTION
        );

    // Procesar la fecha seleccionada
    if (option == JOptionPane.OK_OPTION) {
        Date fechaSeleccionada = (Date) spinner.getValue();
    
        // Crear un calendario para verificar el día de la semana
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaSeleccionada);
        int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
    
        // Verificar si es sábado (7) o domingo (1)
        if (diaSemana == Calendar.SATURDAY || diaSemana == Calendar.SUNDAY) {
            JOptionPane.showMessageDialog(this, 
            "Error: No se permiten citas los sábados ni domingos", 
            "Día no válido", 
            JOptionPane.ERROR_MESSAGE);
            return; // Salir del método o volver a mostrar el diálogo
        }
    
        // Formatear la fecha como String (yyyy/MM/dd)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        FSolicitada = sdf.format(fechaSeleccionada);
    
        JOptionPane.showMessageDialog(this, "Fecha seleccionada: " + FSolicitada);
    }        
    

    // 1. Combinar fecha y hora
    fechaHoraStr = FSolicitada + " " + horaSolicitada;
    // 2. Parsear a objeto DateTime
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    fechaHoraSolicitada = LocalDateTime.parse(fechaHoraStr, formatter);
    
    // 3. Convertir a formato MySQL (yyyy-MM-dd HH:mm:ss)
//    SimpleDateFormat mysqlFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    String mysqlDateTime = mysqlFormat.format(fechaHora);
    
//    System.out.println("DATETIME para MySQL: " + mysqlDateTime); //###### Fecha que se guardara en mysql
// Ejemplo de resultado: "2023-11-15 14:30:00"
    
        //#### registrar Motivo
        String Motivo = JOptionPane.showInputDialog(this, "Motivo:");
    
    //########COMPROBAR DISPONIBILIDAD
    
    String disponibilidad = verificarDisponibilidad(medicoSolicitado, fechaHoraStr, ListaDeCitas());

    if (disponibilidad.equals("Disponible")) {
        // Proceder a agendar la cita
        ConsultaMedica nueva = new ConsultaMedica(namePaciente, cuentapaciente, tipoCita, medicoSolicitado,
                                                   ctamedica, fechaHoraSolicitada, Motivo );
        
        if (manager.registrarCita(nueva)) {
            JOptionPane.showMessageDialog(this, "Cita Registrada!");
                                            } else {
            JOptionPane.showMessageDialog(this, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
                                                     }
         
        } else {
    // Mostrar error
    JOptionPane.showMessageDialog(null, resultado, "No disponible", JOptionPane.WARNING_MESSAGE);
                }
     
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void verMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verMedicosActionPerformed

        try {
        // 1. Obtener lista de medicos
        List<Medico> medicos = manager.listarMedicos();
        
        // 2. Crear modelo de tabla
        DefaultTableModel model = new DefaultTableModel();
        
        // 3. Configurar columnas
        model.addColumn("Nombre");
        model.addColumn("Documento");
        model.addColumn("Cuenta");
        model.addColumn("Especialidad");
        
        // 4. Llenar datos
        for(Medico p : medicos) {
            model.addRow(new Object[]{
                p.getNombre(),
                p.getIdentificacion(),
                p.getCuenta(),
                p.getEspecialidad()
            });
        }
        
        // 5. Crear y configurar tabla
        JTable tabla = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabla);
        
        // 6. Mostrar en un diálogo (opción simple)
        JOptionPane.showMessageDialog(
            this,
            scrollPane,
            "Listado de Medicos",
            JOptionPane.PLAIN_MESSAGE
        );
        
        // Alternativa: Mostrar en el JFrame principal
        // jPanel1.removeAll();
        // jPanel1.add(scrollPane, BorderLayout.CENTER);
        // jPanel1.revalidate();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al cargar pacientes: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
        
      
       
    }//GEN-LAST:event_verMedicosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administrativomodel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrativomodel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrativomodel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrativomodel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrativo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CrearPaciente;
    private javax.swing.JMenuItem VerPacientes;
    private javax.swing.JMenuItem crearadmin;
    private javax.swing.JMenuItem crearmedic;
    private javax.swing.JMenu crearmedico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem verMedicos;
    // End of variables declaration//GEN-END:variables
}
