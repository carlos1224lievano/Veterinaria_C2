package com.upchiapas.veterinariac2;

import com.upchiapas.veterinariac2.models.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    static Veterinaria tienda = new Veterinaria();
    static ArrayList<Cliente> listaClientes = new ArrayList();
    static Orden orden=new Orden();
    static Expediente historialMascota;

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu(){
        byte opcion = 0;
        do {
            System.out.println("**     VETERINARIA LA UP     **");
            System.out.println("* [1]- Servicio Veterinario   *");
            System.out.println("* [2]- Comprar Productos      *");
            System.out.println("* [3]- Buscar Expedinte       *");
            System.out.println("**       [4]- SALIR          **");
            System.out.print("Elija una opcion: ");
            opcion=entrada.nextByte();

            switch (opcion){
                case 1:
                    mostrarServicios();
                    orden.calcularTotalServicios();
                    System.out.println("\n----------------------------------------\n");
                    break;
                case 2:
                    mostrarProductos();
                    System.out.println("\n----------------------------------------\n");
                    break;
                case 3:
                    buscarExpedienteMascota();//Busqueda de la mascota con los servicios que se le han proporcionado
                    System.out.println("\n-----------------------------------------\n");
                    break;
                case 4:
                    System.out.println("Ah salido del programa.");
                    break;
                default:
                    System.out.println("Opcion invalida. Intentelo de nuevo...");
            }
            //orden=new Orden(listaServicios,listaProductos);
        }while(opcion!=4);
    }
    public static void preguntarContinuar(){

    }

    public static void mostrarServicios() {
        ArrayList<Servicio> listaServicios = new ArrayList();
        Servicio objServicio;
        String tipoServicio = "";//Servicio servicio;
        int precio = 0;
        byte opc;//tipoMascota
        //Segun el tipo de mascota sera el Objeto de la clase hija que se creara
        System.out.println("- - - ¿Que servicio desea? - - -");
        System.out.println("  [1]- Tratamiento Clinico ---- $250.00");
        System.out.println("  [2]- Vacunación ------------- $100.00");
        System.out.println("  [3]- Analisis de Sangre ----- $200.00");
        System.out.println("  [4]- Evaluación Quirúrgica -- $150.00");
        System.out.print("Elija una opcion: ");
        opc = entrada.nextByte();
        switch (opc) {
            case 1:
                tipoServicio = "Tratamiento Clinico";
                precio = 250;
                break;
            case 2:
                tipoServicio = "Vacunación";
                precio = 100;
                break;
            case 3:
                tipoServicio = "Analisis de Sangre";
                precio = 200;
                break;
            case 4:
                tipoServicio = "Evaluación Quirúrgica";
                precio = 150;
                break;
            default:
                System.out.println("Servicio desconocido.");
        }
        objServicio = new Servicio(tipoServicio, precio);
        listaServicios.add(objServicio);
        orden.setListaServicios(listaServicios);//Bien esto no se si se podria hacer en el mostrarMenu
        // --- ERROR ACA
        registrarCliente(listaServicios);
    }
    public static void registrarCliente(ArrayList<Servicio> listaServicios ){
        String nombre;
        entrada.nextLine();
        System.out.println("Nombre del Cliente: ");
        nombre=entrada.nextLine();

        registrarMascota(nombre, listaServicios);
    }
    public static void registrarMascota(String nomCliente,ArrayList<Servicio> listaServicios){

        Cliente objCliente;
        ArrayList<Mascota> listaMascotas = new ArrayList();
        String nomMascota,id;
        byte edad,tipoMascota;
        entrada.nextLine();//-----
        System.out.println("---- Registro de mascota ----");
        System.out.println("Nombre la mascota: ");
        nomMascota=entrada.nextLine();
        System.out.println("ID de la mascota: ");
        id=entrada.nextLine();
        System.out.println("Edad de la mascota: ");
        edad=entrada.nextByte();


        System.out.println("* Tipo de mascota *");
        System.out.println("  [1]- Perro");
        System.out.println("  [2]- Gato");
        System.out.println("  [3]- Hamster");
        System.out.print("---: ");
        tipoMascota=entrada.nextByte();
        switch (tipoMascota){
            case 1:
                Perro objPerro=new Perro(nomMascota,id,edad,listaServicios);
                listaMascotas.add(objPerro);
                break;
            case 2:
                Gato objGato=new Gato(nomMascota,id,edad,listaServicios);
                listaMascotas.add(objGato);
                break;
            case 3:
                Hamster objHamster=new Hamster(nomMascota,id,edad,listaServicios);
                listaMascotas.add(objHamster);
                break;
            default:
                System.out.println("Tipo de Mascota desconocido.");
        }
        historialMascota=new Expediente(listaMascotas);
        objCliente=new Cliente(nomCliente,listaMascotas);
        orden.setCliente(objCliente);
        listaClientes.add(objCliente);
        tienda.setListaClientes(listaClientes);
    }

    public static void mostrarProductos(){
        ArrayList<Producto> listaProductos = new ArrayList();
        byte opcP;
        do {
            System.out.println("\n- - - Menu de Productos - - -");
            System.out.println("     [1]- Alimentos");
            System.out.println("     [2]- Medicamentos");
            System.out.println("     [3]- Accesorios");
            System.out.println("  <<-- [4]- REGRESAR");
            System.out.print("Elija una opcion: ");
            opcP=entrada.nextByte();
            switch (opcP){
                case 1:
                    mostrarAlimetos(listaProductos);//En teoria crear Objeto del procuto hijo deseado
                    break;
                case 2:
                    mostrarMedicamentos(listaProductos);
                    break;
                case 3:
                    mostrarAccesorios(listaProductos);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Producto inexistente.");
            }
        }while (opcP!=4);
        orden.setListaProductos(listaProductos); //PODRIA MANDARSE TAMBIEN EL setCliente
        orden.calcularTotalProductos();    //Aca llamar calcular
    }
    public static void mostrarAlimetos(ArrayList<Producto> listaProductos){ //Podria ser que en cada menucito de cada tipoProducto sea donde se cree el objeto correspondiente
        String nombre="";
        int precio=0,cantidad;
        byte tipoAlimento;
        System.out.println("\n  * Alimentos para mascotas *");
        System.out.println(" [1]- Pedigree ---------- $20.00");
        System.out.println(" [2]- Whiskas ----------- $15.00");
        System.out.println(" [3]- Mix de semillas --- $90.00");
        System.out.print(" --: ");
        tipoAlimento=entrada.nextByte();
        System.out.print("Cantidad: ");
        cantidad=entrada.nextInt();

        switch (tipoAlimento){
            case 1:
                nombre="Pedigree";
                precio=20;
                break;
            case 2:
                nombre="Whiskas";
                precio=15;
                break;
            case 3:
                nombre="Mix de semillas";
                precio=90;
                break;
            default:
                System.out.println("Alimento no disponible.");
        }
        Alimento objAlimento = new Alimento(nombre,precio,cantidad);
        listaProductos.add(objAlimento);
    }
    public static void mostrarMedicamentos(ArrayList<Producto> listaProductos){
        String nombre="";
        int precio=0,cantidad;
        byte tipoMedicamento;
        System.out.println("\n  * Medicamentos para mascotas *");
        System.out.println(" [1]- Antiemetico -------- $35.00");
        System.out.println(" [2]- Antiparacitario ---- $40.00");
        System.out.println(" [3]- Gotas Antiacaros --- $150.00");
        System.out.print(" ---: ");
        tipoMedicamento=entrada.nextByte();
        System.out.print("Cantidad: ");
        cantidad=entrada.nextInt();

        switch (tipoMedicamento){
            case 1:
                nombre="Antiemetico";
                precio=35;
                break;
            case 2:
                nombre="Antiparacitario";
                precio=40;
                break;
            case 3:
                nombre="Gotas Antiacaros";
                precio=150;
                break;
            default:
                System.out.println("Medicamento no disponible.");
        }
        Medicamento objMedicamento = new Medicamento(nombre,precio,cantidad);
        listaProductos.add(objMedicamento);
    }
    public static void mostrarAccesorios(ArrayList<Producto> listaProductos){
        String nombre="";
        int precio=0,cantidad;
        byte tipoAccesorio;
        System.out.println("\n  * Accesorios para mascotas *");
        System.out.println(" [1]- Correa para perro -------- $50.00");
        System.out.println(" [2]- Dispensador de Alimento -- $300.00");
        System.out.println(" [3]- Jaula para Hamster ------- $500.00");
        System.out.print(" ---: ");
        tipoAccesorio=entrada.nextByte();
        System.out.print("Cantidad: ");
        cantidad=entrada.nextInt();

        switch (tipoAccesorio){
            case 1:
                nombre="Correa para perro";
                precio=50;
                break;
            case 2:
                nombre="Dispensador de Alimento";
                precio=300;
                break;
            case 3:
                nombre="Jaula para Hamster";
                precio=500;
                break;
            default:
                System.out.println("Accesorio no disponible.");
        }
        Accesorio objAccesorio = new Accesorio(nombre,precio,cantidad);
        listaProductos.add(objAccesorio);
    }

    public static void buscarExpedienteMascota() {
        String id;
        entrada.nextLine();//Limpiar intro
        System.out.println("- - - BUSQUEDA DE EXPEDIENTES - - -");
        System.out.print("ID de la Mascota a buscar: ");
        id = entrada.nextLine();

        historialMascota.buscarExpediente(id);
    }

