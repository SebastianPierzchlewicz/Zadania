package pl.wojtek.geffe;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GeffeCryptanalysis {

    private static int countCoincidingBits(GeffeData l, int[] outputBits) {
        int count = 0;
        for (int outputBit : outputBits) {
            count += outputBit ^ l.next();
        }
        return count;
    }

    private static List<Long> findStartState(long polynomial, int[] outputBits, int N, int C) {
        long length = 63 - Long.numberOfLeadingZeros(polynomial);
        long limit = (1 << (length));
        if (N < outputBits.length) {
            outputBits = Arrays.copyOf(outputBits, N);
        }
        List<Long> candidates = new LinkedList<>();
        for (long state = 0; state < limit; state++) {
            GeffeData register = new GeffeData(polynomial, state);
            int R = countCoincidingBits(register, outputBits);
            if (R <= C) {
                candidates.add(state);
                System.out.println(Long.toBinaryString(state)+" :"+R);
            }
        }
        return candidates;
    }

    public static void breakGeffe(long polynomialL1, long polynomialL2, long polynomialL3, int[] bits) throws IOException {
        System.out.println("LSFR L1:");
        List<Long> l1States = findStartState(polynomialL1, bits, 222, 68);
        //l1States.txt.forEach(System.out::println);
        //l1States.forEach(a -> System.out.println(Long.toBinaryString(a)));

        System.out.println("\nLSFR L2:");
        List<Long> l2States = findStartState(polynomialL2, bits,229,70);
        //l2States.forEach(System.out::println);
//        try{
//            FileWriter writer = new FileWriter("l2States.txt",true);
//            l2States.forEach(a -> {
//                try {
//                    writer.append(Long.toBinaryString(a)).append("\n");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//            writer.flush();
//            writer.close();
//        }catch (IOException e){
//
//        }
        //l2States.forEach(a -> System.out.println(Long.toBinaryString(a)));

        System.out.println("\nLSFR L3:");
        List<Long> l3States = new LinkedList<>();
//        String s;
//        BufferedReader l1in = new BufferedReader(new FileReader("l1States.txt"));
//        while ((s=l1in.readLine())!=null){
//            l1States.add(s);
//        }
//        l1in.close();
//        BufferedReader l2in = new BufferedReader(new FileReader("l2States.txt"));
//        while ((s=l2in.readLine())!=null){
//            l2States.add(s);
//        }
//        l2in.close();
        long length = 63 - Long.numberOfLeadingZeros(polynomialL3);
        long limit = (1 << (length));
        //System.out.println("1 == "+ (limit>>length));
        //long limit = (long)1<<27;
        for (long l3State = 0; l3State < limit; l3State++){
            GeffeData registerL3 = new GeffeData(polynomialL3, l3State);
            for (long l1State:l1States){
                GeffeData registerL1 = new GeffeData(polynomialL1, l1State);
                for(long l2State:l2States){
                    registerL1.reset();
                    registerL3.reset();
                    GeffeData registerL2 = new GeffeData(polynomialL2, l2State);
                    if (isCorrectL3(Long.toBinaryString(registerL3.next()),Long.toBinaryString(registerL1.next()),Long.toBinaryString(registerL2.next()))){
//                        System.out.println(l1State);
//                        System.out.println(l2State);
//                        System.out.println(Long.toBinaryString(l3State));
                        l3States.add(l3State);
                        System.out.println(Long.toBinaryString(l3State));
                    }
                }
            }
        }
        FileWriter writer = new FileWriter("result.txt");

        System.out.println("\nGeffe Test:");
        for (long l1State : l1States) {

            GeffeData registerL1 = new GeffeData(polynomialL1, l1State);
            for (long l2State : l2States) {
                GeffeData registerL2 = new GeffeData(polynomialL2, l2State);
                    for (long l3State : l3States) {
                        registerL1.reset();
                        registerL2.reset();
                        GeffeData registerL3 = new GeffeData(polynomialL3, l3State);
                        GeffeGenerator geffe = new GeffeGenerator(registerL1, registerL2, registerL3);
                        for (int bit : bits) {
                            if (bit != geffe.next()) {
                                break;
                            }
                        }
//                        System.out.println("---------");
//                        System.out.println(Long.toBinaryString(l1State));
//                        System.out.println(Long.toBinaryString(l2State));
//                        System.out.println(Long.toBinaryString(l3State));
                        writer.append(Long.toBinaryString(l1State)).append("\n");
                        writer.append(Long.toBinaryString(l2State)).append("\n");
                        writer.append(Long.toBinaryString(l3State)).append("\n");
                        writer.append("\n");
                    }
            }
        }
        writer.flush();
        writer.close();
    }

    private static boolean isCorrectL3(String correct, String l1sequence, String l2sequence) {
        int i = 0;
        if (l1sequence.charAt(i) != l2sequence.charAt(i)) {
            if (correct.charAt(i) != l1sequence.charAt(i)) {
                return false;
            }
            if (correct.charAt(i) != l2sequence.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}