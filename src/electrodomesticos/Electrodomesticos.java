package electrodomesticos;

import java.util.Scanner;

public class Electrodomesticos {

    public static void main(String[] args) {
        tienda arreglo[] = new tienda[15];
        Scanner teclado = new Scanner(System.in);
        Scanner letras = new Scanner(System.in);
        int op = 0;

        while (op != 5) {
            System.out.println("1. guardar");
            System.out.println("2. ver electrodomestico ");
            System.out.println("3. buscar electrodomestico");
            System.out.println("4. modificar electrodomestico");
            System.out.println("5. salir");
            System.out.println("ingrese el numero de opcion");
            op = teclado.nextInt();
            System.out.println("--------------------");
            if (op == 1) {

                System.out.println("ingrese codigo");
                int codigo = teclado.nextInt();
                System.out.println("ingrese el nombre");
                String nombre = letras.nextLine();
                System.out.println("ingrese la marca");
                String marca = letras.nextLine();
                System.out.println(guardar(codigo, nombre, marca, arreglo));

            } else if (op == 2) {
                System.out.println(printTodo(arreglo));
            } else if (op == 3) {
                System.out.println("------------------");
                System.out.println("ingrese codigo");
                int codigo = teclado.nextInt();
                System.out.println(buscarelectrodomestico(codigo, arreglo));
            } else if (op == 4) {
                System.out.println("ingrese codigo");
                int codigo = teclado.nextInt();
                if (buscarelectrodomesticoBoleano(codigo, arreglo)) {
                    System.out.println("ingrese el nuevo nombre");
                    String nombre = letras.nextLine();
                    System.out.println("ingrese la nueva marca");
                    String marca = letras.nextLine();
                    System.out.println(modificarDatos(codigo, nombre, marca, arreglo));
                } else {

                }
            }
        }
    }

    public static String guardar(int codigo, String nombre, String marca, tienda arreglo[]) {
        boolean lleno = true;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = new tienda(codigo, nombre, marca);
                lleno = false;
                break;
            } else if (arreglo[i].getCodigo() == codigo) {
                return "ya existe el codigo";

            }
        }
        if (!lleno) {
            return "--se guardo con exito--";
        } else {
            return "ya no hay espacio";
        }
    }

    public static String printTodo(tienda arreglo[]) {
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                cadena = cadena + arreglo[i].getCodigo() + "|" + arreglo[i].getNombre() + "|" + arreglo[i].getMarca() + "\n";
            }

        }
        return cadena;
    }

    public static String buscarelectrodomestico(int codigo, tienda arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getCodigo() == codigo) {
                return " los datos \n nombre:" + arreglo[i].getNombre() + " marca: " + arreglo[i].getMarca();
            }
        }
        return "no existe el codigo ingresado ";
    }

    public static boolean buscarelectrodomesticoBoleano(int codigo, tienda arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public static String modificarDatos(int codigo, String nomnre, String marca, tienda arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getCodigo() == codigo) {
                arreglo[i].setNombre(nomnre);
                arreglo[i].setMarca(marca);
                return "se actualizo con exito";
            }
        }
        return "";
    }
}
