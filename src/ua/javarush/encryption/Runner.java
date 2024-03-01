package ua.javarush.encryption;

import ua.javarush.constans.Constans;
import ua.javarush.constans.EncryptionCommandTypes;
import java.nio.file.Files;
import java.nio.file.Path;

public class Runner {
    private int key;

    public void start(String[] args) {
        if (args.length == 0 || args.length == 1) new CommandLineInterface();
        else if (args.length == 2 && args[0].equals(EncryptionCommandTypes.BRUTE_FORCE.toString())) bruteForcingFile(args);
        else if (args.length == 2) System.out.println(Constans.ERROR_MISSED_PARAMETER);
        else if (args.length == 3) {
            if (checkPathToFile(args)) {
                if (checkKey(args)) {
                    checkEncryptionCommandType(args);
                } else System.out.println(Constans.ERROR_UNSUCCESSFULLY);
            }else System.out.println(Constans.ERROR_UNSUCCESSFULLY);
        }
    }

    private void bruteForcingFile(String[] args) {
        checkPathToFile(args);

        EncryptedDecryptedFile file = new EncryptedDecryptedFile(args[1]);
        file.bruteForcingFile();
    }

    private void checkEncryptionCommandType(String[] args) {

        if (args[0].equals(EncryptionCommandTypes.BRUTE_FORCE.toString())) bruteForcingFile(args);

        else if (args[0].equals(EncryptionCommandTypes.ENCRYPT.toString())){
            EncryptedDecryptedFile file = new EncryptedDecryptedFile(args[1],EncryptionCommandTypes.ENCRYPT, key);
            file.encryptOrDecryptFile();
        }
        else if (args[0].equals(EncryptionCommandTypes.DECRYPT.toString())){
            EncryptedDecryptedFile file = new EncryptedDecryptedFile(args[1],EncryptionCommandTypes.DECRYPT, key);
            file.encryptOrDecryptFile();
        }
        else System.out.println(Constans.ERROR_NOT_EXIST_COMMAND);
    }

    private boolean checkKey (String[] args) {
        try {
            key = Integer.parseInt(args[2]);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(Constans.ERROR_NUM_FORMAT);
            return false;
        }
    }

    private boolean checkPathToFile(String[] args) {

        if (!Files.exists(Path.of(args[1]))) {
            System.out.println(Constans.ERROR_FILE_EXIST);
            return false;
        } else return true;
    }
}
