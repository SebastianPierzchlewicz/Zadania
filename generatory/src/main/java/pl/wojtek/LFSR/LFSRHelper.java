package pl.wojtek.LFSR;

import java.util.ArrayList;
import java.util.List;

public class LFSRHelper
{
    public static String randomLFSR(int trials) {
        boolean[] a = {
                false, true, false, false, false,
                false, true, false, true, true, false
        };
        final StringBuilder builder = new StringBuilder();
        int n = a.length;
        int TAP = 8;
        for (int t = 0; t < trials; t++) {

            boolean next = (a[n-1] ^ a[TAP]);

            for (int i = n-1; i > 0; i--) {
                a[i] = a[i - 1];
            }

            a[0] = next;

            if (next) {
                builder.append("1");
            }
            else   {
                builder.append("0");
            }
        }
        return builder.toString();
    }
}
