package co.edu.uniquindio;


import javax.swing.*;

public class Main {


    static Cliente[] listaClientes = new Cliente[10];
    static Desarrollador[] listaDesarrolladores = new Desarrollador[10];
    static Proyecto[] listaProyectos = new Proyecto[10];
    static ServicioAdicional[] listaServicios = new ServicioAdicional[10];

    public static void main(String[] args) {
        cargarDatosPrueba();

        int option = 0;
        do {
            try {
                String input = JOptionPane.showInputDialog(
                        "=== SISTEMA DE GESTIÓN DEVPLUS ===\n" +
                                "Seleccione una opción:\n" +
                                "1. Registrar Cliente\n" +
                                "2. Registrar Desarrollador\n" +
                                "3. Registrar Servicio Adicional\n" +
                                "4. Registrar y Gestionar Proyecto\n" +
                                "5. Consultar Cliente por Teléfono (Validar Número Perfecto)\n" +
                                "6. Calcular Ingresos por Fecha de Solicitud\n" +
                                "0. Salir del sistema"
                );

                if (input == null) break;
                option = Integer.parseInt(input);

                switch (option) {
                    case 1:
                        solicitarRegistroCliente();
                        break;
                    case 2:
                        solicitarRegistroDesarrollador();
                        break;
                    case 3:
                        solicitarRegistroServicio();
                        break;
                    case 4:
                        solicitarRegistroProyecto();
                        break;
                    case 5:
                        solicitarConsultaClientePerfecto();
                        break;
                    case 6:
                        solicitarCalculoIngresosFecha();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema DevPlus.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
            }
        } while (option != 0);
    }


    private static void solicitarRegistroCliente() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre completo o razón social:");
        String documento = JOptionPane.showInputDialog("Ingrese el documento o NIT:");
        String telefono = JOptionPane.showInputDialog("Ingrese el número de teléfono:");
        String email = JOptionPane.showInputDialog("Ingrese el correo electrónico:");
        String pais = JOptionPane.showInputDialog("Ingrese el país de procedencia:");

        Cliente nuevoCliente = new Cliente(nombre, documento, telefono, email, pais, false);

        if (registrarCliente(nuevoCliente)) {
            JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar (límite alcanzado o ya existe).");
        }
    }

    public static boolean registrarCliente(Cliente nuevoCliente) {
        for (int i = 0; i < listaClientes.length; i++) {
            if (listaClientes[i] == null) {
                listaClientes[i] = nuevoCliente;
                return true;
            }
        }
        return false;
    }


    private static void solicitarRegistroDesarrollador() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del desarrollador:");
        String equipo = JOptionPane.showInputDialog("Ingrese el equipo de trabajo:");
        String nivel = JOptionPane.showInputDialog("Ingrese el nivel (Junior, Semisenior, Senior):");
        int cantMax = Integer.parseInt(JOptionPane.showInputDialog("Cantidad máxima de proyectos simultáneos:"));
        double tarifa = Double.parseDouble(JOptionPane.showInputDialog("Tarifa por día:"));

        Desarrollador nuevoDev = new Desarrollador(codigo, equipo, nivel, cantMax, tarifa, "Disponible", true);

