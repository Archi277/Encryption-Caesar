package ua.javarush.service;

import ua.javarush.constans.Constans;
import ua.javarush.constans.EncryptionCommandTypes;
import java.util.List;

public class EncryptionService {
    private static final int MIN_TEXT_LENGTH_GOT_CHECK_ALPHABET = 50;

    public static String getEncryptedOrDecryptedText(String text, EncryptionCommandTypes type, int key) {

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

    /**
     * Reading letter by letter from string, and counting
     * number of letter from alphabet.If number of letter more than half of string
     * deciding that  all string written on this alphabet
     * @param text input string for checking alphabet
     * @return alphabet from class Constant
     */
    public static List<Character> checkAlphabet(String text) {

        int textLengthForChecking = Math.min(MIN_TEXT_LENGTH_GOT_CHECK_ALPHABET, text.length());

        for(List<Character> alphabet : Constans.listOfAlphabet) {
            int letterCounter = 0;
            for (int i = 0; i < textLengthForChecking; i++) {
                Character readLetter = text.charAt(i);
                if (alphabet.contains(readLetter)) letterCounter++;
                if(letterCounter >= textLengthForChecking/2) return alphabet;
            }
        }
        return  Constans.alphabetByDefault;
    }

    /**
     * Method iterated over all keys, one by one and check how many sequence [, ] was found.
     * @param textFromFile text from target file
     * @return key with maximum sequences
     */
    public static int findKeyByBruteForce(String textFromFile){
        int lastNumberOfSequences= 0;
        int numberOfSequences;
        int resultKey = 0;

        List<Character> alphabet = EncryptionService.checkAlphabet(textFromFile);
        for (int key = 0; key < alphabet.size(); key++) {

            numberOfSequences = findSequence(getEncryptedOrDecryptedText(textFromFile, EncryptionCommandTypes.DECRYPT, key));
            if(  numberOfSequences > lastNumberOfSequences) {
                lastNumberOfSequences = numberOfSequences;
                resultKey = key;
            }
        }
        return resultKey;
    }

    private static int findSequence(String text){
        int  counter = 0;
        for (int i = 0; i < text.length()-1; i++){
            if(text.charAt(i)==',' && text.charAt(i+1) == ' ') counter++;
        }
        return counter;
    }

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
}
