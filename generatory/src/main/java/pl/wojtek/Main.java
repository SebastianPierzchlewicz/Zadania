package pl.wojtek;

import pl.wojtek.LFSR.LFSRHelper;
import pl.wojtek.geffe.GeffeCryptanalysis;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main
{
    public static void main(String args[]) throws IOException {
        String bitString = LFSRHelper.randomLFSR(2);
        System.out.println(bitString);
        GeffeCryptanalysis.breakGeffe(
                Long.parseLong(LFSRHelper.randomLFSR(2)),
                Long.parseLong(LFSRHelper.randomLFSR(3)),
                Long.parseLong(LFSRHelper.randomLFSR(4)),
                parseBits(bitString)
        );
    }

    private static int[] parseBits(String bitString) {
        int[] bits = new int[bitString.length()];
        for (int i = 0; i < bits.length; i++) {
            char bit = bitString.charAt(i);
            if (bit == '0') {
                bits[i] = 0;
            } else if (bit == '1') {
                bits[i] = 1;
            } else {
                throw new IllegalArgumentException("Unexpected character: " + bit);
            }
        }
        return bits;
    }

}
