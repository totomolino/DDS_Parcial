package Business.Services.Api;

import java.io.IOException;
import java.util.Scanner;

public class mainTrucho {



    public static void main(String[] args) throws IOException {

        apiGames api = apiGames.getInstacia();

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Ingrese el titulo que quiere: ");
            String tituloIngresado = sc.nextLine();

            float precio = api.damePrecio(tituloIngresado);

            if(precio < 0){
                System.out.println("El juego " + tituloIngresado + " no esta en la base de datos");
            }else System.out.println("El precio de " + tituloIngresado + " es $" + precio);
        }
    }



}
