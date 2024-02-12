package ua.javarush.application;

import ua.javarush.constans.Constans;
import ua.javarush.constans.EncryptionCommandTypes;
import java.nio.file.Files;
import java.nio.file.Path;

public class Runner {
    private final String[] args;
    private int key;

    Runner(String[] args) {
        this.args = args;
        start(this.args);
    }
    public static void main(String[] args)  {
        new Runner(args);
    }
    public void start(String[] args) {
        if (args.length == 0 || args.length == 1) new CommandLineInterface();
        else if (args.length == 2 && args[0].equals(EncryptionCommandTypes.BRUTE_FORCE.toString())) bruteForceMode();
        else if (args.length == 2) System.out.println(Constans.ERROR_MISSED_PARAMETER);
        else if (args.length == 3) {
            if (checkPathToFile()) {
                if (checkKey()) {
                    checkEncryptionCommandType();
                } else System.out.println(Constans.ERROR_UNSUCCESSFULLY);
            }
        }
    }

    private void bruteForceMode() {
        checkPathToFile();
        EncryptedDecryptedFile file = new EncryptedDecryptedFile(args[1]);
        file.bruteForcingFile();
    }

    private void checkEncryptionCommandType() {

        if (args[0].equals(EncryptionCommandTypes.BRUTE_FORCE.toString())) bruteForceMode();

        else if (args[0].equals(EncryptionCommandTypes.ENCRYPT.toString())){
            EncryptedDecryptedFile file = new EncryptedDecryptedFile(args[1],EncryptionCommandTypes.ENCRYPT, key);
            file.EncryptOrDecryptFile();
        }
        else if (args[0].equals(EncryptionCommandTypes.DECRYPT.toString())){
            EncryptedDecryptedFile file = new EncryptedDecryptedFile(args[1],EncryptionCommandTypes.DECRYPT, key);
            file.EncryptOrDecryptFile();
        }
        else System.out.println(Constans.ERROR_NOT_EXIST_COMMAND);
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

    private boolean checkPathToFile() {

        if (!Files.exists(Path.of(args[1]))) {
            System.out.println(Constans.ERROR_FILE_EXIST);
            return false;
        } else return true;
    }
}