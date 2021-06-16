package com.scw;

import javax.crypto.KeyGenerator;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;

public class KeyGeneration {

    public static void KeyGenRecipes() throws Exception {
        KeyGenerator gen = KeyGenerator.getInstance("AES");
        KeyPairGenerator gen1 = KeyPairGenerator.getInstance("RSA");
        KeyGenerator gen2 = KeyGenerator.getInstance("HmacMD5");

        KeyGenerator gen3 = KeyGenerator.getInstance("AES");
        gen3.init(64);
        gen3.init(128);

        // https://security.stackexchange.com/questions/2335/should-rsa-public-exponent-be-only-in-3-5-17-257-or-65537-due-to-security-c
        AlgorithmParameterSpec spec = new RSAKeyGenParameterSpec(1024, BigInteger.valueOf(3));
        KeyPairGenerator gen4 = KeyPairGenerator.getInstance("RSA");
        gen4.initialize(spec);
        gen4.initialize(1024);
    }
}
