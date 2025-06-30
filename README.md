# Proyecto Java: Sistema de Gestión Clínica
Este proyecto es un sistema de gestión para una clínica desarrollado en Java con interfaz gráfica (Swing). Permite administrar médicos, pacientes y consultas médicas, con autenticación de usuarios según su rol (administrativo o médico).

## Estructura del Proyecto

Clinica/  
├── Source Packages/  
│   ├── main.java                # Punto de entrada (abre VentanaPrincipal)  
│   ├── Conection/  
│   │   └── Accesbd.java         # Manejo de conexión a base de datos  
│   ├── model/  
│   │   ├── Administrativomodel.java  # Lógica de usuarios administrativos  
│   │   ├── ClinicaManager.java       # Gestión centralizada de operaciones  
│   │   ├── ConsultaMedica.java       # Modelo de consultas médicas  
│   │   ├── Medico.java               # Modelo de médicos  
│   │   ├── Paciente.java             # Modelo de pacientes  
│   │   └── Persona.java              # Clase base (herencia)  
│   └── view/  
│       ├── Administrativo.java       # Interfaz para administrativos  
│       ├── Medico.java               # Interfaz para médicos  
│       └── VentanaPrincipal.java     # Ventana de inicio de sesión  

## Componentes Principales
### 1. Clases del Modelo
Persona.java: Clase abstracta base con atributos comunes (nombre, identificación, cuenta).

Medico.java y Paciente.java: Heredan de Persona y añaden atributos específicos (especialidad, tipo de sangre, alergias).

ClinicaManager.java: Coordina operaciones como registro de usuarios y consultas.

Accesbd.java: Gestiona la conexión y consultas SQL a la base de datos.

### 2. Interfaz Gráfica (View)
VentanaPrincipal.java: Ventana de inicio de sesión que redirige según el rol:

Administrativos: Acceso a Administrativo.java (gestión de médicos/pacientes).

Médicos: Acceso a Medico.java (registro de consultas).

Las interfaces usan JFrame y componentes Swing (JOptionPane, JTextField, etc.).

### 3. Autenticación y Roles
Los usuarios se registran con cuentas únicas:

cuenta@medic para médicos.

cuenta@admin para administrativos.

Las contraseñas se validan con JPasswordField (caracteres ocultos).

## Funcionalidades Clave

Registro de usuarios (médicos y pacientes) con validación de claves.
