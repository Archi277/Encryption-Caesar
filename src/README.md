The basic functionality according to the task has been implemented.

The program accepts three parameters at the input: [1] one of the commands [ENCRYPT, DECRYPT, BRUTE_FORCE] [2] the path to the file that needs to be encrypted/decrypted [3] the key (integer) with which the text needs to be encrypted/decrypted.

If there are no corresponding parameters at the program input, the program starts in CLI mode. - The entered file path is checked. In case of an incorrect path, the program will ask to enter the path again until the existing path is entered.

The program correctly encrypts/decrypts texts with the English/Ukrainian alphabet.

In Brute-Force mode, the program sequentially goes through all possible keys and analyzes the decrypted text.

If it contains the sequence [comma space], then it is considered that the text is decoded correctly.

For greater reliability of the result, the program selects the key in which the largest number of sequences [comma space] is found in the decrypted text.

If the text before encryption did not contain [comma space] sequences, the program will not decrypt it.

If the source text contains short inserts (several words) in another language, they will not be decoded in BruteForce mode.