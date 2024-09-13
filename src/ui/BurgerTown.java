package ui;

import java.util.Scanner;

public class BurgerTown {

    public static Scanner reader;
    public static double[] precios;
    public static int[] unidades;

    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: l Scanner reader queda inicializado
    */
    public static void inicializarGlobales() {

        reader = new Scanner(System.in);

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("Bienvenido a BurgerTown!");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada plato vendido en el dia");
            System.out.println("2. Calcular la cantidad total de platos vendidos en el dia");
            System.out.println("3. Calcular el precio promedio de los platos vendidos en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de platos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de platos vendidos en el dia fue de: "+calcularTotalPlatosVendidos());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de los platos vendidos en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nDigite el limite minimo de ventas a analizar");
                    double limite = reader.nextDouble();
                    System.out.println("\nDe las "+precios.length+" referencias vendidas en el dia, "+consultarPlatosSobreLimite(limite)+" superaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    System.out.println("\nOpcion invalida, intenta nuevamente.");
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de platos diferentes 
     * vendidos en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */
    public static void establecerCantidadVendida() {

        System.out.println("\nDigite el numero de platos diferentes vendidos en el dia ");
        int platos = reader.nextInt();

        precios = new double[platos];
        unidades = new int[platos];

    }

    /**
     * Descripcion: Este metodo  es el encargado de solicitar al usuario los precios y unidades vendidas en el dia.
     * pre: El Scanner reader debe estar inicializado.
     * pre: Los arreglos precios y unidades deben estar declarados e inicializados.
     * pos: Los datos que el usuario ingresa en los arreglos precios y unidades se guardan.
    */
    public static void solicitarDatos(){ 

        for (int i = 0; i < precios.length; i++) {

            System.out.println("Ingrese el precio del plato vendido: ");
            double precioACapturar = reader.nextDouble();
            precios[i] = precioACapturar;

            System.out.println("Ingrese la cantidad del plato vendido: ");
            int cantidadACapturar = reader.nextInt();
            unidades[i] = cantidadACapturar;
        }
    }

    /**
     * Descripcion: Este metodo  calcula el total de platos que se vendieron en el día
     * pre: El arreglo de unidades debe estar inicializado y contener valores.
     * @return devuelve la cantidad total de platos vendidos en el día
    */

    public static int calcularTotalPlatosVendidos(){

        int totalPlatosVendidos = 0;

        for (int j = 0; j < precios.length; j++){
            totalPlatosVendidos += unidades[j];
        }
        return totalPlatosVendidos;

    }

    /**
     * Descripcion: Este metodo  calcula el precio promedio del total de platos vendidos en el día.
     * pre: El arreglo de precios y unidades deben estar inicializados y tener valores guardados.
     * @return devuelve el precio promedio del total de ventas.
    */

    public static double calcularPrecioPromedio(){

        double preciosSumados = 0;
        int platosTotales = 0;

        for (int k = 0; k < precios.length; k++){
            preciosSumados += precios[k];
            platosTotales += unidades[k];
        } 

        double precioPromedio =  preciosSumados/platosTotales;
        return precioPromedio;

    }

    /**
     * Descripcion: Este metodo  calcula el total de platos que se vendieron en el día
     * pre: El arreglo de precios debe estar inicializado y contener valores.
     * @return devuelve el total de precios recaudados durante el dia
    */

    public static double calcularVentasTotales(){

        int precioTotalRecaudado = 0;

        for (int h = 0; h < precios.length; h++){
            precioTotalRecaudado += precios[h];
        }
        return precioTotalRecaudado;


    }

    /**
     * Descripcion: Este metodo se encarga de buscar los platos que superaron el limite puesto por el usuario.
     * para ello se calcula el precio total de todas las unidades vendidas y se compara con el limite ingresado por el usuario.
     * pre: El arreglo de precios y unidades debe estar inicializado y contener valores.
     * @return devuelve la cantidad de platos que superan el limite.
    */

    public static int consultarPlatosSobreLimite(double limite){

        int coincidencia = 0;

        for (int l = 0; l < precios.length; l ++){
            double totalVentas = precios[l] * unidades[l];
            if(totalVentas >= limite){
                coincidencia ++;
            }
        }
        return coincidencia;
    }
}