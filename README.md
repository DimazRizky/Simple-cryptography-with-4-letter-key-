# WHAT IS THE FUNCTION OF THIS CODE?
This code is used to encrypt or can also decrypt plaintext using Java as the main language.

> ⚠️This code only runs on terminal/shell and does not display GUI!!

# INSTALLING GUIDE IN TERMUX
---
**How to running the Code in Termux?**

First clone this project

Open Termux and run the following commands to install OpenJDK v21 or latters:
```bash
pkg update
pkg install openjdk-21
```


Create and Edit **Java File** Create a file called **crypto.java**:

```bash
nano crypto.java
```
Paste the code above into this file, then save and exit the editor (in nano, press CTRL + X, then Y, and Enter).


Compile Java Code Run the following command to compile the Java file:
```bash
javac crypto.java
```
If there are no errors, this will create a file named 
```bash
crypto.class
```


**Run the Program**:
```bash
java crypto.java
```

---

> By following these steps, you can run this code in Termux, read text from user input, and produce an encrypted or decrypted result based on the chosen mode.

---

# CODE IDENTIFICATION
---
I will explain in detail the meaning of the code I wrote to make it easier for you to read this code.

--
First you can import the library 

**Scanner Library**
<br>
```java
import java.util.Scanner;
```
This line imports the Scanner class from java.util, allowing us to read user input from the console.

**Main Class Declaration**

```java
public class crypto {
```
This declares a class named EncryptDecrypt. Inside this class, we define all methods needed for encryption, decryption, and creating the shifted alphabet.

**createShiftedAlphabet Function**
```java
public static String createShiftedAlphabet(String key) {
```
<br>

```java
String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
```
This function takes key (as a string) from the user and creates a shifted version of the alphabet based on that key.

> String alphabet contains the basic A-Z alphabet as a reference.
<br>

```java
int keyLength = key.length();
    int startIndex = alphabet.indexOf(key.charAt(0));
    String shiftedAlphabet = key;
```
keyLength stores the length of key, and startIndex determines the position of the first letter of key in alphabet. shiftedAlphabet is initialized with the key.
<br>

```java
for (int i = startIndex + keyLength; i < alphabet.length(); i++) {
        shiftedAlphabet += alphabet.charAt(i);
    }
```
This first loop appends the letters after the key until the end of the alphabet.

```java
for (int i = 0; i < startIndex; i++) {
        shiftedAlphabet += alphabet.charAt(i);
    }
```
And the second loop appends the letters that come before the key (letters not already in shiftedAlphabet).
<br>

```java
return shiftedAlphabet;
}
```
This returns shiftedAlphabet, which contains the alphabet shifted according to the key.

--
## Encrypt Function

```java
public static String encrypt(String text, String shiftedAlphabet) {
```
The encrypt function takes two parameters: text (the text to be encrypted) and shiftedAlphabet (the shifted alphabet created using key).
<br>

```java
String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    text = text.toUpperCase();
    StringBuilder encryptedText = new StringBuilder();
```
This initializes alphabet, converts text to uppercase, and creates a StringBuilder to store the encrypted result.
<br>

```java
for (char c : text.toCharArray()) {
```
The for loop iterates over each character in text.
<br>

```java
if (Character.isLetter(c)) {
            int index = alphabet.indexOf(c);
            encryptedText.append(shiftedAlphabet.charAt(index));
        } else {
            encryptedText.append(c);
        }
    }
```
If the character is a letter, the program finds its index in alphabet and appends the corresponding character in shiftedAlphabet to encryptedText. If it’s not a letter, the character is appended directly.
<br>

```java
return encryptedText.toString();
}
```
This returns encryptedText as the final encrypted string.

---
## Decrypt Function

```java
public static String decrypt(String text, String shiftedAlphabet) {
```
The decrypt function takes text and shiftedAlphabet and reverses the encryption to restore the original text.
<br>

```java
String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    text = text.toUpperCase();
    StringBuilder decryptedText = new StringBuilder();
```
This initializes alphabet, converts text to uppercase, and creates a StringBuilder to store the decrypted text.
<br>

```java
for (char c : text.toCharArray()) {
        if (Character.isLetter(c)) {
            int index = shiftedAlphabet.indexOf(c);
            decryptedText.append(alphabet.charAt(index));
        } else {
            decryptedText.append(c);
        }
    }
```
If the character is a letter, the program finds its index in shiftedAlphabet and retrieves the corresponding letter in alphabet to restore the original character. If it’s not a letter, it’s directly appended to decryptedText.
<br>

```java
return decryptedText.toString();
}
```
This returns decryptedText as the final decrypted string.

<br>
## main Function - User Interface
<br>

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
```
This creates a Scanner object to read user input from the console.
<br>

```java
System.out.println("Choose a mode:");
    System.out.println("1. Encrypt");
    System.out.println("2. Decrypt");
    System.out.print("Enter your choice (1 or 2): ");
    int choice = scanner.nextInt();
    scanner.nextLine();
```
The program prompts the user to select a mode: 1 for encryption or 2 for decryption. scanner.nextLine() clears the buffer after reading the integer.
<br>

```java
System.out.print("Enter text: ");
    String text = scanner.nextLine();

    System.out.print("Enter KEY (e.g., RSTU): ");
    String key = scanner.nextLine().toUpperCase();
```
The program then prompts the user to enter the text to be encrypted or decrypted, as well as the key.
<br>

```java
String shiftedAlphabet = createShiftedAlphabet(key);
    System.out.println("Shifted alphabet: " + shiftedAlphabet);
```
createShiftedAlphabet is called with key to create the shiftedAlphabet, which is then printed.
<br>

```java
if (choice == 1) {
        String encryptedText = encrypt(text, shiftedAlphabet);
        System.out.println("Encrypted result: " + encryptedText);
    } else if (choice == 2) {
        String decryptedText = decrypt(text, shiftedAlphabet);
        System.out.println("Decrypted result: " + decryptedText);
    } else {
        System.out.println("Invalid choice. Program exits.");
    }
    scanner.close();
}
```
If choice is 1, the text is encrypted and the result is printed; if it is 2, the text is decrypted. If the choice is invalid, the program displays a message and exits.

<br>
That's all for those of you who read my explanation and thank you. 

---

[MIT License](https://github.com/DimazRizky/Simple-cryptography-with-4-letter-key-in-TERMUX/blob/main/LICENSE)

Copyright (c) 2024 DimazRizky