/*   FALTARIA: --- calcular el subtotal y total (Intentarlo hacer en la clase orden [No olvidar usar el getcantidad
    pa multiplicar por precio]), Y buscar el expedinte segun el id de la mascota ingresado (o podria ser con el nombre)

        static void registroManual(){
        Iterator <Alumno> iterador = listaAlumnos.iterator();
        Alumno alum;
        String matricula,opc;

        entrada.nextLine();//Limpiar intro
        System.out.println("- - - PROCESO DE CARGA MANUAL - - -");
        System.out.print("Matricula a buscar: ");
        matricula=entrada.nextLine();

        while(iterador.hasNext()){
            alum= iterador.next();
            if(alum.getMatricula().equals(matricula)){
                System.out.println("\n" + alum.getMatricula() + alum.getNombre());
                mostrarMaterias(alum); //Metodo imprime lo que contien la lista de materias
            }
        }

GUIA PARA OBJETOS EN LISTAS Y ASI ;))
        public static void registrarMaterias(){
        Materias objMateria;
        ArrayList<Materias> listaMaterias = new ArrayList();
        String matricula,nombre,nomMateria;
        char grupo;
        int cantidad = 0;

        System.out.println("- - - - - INICIO DE SESION EXITOSO - - - - -");
        System.out.println("\t*** REGISTRO DE MATERIAS ***");
        System.out.print("Matricula: ");
        matricula = entrada.nextLine();
        System.out.print("Nombre: ");
        nombre = entrada.nextLine();
        entrada.nextLine(); // Limpia

        System.out.print("Cantidad de Materias: ");
        cantidad = entrada.nextInt();
        if(validarCantidad(cantidad)){
            for (int i=0; i<cantidad; i++){
                entrada.nextLine();//Limpiar intro
                System.out.print("Materia: ");
                nomMateria = entrada.nextLine();
                System.out.print("Grupo: ");
                grupo = entrada.next().charAt(0);

                objMateria = new Materias(nomMateria,grupo); //Creacion del objeto Materia
                listaMaterias.add(objMateria); //Se ingresa el objeto al ArrayList de Materias
            }
            objAlumno = new Alumno(matricula,nombre,listaMaterias);//Creacion del objeto Alumno (que tiene una lista de mateias)
        }
        else System.out.println("\nLa carga ideal es de 7 materias");
        System.out.println("- - - Carga de Materias exitosa - - -\n");
    }
 */
}
