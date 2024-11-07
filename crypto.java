
//import class Scanner dari java.util
import java.util.Scanner;



public class crypto {
    
    // fungsi untuk membuat alfabet yang digeser 
    public static String createShiftedAlphabet(String key) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        // menyusun shiftedAlphabet dimulai dari KEY
        int keyLength = key.length();
        int startIndex = alphabet.indexOf(key.charAt(0));
        String shiftedAlphabet = key;
        
        // tambah sisa huruf setelah KEY
        for (int i = startIndex + keyLength; i < alphabet.length(); i++) {
            shiftedAlphabet += alphabet.charAt(i);
        }
        
        //  tambah huruf sebelum KEY yang belum ada di shiftedAlphabet
        for (int i = 0; i < startIndex; i++) {
            shiftedAlphabet += alphabet.charAt(i);
        }
        
        return shiftedAlphabet;
    }



    // function encrypt
    public static String encrypt(String text, String shiftedAlphabet) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        text = text.toUpperCase(); // dijadikan uppercase biar enak diliat 
        StringBuilder encryptedText = new StringBuilder();

        // encrypt tiap karakter dalam teks
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                // mengambil posisi karakter di alfabet asli
                int index = alphabet.indexOf(c);
                // Mengganti dengan char dari alfabet yang digeser
                encryptedText.append(shiftedAlphabet.charAt(index));
            } else {
                // Menambahkan spasi (karakter non-huruf)
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }

    // funct decrypt
    public static String decrypt(String text, String shiftedAlphabet) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        text = text.toUpperCase();
        StringBuilder decryptedText = new StringBuilder();

        // Decrypt semua char dati input
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                // ambil posisi karakter yang telah digeser
                int index = shiftedAlphabet.indexOf(c);
                // Mengganti ke alfabet asli
                decryptedText.append(alphabet.charAt(index));
            } else {
                // nambah spasi lagi
                decryptedText.append(c);
            }
        }

        return decryptedText.toString();
    }
    
    
    //interface 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih mode:");
        System.out.println("1. Enkripsi");
        System.out.println("2. Dekripsi");
        System.out.print("Masukkan pilihan Anda (1 atau 2): ");
        int choice = scanner.nextInt();
        
        scanner.nextLine();// clean buffer scanner

        System.out.print("Masukkan teks: ");
        String text = scanner.nextLine();

        System.out.print("Masukkan KEY (contoh: RSTU): ");
        String key = scanner.nextLine().toUpperCase();

        // membuat alfabet yang telah digeser menggunakan KEY
        String shiftedAlphabet = createShiftedAlphabet(key);
        System.out.println("Alfabet yang telah digeser: " + shiftedAlphabet);

        // select mode
        if (choice == 1) {
            // Encrypt
            String encryptedText = encrypt(text, shiftedAlphabet);
            System.out.println("Hasil Enkripsi: " + encryptedText);
        } else if (choice == 2) {
            // Decrypt
            String decryptedText = decrypt(text, shiftedAlphabet);
            System.out.println("Hasil Dekripsi: " + decryptedText);
        } else {
            System.out.println("Pilihan tidak valid. Program berakhir.");
        }
        //nutup scanner
        scanner.close();
    }
}