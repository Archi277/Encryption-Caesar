package ua.javarush.basic_functions;

import java.util.List;

public class Encryption {
    private static final int buffSize = 50;

    private static int normalizeKey(int key, List<Character> alphabet) {
        int newKey = Math.abs(key);
        if (newKey > alphabet.size()) return (newKey % alphabet.size());
        else if (newKey == alphabet.size()) return 0;
        else return newKey;
    }

    private static int getNewPosition(int readLetterPosition, int key, EncryptionCommandTypes status, List<Character> alphabet) {

        if (status == EncryptionCommandTypes.ENCRYPT) {
            int newPosition = readLetterPosition + key;
            if (newPosition >= alphabet.size()) return newPosition - alphabet.size();
            return newPosition;
        }
        if (status == EncryptionCommandTypes.DECRYPT) {
            int newPosition = readLetterPosition - key;
            if (newPosition < 0) return alphabet.size() - Math.abs(newPosition);
            return newPosition;
        }
        return readLetterPosition;
    }


    public static String getEncryptOrDecryptText(String text, EncryptionCommandTypes type, int key) {

        List<Character> alphabet = checkAlphabet(text);
        key = normalizeKey(key, alphabet);

        char[] resultArray = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            Character readLetter = text.charAt(i);

            if (alphabet.contains(readLetter)) {

                int readLetterPosition = alphabet.lastIndexOf(readLetter);
                int newLetterPosition = getNewPosition(readLetterPosition, key, type, alphabet);
                resultArray[i] = alphabet.get(newLetterPosition);

            } else resultArray[i] = readLetter;
        }
        return new String(resultArray);
    }

    public static List<Character> checkAlphabet(String text) {

        int size = Math.min(buffSize, text.length());
        int EnglishLetterCounter = 0;
        int UkraineLetterCounter = 0;


        for (int i = 0; i < size; i++) {
            Character readLetter = text.charAt(i);
            if (Constans.ENGLISH_ALPHABET.contains(readLetter)) EnglishLetterCounter++;
            if (Constans.UKRAINE_ALPHABET.contains(readLetter)) UkraineLetterCounter++;

        }
        if (EnglishLetterCounter > UkraineLetterCounter) return Constans.ENGLISH_ALPHABET;
        if (EnglishLetterCounter < UkraineLetterCounter) return Constans.UKRAINE_ALPHABET;
        else return Constans.ENGLISH_ALPHABET;

    }
}