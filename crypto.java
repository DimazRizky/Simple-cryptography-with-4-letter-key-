// import Scanner class from java.util
import java.util.Scanner;

public class crypto{
    
    // function to create a shifted alphabet based on the key
    public static String createShiftedAlphabet(String key) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        // start shiftedAlphabet with the key
        int keyLength = key.length();
        int startIndex = alphabet.indexOf(key.charAt(0));
        String shiftedAlphabet = key;
        
        // add remaining letters after the key
        for (int i = startIndex + keyLength; i < alphabet.length(); i++) {
            shiftedAlphabet += alphabet.charAt(i);
        }
        
        // add letters before the key that aren't in shiftedAlphabet
        for (int i = 0; i < startIndex; i++) {
            shiftedAlphabet += alphabet.charAt(i);
        }
        
        return shiftedAlphabet;
    }

    // function to encrypt
    public static String encrypt(String text, String shiftedAlphabet) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        text = text.toUpperCase(); // convert to uppercase for consistency
        StringBuilder encryptedText = new StringBuilder();

        // encrypt each character in the text
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                // get the position of the character in the original alphabet
                int index = alphabet.indexOf(c);
                // replace with char from shifted alphabet
                encryptedText.append(shiftedAlphabet.charAt(index));
            } else {
                // keep space (non-letter character)
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }

    // function to decrypt
    public static String decrypt(String text, String shiftedAlphabet) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        text = text.toUpperCase();
        StringBuilder decryptedText = new StringBuilder();

        // decrypt each character from the input
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                // get the position of the shifted character
                int index = shiftedAlphabet.indexOf(c);
                // replace with original alphabet character
                decryptedText.append(alphabet.charAt(index));
            } else {
                // keep space
                decryptedText.append(c);
            }
        }

        return decryptedText.toString();
    }
    
    // interface
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose mode:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        
        scanner.nextLine(); // clear scanner buffer

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.print("Enter KEY (e.g., RSTU): ");
        String key = scanner.nextLine().toUpperCase();

        // create a shifted alphabet using the KEY
        String shiftedAlphabet = createShiftedAlphabet(key);
        System.out.println("Shifted Alphabet: " + shiftedAlphabet);

        // select mode
        if (choice == 1) {
            // Encrypt
            String encryptedText = encrypt(text, shiftedAlphabet);
            System.out.println("Encrypted Result: " + encryptedText);
        } else if (choice == 2) {
            // Decrypt
            String decryptedText = decrypt(text, shiftedAlphabet);
            System.out.println("Decrypted Result: " + decryptedText);
        } else {
            System.out.println("Invalid choice. Program ends.");
        }

        // close scanner
        scanner.close();
    }
}