package ua.javarush.application;

import ua.javarush.brute_force.BruteForce;
import ua.javarush.constans.Constans;
import ua.javarush.constans.EncryptionCommandTypes;
import ua.javarush.service.FileService;

import java.nio.file.Files;
import java.nio.file.Path;

public class Runner {
    private final String[] args;
    private int key;
    private String stringPathToFile;

    Runner(String[] args) {
        this.args = args;
        start(this.args);
    }

    public void start(String[] args) {
        if (args.length == 0 || args.length == 1) new CommandLineInterface();
        else if (args.length == 2 && args[0].equals(EncryptionCommandTypes.BRUTE_FORCE.toString())) bruteForceMode();
        else if (args.length == 2) System.out.println(Constans.ERROR_MISSED_PARAMETER);
        else if (args.length == 3) {
            if (checkStringPath()) {
                if (checkKey()) {
                    checkCommandAndEncryptFile();
                } else System.out.println(Constans.ERROR_UNSUCCESSFULLY);
            }
        }
    }

    private void bruteForceMode() {
        checkStringPath();
        BruteForce.basicMethod(stringPathToFile);

    }

    private void checkCommandAndEncryptFile () {

        if (args[0].equals(EncryptionCommandTypes.BRUTE_FORCE.toString())) bruteForceMode();

        else if (args[0].equals(EncryptionCommandTypes.ENCRYPT.toString())) encryptFile(EncryptionCommandTypes.ENCRYPT);
        else if (args[0].equals(EncryptionCommandTypes.DECRYPT.toString())) encryptFile(EncryptionCommandTypes.DECRYPT);

        else System.out.println(Constans.ERROR_NOT_EXIST_COMMAND);
    }

    private void encryptFile(EncryptionCommandTypes type){
        if (FileService.getNewEncryptedFile(stringPathToFile, type, key)) System.out.println(Constans.MSG_SUCCESSFULLY);
        else System.out.println(Constans.ERROR_UNSUCCESSFULLY);

    }

    private boolean checkKey () {
        try {

            key = Integer.parseInt(args[2]);
            return true;

        } catch (NumberFormatException e) {

            System.out.println(Constans.ERROR_NUM_FORMAT);
            return false;
        }
    }

    private boolean checkStringPath () {

        stringPathToFile = args[1];

        if (!Files.exists(Path.of(stringPathToFile))) {

            System.out.println(Constans.ERROR_FILE_EXIST);
            return false;

        } else return true;
    }
}