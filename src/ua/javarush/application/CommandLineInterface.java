package ua.javarush.application;

import ua.javarush.constans.Constans;
import ua.javarush.constans.EncryptionCommandTypes;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CommandLineInterface {
    private final Scanner scanner = new Scanner(System.in);
    private int key;
    private String pathToFile;
    private int encryptOption;

    CommandLineInterface() {
        start();
    }

    private void start() {

        System.out.println(Constans.MSG_GREETINGS);
        inputPathToFile();
        inputEncryptOption();
        if(encryptOption != 3)inputKey();
        getNewEncryptedDecryptedFile();

    }

    private void getNewEncryptedDecryptedFile(){

        switch (encryptOption){
            case 1 -> {
                EncryptedDecryptedFile file = new EncryptedDecryptedFile(pathToFile,EncryptionCommandTypes.ENCRYPT, key);
                file.EncryptOrDecryptFile();
            }
            case 2 -> {
                EncryptedDecryptedFile file = new EncryptedDecryptedFile(pathToFile,EncryptionCommandTypes.DECRYPT, key);
                file.EncryptOrDecryptFile();
            }
            case 3 -> {
                EncryptedDecryptedFile file = new EncryptedDecryptedFile(pathToFile);
                file.bruteForcingFile();
            }
        }
    }

    private void inputPathToFile() {
        System.out.println(Constans.MSG_PATH_LABEL);
        pathToFile = scanner.nextLine();
        try {
            while (!Files.exists(Path.of(pathToFile))) {
                System.out.println(Constans.ERROR_FILE_EXIST);
                System.out.println(Constans.MSG_PATH_LABEL_AGAIN);
                pathToFile = scanner.nextLine();

            }
        } catch (Exception e) {
            System.out.println(Constans.ERROR_FILE_EXIST );
            inputPathToFile();
        }
    }

    private void inputEncryptOption() {
        try {
            System.out.println(Constans.MSG_COMMAND);

            encryptOption = Integer.parseInt(scanner.nextLine());

            while (encryptOption != 1 && encryptOption != 2 && encryptOption != 3) {
                System.out.println(Constans.ERROR_OPTION_WRONG);
                encryptOption = Integer.parseInt(scanner.nextLine());
            }

        } catch (NumberFormatException e) {
            System.out.println(Constans.ERROR_NUM_FORMAT);
            inputEncryptOption();
        }

    }

    private void inputKey() {
        System.out.print(Constans.MSG_KEY_LABEL);
        try {
            key = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(Constans.ERROR_NUM_FORMAT);
            inputKey();
        }
    }
}