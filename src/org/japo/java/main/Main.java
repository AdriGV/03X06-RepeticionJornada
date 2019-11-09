/* 
 * Copyright 2019 AdrianGV  adrian.gimeno.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author AdrianGV adrian.gimeno.alum@iescamp.es
 */
public final class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {
        //Constantes
        final int MAX_HORA = 23;
        final int MIN_HORA = 0;
        final int DIAS = 5;
        final int MINIMO_HORAS = 37;
        final int MINIMO_MINUTOS = 30;

        //Variables
        int hEntrada;
        int mEntrada;
        int hSalida;
        int mSalida;
        String day = null;
        int contador = 0;
        int minutosTrabajados;
        boolean control = true;
        int minutosMinimos;

        //Cabecera
        System.out.println("CONTROL HORARIO DEL BECARIO");
        System.out.println("---");

        //Bucles
        for (int i = 0; i < DIAS; i++) {

            //DIA
            switch (i + 1) {

                case 1:
                    day = "Lunes";
                    break;
                case 2:
                    day = "Martes";
                    break;
                case 3:
                    day = "Miércoles";
                    break;
                case 4:
                    day = "Jueves";
                    break;
                case 5:
                    day = "Viernes";
            }

            do {
                try {
                    
                    //INSERCION DE DATOS
                    System.out.printf("Estamos a %S Inserte hora de entrada ...: ",
                            day);
                    hEntrada = SCN.nextInt();
                    //SCN.nextLine();
                    System.out.printf("Estamos a %S Inserte minuto de entrada .: ",
                            day);
                    mEntrada = SCN.nextInt();
                    System.out.println("---");
                    //SCN.nextLine();
                    System.out.printf("Estamos a %S Inserte hora de salida ...: ",
                            day);
                    hSalida = SCN.nextInt();
                    //SCN.nextLine();
                    System.out.printf("Estamos a %S Inserte minuto de salida .: ",
                            day);
                    mSalida = SCN.nextInt();
                    //SCN.nextLine(); System.out.println("---");
                    System.out.println("---");

                    //CALCULO DE MINUTOS TRABAJADOS POR DIA
                    minutosTrabajados = hSalida * 60 + mSalida - hEntrada * 60
                            + mEntrada;

                    //CONTADOR DE TODOS LOS MINUTOS TRABAJADOS
                    contador += minutosTrabajados;

                    control = false;

                } catch (Exception e) {
                    System.out.println("Errorcio");
                    
                }finally{
                    SCN.nextLine();
                }

            } while (control == true);
        }

        minutosMinimos = MINIMO_HORAS * 60 + MINIMO_MINUTOS;

        System.out.println("---");
        System.out.println(contador >= minutosMinimos ? "Has cumplido maquina"
                : "Trabaja mas crack");
    }
}