        if (registrarDesarrollador(nuevoDev)) {
            JOptionPane.showMessageDialog(null, "Desarrollador registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el desarrollador.");
        }
    }

    public static boolean registrarDesarrollador(Desarrollador dev) {
        for (int i = 0; i < listaDesarrolladores.length; i++) {
            if (listaDesarrolladores[i] == null) {
                listaDesarrolladores[i] = dev;
                return true;
            }
        }
        return false;
    }


    private static void solicitarRegistroServicio() {
        String codigo = JOptionPane.showInputDialog("Código del servicio:");
        String nombre = JOptionPane.showInputDialog("Nombre del servicio:");
        String desc = JOptionPane.showInputDialog("Descripción:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));

        ServicioAdicional servicio = new ServicioAdicional(codigo, nombre, desc, precio, true);

        for (int i = 0; i < listaServicios.length; i++) {
            if (listaServicios[i] == null) {
                listaServicios[i] = servicio;
                JOptionPane.showMessageDialog(null, "Servicio registrado correctamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No hay espacio para más servicios.");
    }


    private static void solicitarRegistroProyecto() {
        String docCliente = JOptionPane.showInputDialog("Ingrese documento o NIT del cliente:");
        Cliente cliente = buscarClientePorDocumento(docCliente);

        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado. Debe crearlo primero.");
            return;
        }

        String codigo = JOptionPane.showInputDialog("Código del proyecto:");
        String fechaSol = JOptionPane.showInputDialog("Fecha solicitud (formato AAAA-MM-DD):");
        String fechaIni = JOptionPane.showInputDialog("Fecha inicio (formato AAAA-MM-DD):");
        String fechaEnt = JOptionPane.showInputDialog("Fecha entrega (formato AAAA-MM-DD):");
        String metodoPago = JOptionPane.showInputDialog("Método de pago (tarjeta de crédito, transferencia, efectivo):");

        Proyecto proyecto = new Proyecto(codigo, fechaSol, fechaIni, fechaEnt, "Pendiente", metodoPago, cliente);

        // Asignación de desarrolladores disponibles
        int agregarDev = JOptionPane.showConfirmDialog(null, "¿Desea asignar un desarrollador al proyecto?", "Asignar", JOptionPane.YES_NO_OPTION);
        while (agregarDev == JOptionPane.YES_OPTION) {
            String codDev = JOptionPane.showInputDialog("Ingrese código del desarrollador:");
            Desarrollador dev = buscarDesarrolladorPorCodigo(codDev);
            if (dev != null && dev.isDisponible()) {
                proyecto.asignarDesarrollador(dev);
                JOptionPane.showMessageDialog(null, "Desarrollador asignado.");
            } else {
                JOptionPane.showMessageDialog(null, "Desarrollador no disponible o inexistente.");
            }
            agregarDev = JOptionPane.showConfirmDialog(null, "¿Desea asignar otro desarrollador?", "Asignar", JOptionPane.YES_NO_OPTION);
        }

        // Asignación de servicios adicionales
        int agregarServ = JOptionPane.showConfirmDialog(null, "¿Desea agregar un servicio adicional?", "Servicios", JOptionPane.YES_NO_OPTION);
        while (agregarServ == JOptionPane.YES_OPTION) {
            String codServ = JOptionPane.showInputDialog("Ingrese código del servicio:");
            ServicioAdicional serv = buscarServicioPorCodigo(codServ);
            if (serv != null && serv.isDisponible()) {
                proyecto.agregarServicio(serv);
                JOptionPane.showMessageDialog(null, "Servicio agregado.");
            } else {
                JOptionPane.showMessageDialog(null, "Servicio no encontrado o no disponible.");
            }
            agregarServ = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro servicio?", "Servicios", JOptionPane.YES_NO_OPTION);
        }


        proyecto.setEstado("Confirmado");
        proyecto.calcularValorTotal();

        for (int i = 0; i < listaProyectos.length; i++) {
            if (listaProyectos[i] == null) {
                listaProyectos[i] = proyecto;
                JOptionPane.showMessageDialog(null, "Proyecto registrado con éxito.\nValor total: $" + proyecto.getValorTotal());
                return;
            }
        }
    }


    private static void solicitarConsultaClientePerfecto() {
        String telefono = JOptionPane.showInputDialog("Ingrese el número de teléfono del cliente a consultar:");
        Cliente cliente = buscarClientePorTelefono(telefono);

        if (cliente != null) {
            try {

                String soloDigitos = telefono.replaceAll("[^0-9]", "");
                long numeroTel = Long.parseLong(soloDigitos);

                boolean esPerfecto = verificarNumeroPerfecto(numeroTel);

                String mensaje = "Cliente encontrado:\n" +
                        "Nombre: " + cliente.getNombre() + "\n" +
                        "Documento: " + cliente.getDocumento() + "\n" +
                        "Teléfono: " + telefono + "\n\n" +
                        "¿El número telefónico es perfecto?: " + (esPerfecto ? "SÍ ES PERFECTO" : "NO ES PERFECTO");

                JOptionPane.showMessageDialog(null, mensaje);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El teléfono del cliente contiene un valor que excede el límite numérico.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con ese número de teléfono.");
        }
    }

    public static boolean verificarNumeroPerfecto(long n) {
        if (n <= 1) return false;
        long suma = 0;
        for (long i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                suma += i;
            }
        }
        return suma == n;
    }


    private static void solicitarCalculoIngresosFecha() {
        String fechaConsulta = JOptionPane.showInputDialog("Ingrese la fecha de solicitud a consultar (AAAA-MM-DD):");
        double ingresosTotales = 0;
        int conteo = 0;

        for (Proyecto proyecto : listaProyectos) {
            if (proyecto != null && proyecto.getFechaSolicitud().equals(fechaConsulta)) {
                ingresosTotales += proyecto.getValorTotal();
                conteo++;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Resultados para la fecha " + fechaConsulta + ":\n" +
                        "Proyectos encontrados: " + conteo + "\n" +
                        "Ingresos totales acumulados: $" + ingresosTotales
        );
    }


    private static Cliente buscarClientePorDocumento(String doc) {
        for (Cliente c : listaClientes) {
            if (c != null && c.getDocumento().equalsIgnoreCase(doc)) return c;
        }
        return null;
    }

    private static Cliente buscarClientePorTelefono(String tel) {
        for (Cliente c : listaClientes) {
            if (c != null && c.getTelefono().equalsIgnoreCase(tel)) return c;
        }
        return null;
    }

    private static Desarrollador buscarDesarrolladorPorCodigo(String cod) {
        for (Desarrollador d : listaDesarrolladores) {
            if (d != null && d.getCodigo().equalsIgnoreCase(cod)) return d;
        }
        return null;
    }

    private static ServicioAdicional buscarServicioPorCodigo(String cod) {
        for (ServicioAdicional s : listaServicios) {
            if (s != null && s.getCodigo().equalsIgnoreCase(cod)) return s;
        }
        return null;
    }

    private static void cargarDatosPrueba() {
        // Datos rápidos para probar de inmediato en el video sin digitar todo desde cero
        listaClientes[0] = new Cliente("Tech Solutions", "900123456", "6", "contacto@tech.co", "Colombia", true);
        listaDesarrolladores[0] = new Desarrollador("DEV-01", "Backend", "Senior", 2, 150000.0, "Disponible", true);
        listaServicios[0] = new ServicioAdicional("SRV-01", "Despliegue Cloud", "AWS Setup", 300000.0, true);
    }
}