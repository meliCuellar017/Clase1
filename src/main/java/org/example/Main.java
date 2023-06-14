package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Primera practica curso reactividad.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("************** M E N U ****************\n" +
                "Ingrese 1 para encontrar el número mayor y menor de una lista. \n" +
                "Ingrese 2 para aplicar el descuento a una venta. \n" +
                "Ingrese 3 para calcular iva. \n"+
                "¿Qué deseas hacer hoy?");
        int opc = scanner.nextInt();

        if (opc == 1){
            System.out.println("¿De qué tamaño deseas la lista?");
            int tamano = scanner.nextInt();
            List<Integer> listaNumeros = crearLista(tamano);
            System.out.println(Menor_Mayor(listaNumeros));
        }else if (opc == 2){
            System.out.println("Ingrese el total de la venta: ");
            double total = scanner.nextDouble();
            System.out.println("Ingrese el porcentaje de descuento");
            double porcentaje = scanner.nextDouble();
            double totalConDescuento = PrecioTotal(total, porcentaje);
            System.out.println("El total a pagar es de: $"+ totalConDescuento);
        }else{
            double porcentaje;
            System.out.println("Ingrese el total de la venta: ");
            double total = scanner.nextDouble();
            System.out.println("¿Deseas ingresar el porcentaje de iva? S/N");
            String respuesta = scanner.next();
            if(respuesta.equals("S")){
                System.out.println("Ingrese el porcentaje de iva");
                porcentaje = scanner.nextDouble();
            }else{
                porcentaje = 21;
            }
            double totalConIva = calcularIva(total, porcentaje);
            System.out.println("El total de la venta con iva es: $ "+totalConIva);
        }
    }

    /**
     * Haciendo uso de lo aprendido(Expresiones lambda, referencias a métodos y funciones puras) resuelva:
     * */

    /**
     * 1. Con la intención de encontrar el número mayor en una lista y a su vez el número menor, cree un método que le permita
     * estas dos funciones, siguiendo los principios de las funciones puras.
     * */


    public static String Menor_Mayor(List<Integer> lista){
        String respuesta = "El numero mayor de la lista es: "+ Collections.max(lista) +
                " y el numero menor es:" + Collections.min(lista);
        return respuesta;
    }

    /** Metodo para llenar una lista
     */

    public static List crearLista(int tamano){

        List<Integer> numeros = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < tamano; i++) {
            System.out.print("Ingrese el numero " + (i + 1) + ": ");
            int numero = scanner.nextInt();
            numeros.add(numero);
        }
        return numeros;
    }

    /**
     * 2. En una tienda de ropa necesitamos aplicar un descuento a las ventas que se hacen, este descuento
     * es variable por lo que necesitamos que usted cree un método que reciba el total de la venta y el porcentaje a descontar
     * y devuelva el nuevo precio total.
     * */
    public static double PrecioTotal(double subtotal, double descuento){
        double porcentaje, total;
        porcentaje = 1 - (descuento / 100);
        total = subtotal * porcentaje;
        return total;
    }

    /**
     * 3. Necesitamos calcular el iva de una venta, para esto es necesario que usted cree un método
     * Tendremos dos escenarios posibles, en el primero se le pasará únicamente el valor al cual se le debe
     * aplicar el iva, sin especificar el porcentaje, en este caso se debe aplicar un 21% siempre.
     * En el segundo escenario se le pasará tanto el precio de la venta como el porcentaje de iva.
     * Cree una sola función que pueda lograr estos dos propósitos
     * */
    public static double calcularIva(double total, double iva){
        double ivaTotal = (total * (iva/100));
        return ivaTotal;
    }
}

