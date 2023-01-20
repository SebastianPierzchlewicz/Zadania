package pl.wojtek.geffe;

import pl.wojtek.FileUtil;
import pl.wojtek.RandomUtil;
import pl.wojtek.ShrinkingGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeffeUtil {

    public static void randomGeneratorRejestry(final String name, int size) {
        final List<String> list = new ArrayList<>();
        final ShrinkingGenerator generator = new ShrinkingGenerator();
        final int random = RandomUtil.getRandInt(9,99);
        list.add("Wylosowano randomowa licze : " +random);
        final String inputBit = Long.toBinaryString(random);
        for (int i = 0; i< size; i++) {
            list.add("Dane na wejsciu " + inputBit);
            Polynomial polynomial1 = new Polynomial(30, 6, 4, 1,22,92,31,31);
            Polynomial polynomial2 = new Polynomial(31, 3,3,6,2,4,2,3,3,3);
            Polynomial polynomial3 = new Polynomial(32, 7, 5, 3, 2, 1,2,2,11);

            LFSR lfsr1 = new LFSR(polynomial1);
            LFSR lfsr2 = new LFSR(polynomial2);
            LFSR lfsr3 = new LFSR(polynomial3);

            lfsr1.setInitialState(generator.nextInt());
            lfsr2.setInitialState(generator.nextInt());
            lfsr3.setInitialState(generator.nextInt());

            GeffeGenerator geffe = new GeffeGenerator(lfsr1, lfsr2, lfsr3);

            geffe.step(inputBit.length());

            list.add("LFSR1: " + lfsr1.getOutputSequence());
            list.add("LFSR2: " + lfsr2.getOutputSequence());
            list.add("LFSR3: " + lfsr3.getOutputSequence());
            final String output = geffe.getGamma();
            list.add("Dane na wyjsciu: " + output);
            if (output.equalsIgnoreCase(inputBit)) {
                System.out.println("Input == output");
                list.add("Input == output");
            }
            list.add("");
        }
        FileUtil.save(name,list);
    }

    public static void randomGeneratorRandomSize(final String name, int size) {
        final List<String> list = new ArrayList<>();
        final ShrinkingGenerator generator = new ShrinkingGenerator();
        final int random = RandomUtil.getRandInt(1,99999999);
        list.add("Wylosowano randomowa licze : " +random);
        final String inputBit = Long.toBinaryString(random);
        final int l1 = generator.nextInt();
        final int l2 = generator.nextInt();
        final int l3 = generator.nextInt();
        for (int i = 0; i< size; i++) {
            list.add("Dane na wejsciu " + inputBit);
            Polynomial polynomial1 = new Polynomial(30, 6, 4, 1,22,92,31,31);
            Polynomial polynomial2 = new Polynomial(31, 3,3,6,2,4,2,3,3,3);
            Polynomial polynomial3 = new Polynomial(32, 7, 5, 3, 2, 1,2,2,11);

            LFSR lfsr1 = new LFSR(polynomial1);
            LFSR lfsr2 = new LFSR(polynomial2);
            LFSR lfsr3 = new LFSR(polynomial3);

            lfsr1.setInitialState(l1);
            lfsr2.setInitialState(l2);
            lfsr3.setInitialState(l3);

            GeffeGenerator geffe = new GeffeGenerator(lfsr1, lfsr2, lfsr3);

            geffe.step(inputBit.length());

            list.add("LFSR1: " + lfsr1.getOutputSequence());
            list.add("LFSR2: " + lfsr2.getOutputSequence());
            list.add("LFSR3: " + lfsr3.getOutputSequence());
            final String output = geffe.getGamma();
            list.add("Dane na wyjsciu: " + output);
            if (output.equalsIgnoreCase(inputBit)) {
                System.out.println("Input == output");
                list.add("Input == output");
            }
            list.add("");
        }
        FileUtil.save(name,list);
    }

    public static void randomGeneratorRandomStart(final String name, int size) {
        final List<String> list = new ArrayList<>();
        final ShrinkingGenerator generator = new ShrinkingGenerator();
        final int random = RandomUtil.getRandInt(1,99999999);
        list.add("Wylosowano randomowa licze : " +random);
        final String inputBit = Long.toBinaryString(random);
        final int l1 = generator.nextInt();
        final int l2 = generator.nextInt();
        final int l3 = generator.nextInt();
        for (int i = 0; i< size; i++) {
            list.add("Dane na wejsciu " + inputBit);
            Polynomial polynomial1 = new Polynomial(RandomUtil.getRandInt(1,99), RandomUtil.getRandInt(1,99), RandomUtil.getRandInt(1,99), RandomUtil.getRandInt(1,99));
            Polynomial polynomial2 = new Polynomial(RandomUtil.getRandInt(1,99), RandomUtil.getRandInt(1,99), RandomUtil.getRandInt(1,99), RandomUtil.getRandInt(1,99));
            Polynomial polynomial3 = new Polynomial(RandomUtil.getRandInt(1,99), RandomUtil.getRandInt(1,99), RandomUtil.getRandInt(1,99), RandomUtil.getRandInt(1,99));

            LFSR lfsr1 = new LFSR(polynomial1);
            LFSR lfsr2 = new LFSR(polynomial2);
            LFSR lfsr3 = new LFSR(polynomial3);

            lfsr1.setInitialState(l1);
            lfsr2.setInitialState(l2);
            lfsr3.setInitialState(l3);

            GeffeGenerator geffe = new GeffeGenerator(lfsr1, lfsr2, lfsr3);

            geffe.step(inputBit.length());

            list.add("LFSR1: " + lfsr1.getOutputSequence());
            list.add("LFSR2: " + lfsr2.getOutputSequence());
            list.add("LFSR3: " + lfsr3.getOutputSequence());
            final String output = geffe.getGamma();
            list.add("Dane na wyjsciu: " + output);
            if (output.equalsIgnoreCase(inputBit)) {
                System.out.println("Input equals output");
                list.add("Input equals output");
            }
            list.add("");
        }
        FileUtil.save(name,list);
    }
}
