/*
This program takes a password string as input and encrypts it using a stream cipher.
some points which needs to be considered for choosing a valid password.
-- 1. password must be lowercase alphabet characters only with not less than 6 characters.
Function will work for other cases also but passwords which follow above point will
be hard to crack without key.
*/

import java.util.Scanner;
import java.lang.StringBuilder;

class Main {
	public static void main(String args[]) {
		// Your code goes here
		Scanner input = new Scanner(System.in);
        String password = input.nextLine();
		System.out.println("Please enter password for encryption");
        System.out.println("your entered password is : "+password);

        // Parse the input and encrypt it
        int seed = 448;
        int[] encrypted_arr = new int[password.length()];
        for (int l=0;l< encrypted_arr.length;l++){
            encrypted_arr[l] = password.charAt(l)^random(seed);
            seed = random(seed);
        }
		StringBuilder encrypted_message = new StringBuilder();
		for (int i=0;i<encrypted_arr.length;i++){
			int y = 97+(encrypted_arr[i])%26;
			encrypted_message.append((char)y);
		}

        System.out.println("your encrypted pasword is : "+encrypted_message);

        // Decryption
        StringBuilder decrypted_str = new StringBuilder();
        int key_dec = 448;
        for (int j=0;j<encrypted_arr.length;j++){
            int x = encrypted_arr[j]^random(key_dec);
            decrypted_str.append((char)x);
            key_dec = random(key_dec);
        }
        System.out.println("your decrypted pasword is : "+decrypted_str);
	}
	static int random(int seed){
        int a = 1000, b=100;
        return ((a*seed+b)%16384);
    }
}
