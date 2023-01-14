package pl.wojtek.geffe;

public class GeffeData {

    private final long start;
    private long state;
    private final long multi;
    private final int size;

    public GeffeData(long number, long start) {
        int n = Long.numberOfLeadingZeros(number) + 1;
        if (n > 63) {
            throw new IllegalArgumentException("Zbyt duza ilosc " + (63 - n));
        }
        int identityMask = (0xffffffff >>> n);
        this.size = 64 - n;
        this.multi = number & identityMask;
        this.start = start & identityMask;
        this.state = this.start;
    }

    public long next() {
        long outputBit = state & 1;
        int nextValue = Long.bitCount(state & multi) & 1;
        state = (state >>> 1) | ((long) nextValue << (size - 1));
        return outputBit;
    }

    public void reset() {
        state = start;
    }

    @Override
    public String toString() {
        return Long.toBinaryString(state);
    }
}