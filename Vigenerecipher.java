import java.util.Scanner;

public class Vigenerecipher {
    private String key;
    private String extendedKey;
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String extendKey(String plaintext, String key) {
        StringBuilder newKey = new StringBuilder();
        int keyIndex = 0;
        for (char c : plaintext.toCharArray()) {
            newKey.append(key.charAt(keyIndex));
            keyIndex = (keyIndex + 1) % key.length();
        }
        return newKey.toString();
    }

    public int indexOfChar(char x) {
        return ALPHABET.indexOf(x);
    }

    public char charAtIndex(int index) {
        return ALPHABET.charAt(index);
    }

    public String vigenereEncrypt(String plaintext) {
        int p, k, encryptedChar;
        char encrypted;
        StringBuilder ciphertext = new StringBuilder();
        extendedKey = extendKey(plaintext, key);
        System.out.println("VIGENERE ENCRYPTION");
        System.out.println("PLAIN TEXT : " + plaintext);
        System.out.println("VIGENERE KEY : " + extendedKey);

        for (int i = 0; i < plaintext.length(); i++) {
            p = indexOfChar(plaintext.charAt(i));
            k = indexOfChar(extendedKey.charAt(i));
            encryptedChar = (p + k) % 26;
            encrypted = charAtIndex(encryptedChar);
            ciphertext.append(encrypted);
        }
        return ciphertext.toString();
    }

    public String vigenereDecrypt(String ciphertext) {
        int c, k, decryptedChar;
        char decrypted;
        StringBuilder plaintext = new StringBuilder();
        System.out.println("VIGENERE DECRYPTION");
        System.out.println("CIPHER TEXT : " + ciphertext);
        System.out.println("VIGENERE KEY : " + extendedKey);

        for (int i = 0; i < ciphertext.length(); i++) {
            c = indexOfChar(ciphertext.charAt(i));
            k = indexOfChar(extendedKey.charAt(i));
            decryptedChar = (c - k + 26) % 26;
            decrypted = charAtIndex(decryptedChar);
            plaintext.append(decrypted);
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Vigenerecipher vc = new Vigenerecipher();
        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER KEY");
        vc.key = sc.next();

        String text;
        System.out.println("Enter PLAIN TEXT");
        text = sc.next();

        String ciphertext = vc.vigenereEncrypt(text);
        System.out.println("\nCIPHER TEXT: " + ciphertext);

        String plaintext = vc.vigenereDecrypt(ciphertext);
        System.out.println("\nPLAIN TEXT: " + plaintext);

        sc.close();
    }
}
