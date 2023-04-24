/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculo25;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alfredo
 */
public class Calculo25 {

    /**
     * @param args the command line arguments Éste es un programa que emula el
     * comportamiento de uno de los componentes del videojuego Brain Training de
     * Switch, llamado Cálculo 25.      *
     */
    public static void main(String[] args) {

        String signos = "+-x/";//Esta cadena va a permitirnos escoger entre la suma, la resta, la multiplicación o división
        int chiquipuntos = 0;

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int valor1, valor2;
        char signo;
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < 25; i++) {
            signo = signos.charAt(rnd.nextInt(4));

            if (signo == '+') {
                valor1 = rnd.nextInt(10);
                valor2 = rnd.nextInt(10);
                double valorFinal = valor1 + valor2;
                System.out.print(valor1 + " + " + valor2 + " = ");
                int valorUsuario = sc.nextInt();
                if (valorUsuario == valorFinal) {
                    chiquipuntos++;
                } else {
                    System.out.println("Error");
                }
            }
            if (signo == 'x') {
                valor1 = rnd.nextInt(9);
                valor2 = rnd.nextInt(9);
                double valorFinal = valor1 * valor2;
                System.out.print(valor1 + " x " + valor2 + " = ");
                int valorUsuario = sc.nextInt();
                if (valorUsuario == valorFinal) {
                    chiquipuntos++;
                } else {
                    System.out.println(" Error");
                }

            }
            if (signo == '-') {
                valor1 = rnd.nextInt(10) + 1;
                do {
                    valor2 = rnd.nextInt(10);
                } while (valor2 > valor1);
                double valorFinal = valor1 - valor2;
                System.out.print(valor1 + " - " + valor2 + " = ");
                int valorUsuario = sc.nextInt();
                if (valorUsuario == valorFinal) {
                    chiquipuntos++;
                } else {
                    System.out.println("Error");
                }

            }
            if (signo == '/') {
                valor1 = rnd.nextInt(10) + 1;
                do {
                    valor2 = rnd.nextInt(10);
                } while (valor2 == 0 || valor1 % valor2 != 0);
                int valorFinal = valor1 / valor2;
                System.out.println(valorFinal);
                System.out.print(valor1 + " / " + valor2 + " = ");
                int valorUsuario = sc.nextInt();
                if (valorUsuario == valorFinal) {
                    chiquipuntos++;
                } else {
                    System.out.println("Error");
                }

            }
        }
        long fin = System.currentTimeMillis();

        double tiempo = (double) ((fin - inicio) / 1000);

        System.out.println("Has realizado el ejercicio en " + tiempo + " segundos");
        int nFallos = 25 - chiquipuntos;
        System.out.println("Penalización: " + nFallos + " x 5s  = " + nFallos * 5);
        double tiempoFinal = tiempo + nFallos * 5;
        System.out.println("Tu tiempo final es de " + tiempoFinal + " segundos");
    }

}
