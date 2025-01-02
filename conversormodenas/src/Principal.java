import models.ExchangeRateRespuesta;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        Scanner sc = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        int opc = 0;
        double valor = 0;

        System.out.println("\n" +
                "                                                     _                                       _       \n" +
                "                                                    | |                                     | |      \n" +
                "   ___ ___  _ ____   _____ _ __ ___  ___  _ __    __| | ___   _ __ ___   ___  _ __   ___  __| | __ _ \n" +
                "  / __/ _ \\| '_ \\ \\ / / _ \\ '__/ __|/ _ \\| '__|  / _` |/ _ \\ | '_ ` _ \\ / _ \\| '_ \\ / _ \\/ _` |/ _` |\n" +
                " | (_| (_) | | | \\ V /  __/ |  \\__ \\ (_) | |    | (_| |  __/ | | | | | | (_) | | | |  __/ (_| | (_| |\n" +
                "  \\___\\___/|_| |_|\\_/ \\___|_|  |___/\\___/|_|     \\__,_|\\___| |_| |_| |_|\\___/|_| |_|\\___|\\__,_|\\__,_|\n" +
                "                                                                                                     \n" +
                "                                                                                                     ");

        while (opc != 3) {

            System.out.println("+---------------------------------+\n" +
                    "| MENU DE OPCIONES                |\n" +
                    "|                                 |\n" +
                    "| 1) Conversor de monedas         |\n" +
                    "| 2) Lista de codigos disponibles |\n" +
                    "| 3) Salir                        |\n" +
                    "+---------------------------------+");

            System.out.print("Digite opcion: ");
            while (true) {
                try {
                    opc = Integer.parseInt(sc.nextLine());
                    break;
                }catch (NumberFormatException e) {
                    System.out.println("Solo se admiten valores numericos\n");
                    System.out.print("Digite opcion: ");
                }
            }

            switch (opc) {
                case 1:
                    System.out.println("Digite el código base de la moneda(e.g., USD): ");
                    try {
                        String codigo = sc.nextLine().toUpperCase();
                        ExchangeRateRespuesta exchangeRateRespuesta = consulta.buscaValor(codigo);
                        if (!exchangeRateRespuesta.result().equalsIgnoreCase("error")) {

                            System.out.println("Digite la cantidad que desea convertir: ");
                            try {
                                valor = Double.parseDouble(sc.nextLine());
                            } catch (NumberFormatException e) {
                                valor = 0;
                                System.out.println("El valor debe ser numerico, Intente nuevamente");
                                break;
                            }

                            System.out.println("Digite el código de la moneda a la que desea convertir " + codigo + " (e.g., EUR):");
                            String codigoDos = sc.nextLine().toUpperCase();

                            if (exchangeRateRespuesta.conversion_rates().get(codigoDos) != null) {
                                double resultado = valor * exchangeRateRespuesta.conversion_rates().get(codigoDos).doubleValue();
                                System.out.println("El valor " + valor + " [" + codigo + "]" + " corresponde al valor final de: =>>> " +
                                        df.format(resultado) + " [" + codigoDos + "]");
                            } else {
                                System.out.println("Código incorrecto, verifique la lista de códigos disponibles digitando opción 2");
                            }

                        } else {
                            System.out.println("Código incorrecto, verifique la lista de códigos disponibles digitando opción 2");
                        }

                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    } finally {
                        break;
                    }
                case 2:
                    try {
                        ExchangeRateRespuesta exchangeRateRespuesta = consulta.buscaValor("USD");
                        System.out.println(new ConsultaApi().obtenerListaCodigos(exchangeRateRespuesta.conversion_rates()));
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    opc = 3;
                    System.out.println("Salida exitosamente");
                    break;
                default:
                    System.out.println("Opcion incorrecta, Intente nuevamente");
            }
        }
    }

}



