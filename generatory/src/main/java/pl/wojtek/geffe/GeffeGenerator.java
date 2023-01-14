package pl.wojtek.geffe;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GeffeGenerator
{
    private final GeffeData geffeData1;
    private final GeffeData geffeData2;
    private final GeffeData geffeData3;

    public long next(){
        long x = geffeData1.next();
        long y = geffeData2.next();
        long s = geffeData3.next();
        return (s & x) ^ ((s ^ 1) & y);
    }
}
