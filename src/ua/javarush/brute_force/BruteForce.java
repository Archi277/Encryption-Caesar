package ua.javarush.brute_force;

import ua.javarush.service.FileService;
import ua.javarush.constans.EncryptionCommandTypes;
import ua.javarush.encryption.Encryption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BruteForce {

    /**
     * Basic Method: Read text from file, analise, find key, decrypt file and write decrypted text in new file.
     * @param pathToFile path to target file
     */
    public static void basicMethod(String pathToFile)  {

        try {
            List<String> textFromFile = new ArrayList<>(Files.readAllLines(Path.of(pathToFile)));
            List<String> textToOutputFile = new ArrayList<>();

            String textToBruteForce = "";
            for (String str: textFromFile) textToBruteForce+=str;

            int key = findKeyByBruteForce(textToBruteForce);

            String suffix = "[DECRYPTED][key "+key+"]";
            String newFileName = FileService.getNewFileName(pathToFile, suffix);

            for (String inputTextLine : textFromFile) textToOutputFile.add(Encryption.getEncryptOrDecryptText(inputTextLine, EncryptionCommandTypes.DECRYPT, key));

            if(key>0) {
                System.out.println("Знайдено key ["  + key+"]. Перевірьте файл");
                System.out.println(Path.of(newFileName));
                FileService.writeNewFile(newFileName,textToOutputFile);

            }else System.out.println("Не вдалося підібрати ключ");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

     /**
     * Method iterated over all keys, one by one and check how many sequence [, ] was found.
     * @param textFromFile text from target file
     * @return key with maximum sequences
     */
    private static int findKeyByBruteForce(String textFromFile){
        int lastNumberOfSequences= 0;
        int numberOfSequences;
        int resultKey = 0;

        List<Character> alphabet = Encryption.checkAlphabet(textFromFile);
        for (int key = 0; key < alphabet.size(); key++) {

            numberOfSequences = findSequence(Encryption.getEncryptOrDecryptText(textFromFile, EncryptionCommandTypes.DECRYPT, key));
            if(  numberOfSequences > lastNumberOfSequences) {
                lastNumberOfSequences = numberOfSequences;
                resultKey = key;
            }
        }
        return resultKey;
    }

    private static int findSequence(String text){
        int  counter = 0;
        for (int i = 0; i < text.length()-1; i++) if(text.charAt(i)==',' && text.charAt(i+1) == ' ') counter++;
        return counter;
    }
}