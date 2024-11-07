# INSTALLING GUIDE IN TERMUX
---
How to running the Code in Termux?

follow these steps:

1. Install Java on Termux Open Termux and run the following commands to install OpenJDK v21 or latters:

pkg update
pkg install openjdk-21


2. Create and Edit Java File Create a file called EncryptDecrypt.java:

nano EncryptDecrypt.java

Paste the code above into this file, then save and exit the editor (in nano, press CTRL + X, then Y, and Enter).


3. Compile Java Code Run the following command to compile the Java file:

javac crypto.java

If there are no errors, this will create a file named 

crypto.class


4. Run the Program Run the program with this command:

java crypto.java


---

By following these steps, you can run this code in Termux, read text from user input, and produce an encrypted or decrypted result based on the chosen mode.
