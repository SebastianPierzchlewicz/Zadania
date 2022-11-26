package pl.wojtek;

import pl.wojtek.utils.Md5Utils;
import pl.wojtek.utils.Sha1Util;
import pl.wojtek.utils.Sha256Util;

public class Main
{
    public static void main(final String args[]) {

        final String strA = "kot";
        final String strB= "dzisiaj mial byc piekny dzien, jednak zobaczylem ze to poniedzialek";
        final String strC= "wiem, ze nic nie wiem";

        final String sortAMd5 = Md5Utils.md5(strA);
        final String sortBMd5 = Md5Utils.md5(strB);
        final String sortCMd5 = Md5Utils.md5(strC);

        final String sortASha = Sha1Util.sha1(strA);
        final String sortBSha = Sha1Util.sha1(strB);
        final String sortCSha = Sha1Util.sha1(strC);

        final String sortASha256 = Sha256Util.sha256(strA);
        final String sortBSha256 = Sha256Util.sha256(strB);
        final String sortCSha256 = Sha256Util.sha256(strC);

        System.out.println("Przed hash");
        System.out.println(strA);
        System.out.println(strB);
        System.out.println(strC);
        System.out.println("");

        System.out.println("--- Hash Md5 ---");
        System.out.println(sortAMd5);
        System.out.println(sortBMd5);
        System.out.println(sortCMd5);
        System.out.println("");

        System.out.println("--- Hash Sha-1 ---");
        System.out.println(sortASha);
        System.out.println(sortBSha);
        System.out.println(sortCSha);
        System.out.println("");

        System.out.println("--- Hash Sha256 ---");
        System.out.println(sortASha256);
        System.out.println(sortBSha256);
        System.out.println(sortCSha256);
        System.out.println("");

    }

}
