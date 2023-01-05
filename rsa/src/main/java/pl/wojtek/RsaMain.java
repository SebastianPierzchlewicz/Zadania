package pl.wojtek;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.wojtek.rsa.RSAGenerator;
import pl.wojtek.rsa.RSAUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.*;
import java.util.Base64;
import java.util.Random;
import java.util.function.Consumer;

public class RsaMain {


    public static void main(String[] args) throws Exception {
        //Generowanie kluczy
        final RSAGenerator rsa = new RSAGenerator();
        System.out.println("klucz prywatny: " + rsa.getPrivateKey());
        System.out.println("klucz publiczny: " + rsa.getPublicKey());

        final String message = "Wojtek Watral - WSB - 2022";
        System.out.println("Wiadomosc do zaszyfrowania: " + message);
        //encrypted -> kluczem prywatnym
        String encryptedMessagePrivate = RSAUtil.encrypt(rsa.getPrivateKey(), message);
        //Decryptec -> kluczem puvlicznym
        String decryptedMessagePublic = RSAUtil.decrypt(rsa.getPublicKey(), encryptedMessagePrivate);

        System.out.println("-----");
        System.out.println("Encrypted [PrivateKey] " + encryptedMessagePrivate);
        System.out.println("Decryptec [PublicKey] " + decryptedMessagePublic);
        System.out.println("-----");
        //encrypted -> kluczem publicznym
        String encryptedMessagePublic = RSAUtil.encrypt(rsa.getPrivateKey(), message);
        //Decryptec -> kluczem prywatnym
        String decryptedMessagePrivate = RSAUtil.decrypt(rsa.getPublicKey(), encryptedMessagePrivate);
        System.out.println("");
        System.out.println("Encrypted [PublicKey] " + encryptedMessagePublic);
        System.out.println("Decryptec [PrivateKey] " + decryptedMessagePrivate);
        System.out.println("-----");


        noMessageAttack();

        check("tes2t", aBoolean -> {
            System.out.printf(String.valueOf(aBoolean));
        });

    }


    private static void noMessageAttack() {
        final int message = RandomUtil.getRandInt(0,100);
        System.out.println("Wiadomość do zaszyforwania: " + message);
        double c;
        BigInteger decrypt;
        int p = 5;
        int q = 19;
        int n = p * q;
        int z = (p - 1) * (q - 1);
        int d = 0;
        int e;
        for (e = 2; e < z; e++) {
            if (getEZ(e, z) == 1) {
                break;
            }
        }
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        c = (Math.pow(message, e)) % n;
        double s = (Math.pow(message, d)) % n;
        double m = (Math.pow(s, e) % n);
        System.out.println("m'" + m);
        System.out.println("Encrypted: " + c);
        BigInteger N = BigInteger.valueOf(n);
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        decrypt = (C.pow(d)).mod(N);
        System.out.println("Decryptec: " + decrypt);

    }

    private static int getEZ(int e, int z) {
        if (e == 0) {
            return z;
        } else {
            return getEZ(z % e, e);
        }
    }

    public static void check(String name, Consumer<Boolean> callback) {

        if (name.equalsIgnoreCase("test")) {
            callback.accept(true);
        }
        else {
            callback.accept(false);
        }
    }
}
