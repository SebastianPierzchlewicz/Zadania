package pl.wojtek;

import pl.wojtek.geffe.GeffeGenerator;
import pl.wojtek.geffe.LFSR;
import pl.wojtek.geffe.Polynomial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczbe w bitach");
        String inputBit = in.nextLine();
        if (inputBit.chars().anyMatch(value -> value!= 49 && value != 48)) {
            System.out.println("Podano złe dane wejsciowe!");
            return;
        }
        System.out.println("-=-=-=-=-=-");
        System.out.println("Dane na wejsciu " + inputBit);
        Polynomial polynomial1 = new Polynomial(30, 6, 4, 1);
        Polynomial polynomial2 = new Polynomial(31, 3);
        Polynomial polynomial3 = new Polynomial(32, 7, 5, 3, 2, 1);

        LFSR lfsr1 = new LFSR(polynomial1);
        LFSR lfsr2 = new LFSR(polynomial2);
        LFSR lfsr3 = new LFSR(polynomial3);

        lfsr1.setInitialState(651497879);
        lfsr2.setInitialState(1259760270);
        lfsr3.setInitialState(2229332000L);

        GeffeGenerator geffe = new GeffeGenerator(lfsr1, lfsr2, lfsr3);

        geffe.step(inputBit.length());

        System.out.println("LFSR1: " + lfsr1.getOutputSequence());
        System.out.println("LFSR2: " + lfsr2.getOutputSequence());
        System.out.println("LFSR3: " + lfsr3.getOutputSequence());
        System.out.println("Dane na wyjsciu: " + geffe.getGamma());
        System.out.println("-=-=-=-=-=-");

    }

}
