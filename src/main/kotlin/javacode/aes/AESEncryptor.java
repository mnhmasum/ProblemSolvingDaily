package javacode.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class AESEncryptor {

    public static void main(String[] args) {
        try {
            String keyHex = "71F1BCD6C75F9CE266E97C21869FD79A";
            String ivHex = "A1961E62FB8219167EC8B0C0D299FAA7";
            String dataHex = "C100100080A3F1382E000002000000034D";

            byte[] keyBytes = hexStringToByteArray(keyHex);
            byte[] ivBytes = hexStringToByteArray(ivHex);
            byte[] dataBytes = hexStringToByteArray(dataHex);

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

            Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] encryptedBytes = cipher.doFinal(dataBytes);

            // Print the encrypted bytes in the desired format
            System.out.println(bytesToHexStringWithDashes(encryptedBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }

    private static String bytesToHexStringWithDashes(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("0x%02X-", b));
        }
        return sb.toString();
    }
}
