package ua.javarush.basic_functions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CommandLineInterface {
    private final Scanner scanner = new Scanner(System.in);
    private int key;
    private String stringPath;
    private EncryptionCommandTypes typeEncryption;

    CommandLineInterface() {
        start();
    }

    private void start() {

        System.out.println(Constans.MSG_GREETINGS);
        inputPath();
        if(inputEncryptOption() !=3) {
            inputKey();
            getNewEncryptedFile();
        }
    }

    private void getNewEncryptedFile(){
        if (FileService.getNewEncryptedFile(stringPath, typeEncryption, key)) System.out.println(Constans.MSG_FILE_OK);
        else System.out.println(Constans.ERROR_MSG);
    }

    private void inputPath() {
        System.out.println(Constans.MSG_PATH_LABEL);
        stringPath = scanner.nextLine();
        try {
            while (!Files.exists(Path.of(stringPath))) {
                System.out.println(Constans.ERROR_FILE_EXIST);
                System.out.println(Constans.MSG_PATH_LABEL_AGAIN);
                stringPath = scanner.nextLine();

            }
        } catch (Exception e) {
            System.out.println(Constans.ERROR_FILE_EXIST );
            inputPath();
        }
    }

    private int inputEncryptOption() {
        try {
            System.out.println(Constans.MSG_COMMAND);

            int encryptOption = Integer.parseInt(scanner.nextLine());

            while (encryptOption != 1 && encryptOption != 2 && encryptOption != 3) {
                System.out.println(Constans.ERROR_OPTION_WRONG);
                encryptOption = Integer.parseInt(scanner.nextLine());
            }

            if (encryptOption == 1) typeEncryption = EncryptionCommandTypes.ENCRYPT;
            if (encryptOption == 2) typeEncryption = EncryptionCommandTypes.DECRYPT;
            if (encryptOption == 3) BruteForce.basicMethod(stringPath);

            return encryptOption;
        } catch (NumberFormatException e) {
            System.out.println(Constans.ERROR_NUM_FORMAT);
            inputEncryptOption();
        }
        return 0;
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