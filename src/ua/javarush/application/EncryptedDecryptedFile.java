package ua.javarush.application;

import ua.javarush.constans.Constans;
import ua.javarush.constans.EncryptionCommandTypes;
import ua.javarush.service.EncryptionService;
import ua.javarush.service.FileService;
import java.util.ArrayList;
import java.util.List;

public class EncryptedDecryptedFile {
    private EncryptionCommandTypes type;
    private int key;
    private final String pathToFile;

    EncryptedDecryptedFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    EncryptedDecryptedFile(String pathToFile, EncryptionCommandTypes type, int key) {
        this.pathToFile = pathToFile;
        this.type = type;
        this.key = key;
    }

    public void EncryptOrDecryptFile() {

        List<String> inputText = FileService.readFile(pathToFile);
        List<String> outputText = new ArrayList<>();
        for (String inputTextLine : inputText) outputText.add(EncryptionService.getEncryptedOrDecryptedText(inputTextLine, type, key));

        if (type == EncryptionCommandTypes.ENCRYPT)
            if(FileService.writeNewFile((FileService.getNewFileName(pathToFile, "[ENCRYPTED]")), outputText)){
                System.out.println(Constans.MSG_SUCCESSFULLY);
            }else System.out.println(Constans.ERROR_UNSUCCESSFULLY);

        if (type == EncryptionCommandTypes.DECRYPT)
            if(FileService.writeNewFile((FileService.getNewFileName(pathToFile, "[DECRYPTED]")), outputText)){
                System.out.println(Constans.MSG_SUCCESSFULLY);
            }else System.out.println(Constans.ERROR_UNSUCCESSFULLY);
    }

    public void bruteForcingFile (){

        List<String> inputText = FileService.readFile(pathToFile);
        List<String> outputText = new ArrayList<>();

        int numOfStringForCheckingKey = Math.min(50, inputText.size());
        String textToBruteForce = "";
        for (int i = 0; i < numOfStringForCheckingKey; i++) textToBruteForce+=inputText.get(i);

        key = EncryptionService.findKeyByBruteForce(textToBruteForce);

        for (String inputTextLine : inputText) outputText.add(EncryptionService.getEncryptedOrDecryptedText(inputTextLine, EncryptionCommandTypes.DECRYPT, key));
        if(FileService.writeNewFile((FileService.getNewFileName(pathToFile, "[DECRYPTED][key  " + key+ "]")), outputText)) {
            System.out.println(Constans.MSG_SUCCESSFULLY);
        }else System.out.println(Constans.ERROR_UNSUCCESSFULLY);
    }
}
