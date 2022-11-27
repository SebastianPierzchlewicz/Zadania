package pl.wojtek;

import pl.wojtek.rsa.RSAGenerator;
import pl.wojtek.rsa.RSAUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;

public class RsaMain {



    public static void main(String[] args) throws Exception {
        //Generowanie kluczy
        final RSAGenerator rsa = new RSAGenerator();
        System.out.println("klucz prywatny: " + rsa.getPrivateKey());
        System.out.println("klucz publiczny: " + rsa.getPublicKey());

        final String message = "Wojtek Watral - WSB - 2022";
        System.out.println("Wiadomosc do zaszyfrowania: " + message);
        //encrypted -> kluczem prywatnym
        String encryptedMessagePrivate = RSAUtil.encrypt(rsa.getPrivateKey(),message);
        //Decryptec -> kluczem puvlicznym
        String decryptedMessagePublic = RSAUtil.decrypt(rsa.getPublicKey(),encryptedMessagePrivate);

        System.out.println("-----");
        System.out.println("Encrypted [PrivateKey] " + encryptedMessagePrivate);
        System.out.println("Decryptec [PublicKey] " + decryptedMessagePublic);
        System.out.println("-----");
        //encrypted -> kluczem publicznym
        String encryptedMessagePublic = RSAUtil.encrypt(rsa.getPrivateKey(),message);
        //Decryptec -> kluczem prywatnym
        String decryptedMessagePrivate = RSAUtil.decrypt(rsa.getPublicKey(),encryptedMessagePrivate);
        System.out.println("");
        System.out.println("Encrypted [PublicKey] " + encryptedMessagePublic);
        System.out.println("Decryptec [PrivateKey] " + decryptedMessagePrivate);
        System.out.println("-----");

    }



}
