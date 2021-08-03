package Business.Views;

import Business.Cliente;
import Business.Usuario;
import Notificaciones.EMAIL;
import Notificaciones.SMS;
import Notificaciones.WHATSAPP;
import Notificaciones.notificarStrategy;
import Sistema.Sistema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class menu {
    Usuario usuario;
    Cliente clienteIniciado = null;
    Sistema miSistema = Sistema.getInstance();


    public void iniciarMenu() {
        Scanner sn = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        String respuestaCompleja;   // Guardaremos la respuesta compleja del usuario


        while (!salir) {
            if(clienteIniciado != null){
                menuConSesion();
                salir=true;
                break;
            }

            System.out.println("1. crear usuario");
            System.out.println("2. iniciar sesion");
            System.out.println("3. mostrar usuarios");
            System.out.println("99. Salir");


            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        this.crearUsuario();
                        break;
                    case 2:
                        clienteIniciado = this.iniciarSesion();
                        break;
                    case 3:
                        miSistema.mostrarUsuarios();
                        break;
                    case 99:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        System.out.println("Finalizado con exito! Nos vemos broustoun!");


    }


    public void menuConSesion(){
        Scanner sn = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        String respuestaCompleja;   // Guardaremos la respuesta compleja del usuario


        while (!salir) {

            //System.out.println("1. alquilar juegos");
            System.out.println("1. alquilar juegos");
            System.out.println("2. cerrar sesion");
            System.out.println("3. mostrar usuarios");
            System.out.println("99. Salir");


            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {

                    case 1:

                        break;
                    case 2:
                        clienteIniciado = null;
                        System.out.println("Se ha cerrado la sesion correctamente");
                        iniciarMenu();
                        break;
                    case 3:
                        Sistema.mostrarUsuarios();
                        break;
                    case 99:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
       //System.out.println("Finalizado con exito! Nos vemos broustoun!");

    }



    public void crearUsuario(){
        Scanner str = new Scanner(System.in);
        System.out.println("Has seleccionado Crear Usuario");
        System.out.println("Ingrese Usuario");
        String usuarioProvisorio = str.nextLine();
        while (miSistema.usuarioNoValido(usuarioProvisorio)) {
            System.out.println("Nombre de usuario no valido, vuelva a intentarlo");
            usuarioProvisorio = str.nextLine();
        }
        System.out.println("Ingrese email");
        String mailUsuario = str.nextLine();
        while (miSistema.emailNoValido(mailUsuario)) {
            System.out.println("Email no valido, vuelva a intentarlo");
            mailUsuario = str.nextLine();
        }
        System.out.println("Ingrese Contrasena");
        String contrasenaProvisoria = str.nextLine();
        while (!(miSistema.validarContrasenia(contrasenaProvisoria, usuarioProvisorio))) {
            System.out.println("Contrasena no valida, vuelva a intentarlo");
            contrasenaProvisoria = str.nextLine();
        }
        Usuario unUsuario = miSistema.crearUsuario(usuarioProvisorio, contrasenaProvisoria, mailUsuario);
        this.pedirDatosExtra(unUsuario);
        System.out.println("Usuario creado exitosamente!!");
    }


    public Cliente iniciarSesion(){//todo podria devolver el usuario para saber cual esta iniciado ahora mismo o nose al cliente
        boolean success = false;
        Cliente unCliente = null;
        while(!success){
            Scanner str = new Scanner(System.in);
            System.out.println("Has seleccionado iniciar sesion");
            System.out.println("Ingrese Usuario o email");
            String usuarioOEmail = str.nextLine();
            System.out.println("Ingrese Contrasenia");
            String contrasenia = str.nextLine();
            if(miSistema.iniciarSesion(usuarioOEmail, contrasenia) == true){
                success = true;

                //Busco al cliente

                unCliente = miSistema.buscarCliente(usuarioOEmail);

                System.out.println("Has iniciado sesion correctamente!!");


            }
            else System.out.println("Un campo ingresado es incorrecto, intente devuelta");
        }
        return unCliente;
    }

    public void pedirDatosExtra(Usuario usuario){
        Scanner str = new Scanner(System.in);
        System.out.println("Ingrese su nombre");
        String nombre = str.nextLine();
        System.out.println("Ingrese su apellido");
        String apellido = str.nextLine();
        System.out.println("Ingrese su telefono");
        String telefono = str.nextLine();
        List<notificarStrategy> notificarStrategies = this.obtenerMediosDeNotificacion();
        miSistema.crearCliente(nombre,apellido,usuario,telefono,notificarStrategies);
    }

    private List<notificarStrategy> obtenerMediosDeNotificacion() {
        boolean quieroOtro = true;
        int opcion;
        Scanner sn = new Scanner(System.in);
        Scanner snn = new Scanner(System.in);
        List<notificarStrategy> lista = new ArrayList<>();

        while(quieroOtro) {
            System.out.println("MEDIOS DE NOTIFICACION");
            System.out.println("1. WHATSAPP");
            System.out.println("2. EMAIL");
            System.out.println("3. SMS");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {

                    case 1:
                        WHATSAPP notificar = new WHATSAPP();
                        if(this.puedoAgregar(lista, notificar)) {
                            lista.add(notificar);
                        }
                        break;
                    case 2:
                        EMAIL notificar2 = new EMAIL();
                        if(this.puedoAgregar(lista, notificar2)) {
                            lista.add(notificar2);
                        }
                        break;
                    case 3:
                        SMS notificar3 = new SMS();
                        if(this.puedoAgregar(lista, notificar3)) {
                            lista.add(notificar3);
                        }
                        break;
                    case 4:
                        quieroOtro = false;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
            System.out.println("Presione 1 para agregar otro medio de notificacion");
            String respuesta = snn.nextLine();
            if(!(respuesta.equals("1"))){
                quieroOtro = false;
            }
        }
        return lista;
    }

    private boolean puedoAgregar(List<notificarStrategy> lista, notificarStrategy notificar) {
        return !(lista.contains(notificar));
    }




}
