import java.util.*;
import java.io.*;

public class Caesercipher
{
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
 	
	public static String encrypt(String ptext, int cserkey)
 	{
 		StringBuilder ctext = new StringBuilder();
 		for (int i = 0; i < ptext.length(); i++)
 		{
			char currentChar = ptext.charAt(i);
			if (Character.isLetter(currentChar))
			{
 				char encryptedChar = encryptChar(currentChar, cserkey);
				ctext.append(encryptedChar);
			}else{
				ctext.append(currentChar);
			}
 		}
 		return ctext.toString();
 	}
 	public static String decrypt(String ctext, int cserkey)
 	{
 		StringBuilder ptext = new StringBuilder();
 		for (int i = 0; i < ctext.length(); i++)
 		{
			char currentChar = ctext.charAt(i);
 			if (Character.isLetter(currentChar))
			{
				char decryptedChar = decryptChar(currentChar, cserkey);
 				ptext.append(decryptedChar);
			}else{
				ptext.append(currentChar);
			}
 		}
 		return ptext.toString();
 	}

    	private static char encryptChar(char inputChar, int caeserKey) 
	{
        	char base = Character.isUpperCase(inputChar) ? 'A' : 'a';
        	int charIndex = (inputChar - base + caeserKey) % 26;
        	if (charIndex < 0)
	 	{
        	    charIndex += 26;
        	}
        	return (char) (base + charIndex);
    	}

    	private static char decryptChar(char inputChar, int caeserKey) 
	{
        	char base = Character.isUpperCase(inputChar) ? 'A' : 'a';
        	int charIndex = (inputChar - base - caeserKey) % 26;
        	if (charIndex < 0)
		{
            		charIndex += 26;
        	}
        	return (char) (base + charIndex);
    	}

 	public static void main(String[] args)
 	throws IOException
 	{
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		System.out.println("Enter the PLAIN TEXT for Encryption: ");
 		String plaintext = br.readLine();

 		System.out.println("Enter the CAESERKEY between 0 and 25:");
 		int key = Integer.parseInt(br.readLine());

 		System.out.println("ENCRYPTION");
 		String ciphertext = encrypt(plaintext,key);
 		System.out.println("CIPHER TEXT :"+ ciphertext);

 		System.out.println("DECRYPTION");
 		String decryptedtext = decrypt(ciphertext,key);
 		System.out.println("PLAIN TEXT :" + decryptedtext);
 	}
} 