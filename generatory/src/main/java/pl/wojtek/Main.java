package pl.wojtek;

import pl.wojtek.geffe.GeffeGenerator;
import pl.wojtek.geffe.GeffeUtil;
import pl.wojtek.geffe.LFSR;
import pl.wojtek.geffe.Polynomial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {


//        GeffeUtil.randomGeneratorRejestry("Rejestr10",10); //rejestr 10
//        GeffeUtil.randomGeneratorRejestry("Rejestr50",50); //rejestr 50
//        GeffeUtil.randomGeneratorRejestry("Rejestr100",100); //rejestr 100
//
//        GeffeUtil.randomGeneratorRejestry("RadnomSize10",10); //RadnomSize 10
//        GeffeUtil.randomGeneratorRejestry("RadnomSize50",50); //RadnomSize 50
//        GeffeUtil.randomGeneratorRejestry("RadnomSize100",100); //RadnomSize 100
//
//        GeffeUtil.randomGeneratorRejestry("RandomStart10",10); //RandomStart 100
//        GeffeUtil.randomGeneratorRejestry("RandomStart50",50); //RandomStart 50
//        GeffeUtil.randomGeneratorRejestry("RandomStart100",100); //RandomStart 100


        GeffeUtil.randomLongRuns("LongRuns", 100000); //randomLongRuns test
//


//        ShrinkingGenerator generator = new ShrinkingGenerator();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(generator.nextInt());
//        }
//        StopAndGoRandom rng = new StopAndGoRandom();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(rng.nextInt());
//        }
    }

}
