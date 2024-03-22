package javacode.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        // Generate a key

        // Generate an IV
        byte[] keyBytes = {(byte) 0x71, (byte) 0xF1, (byte) 0xBC, (byte) 0xD6, (byte) 0xC7, (byte) 0x5F, (byte) 0x9C, (byte) 0xE2, (byte) 0x66, (byte) 0xE9, (byte) 0x7C, (byte) 0x21, (byte) 0x86, (byte) 0x9F, (byte) 0xD7, (byte) 0x9A};
        byte[] ivBytes = {(byte) 0xA1, (byte) 0x96, (byte) 0x1E, (byte) 0x62, (byte) 0xFB, (byte) 0x82, (byte) 0x19, (byte) 0x16, (byte) 0x7E, (byte) 0xC8, (byte) 0xB0, (byte) 0xC0, (byte) 0xD2, (byte) 0x99, (byte) 0xFA, (byte) 0xA7};
        byte[] dataBytes = {(byte) 0xc4, (byte) 0x00, (byte) 0x0e, (byte) 0x00, (byte) 0x80, (byte) 0xa3, (byte) 0xf1, (byte) 0x33, (byte) 0xb0, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x03, (byte) 0xca};

        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

        // Initialize the cipher for encryption
        Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] originalIV = cipher.getIV();

        // Encrypt the plaintext block by block
        byte[] ciphertext = new byte[dataBytes.length];
        int offset = 0;

        while (offset < dataBytes.length) {
            // Update IV after each block
            byte[] updatedIV = cipher.update(new byte[cipher.getBlockSize()]);

            // XOR the plaintext block with the updated IV
            for (int i = 0; i < cipher.getBlockSize(); i++) {
                ciphertext[offset + i] = (byte) (dataBytes[offset + i] ^ updatedIV[i]);
            }

            offset += cipher.getBlockSize();
        }

        // Perform final update
        cipher.doFinal();

        // Output the original and updated IVs
        System.out.println("Original IV: " + Arrays.toString(originalIV));
        System.out.println("Updated IV:  " + Arrays.toString(cipher.getIV()));


        /*for (int i = 0; i < 2; i++) {
            // Encrypt the data in chunks
            //byte[] input = plaintext.getBytes();
            byte[] ciphertext = new byte[dataBytes.length];
            int outputOffset = 0;
            int inputLen = Math.min(16, dataBytes.length - i);
            //cipher.update(dataBytes, i, inputLen, ciphertext, outputOffset);

            outputOffset += cipher.doFinal(dataBytes, outputOffset, 0, ciphertext, outputOffset);

            // Print the encrypted data
            System.out.println(bytesToHexStringWithDashes(ciphertext));
        }*/

    }

    private static byte[] xorArrays(byte[] array1, byte[] array2) {
        byte[] result = new byte[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = (byte) (array1[i] ^ array2[i]);
        }
        return result;
    }

    private static String bytesToHexStringWithDashes(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("0x%02X-", b));
        }
        return sb.toString();
    }

}