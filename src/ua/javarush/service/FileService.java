package ua.javarush.service;

import ua.javarush.constans.Constans;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileService {

    public static String getNewFileName(String oldFileName, String suffix) {
        int dotIndex = oldFileName.lastIndexOf(".");
        return oldFileName.substring(0, dotIndex) + suffix + oldFileName.substring(dotIndex);
    }
    public static List<String> readFile(String stringPath){
        try {
            Path pathToInputFile = Path.of(stringPath);
            if (!Files.exists(pathToInputFile)) throw new FileNotFoundException();
            return Files.readAllLines(pathToInputFile);

        } catch (FileNotFoundException e) {
            System.out.println(Constans.ERROR_FILE_EXIST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static boolean writeNewFile(String stringPath, List<String> outputText) {

        try {
            if (!Files.exists(Path.of(stringPath))) {
                Files.write(Path.of(stringPath), outputText, StandardOpenOption.CREATE_NEW);
            }
            else {
                Files.delete(Path.of(stringPath));
                Files.write(Path.of(stringPath), outputText, StandardOpenOption.CREATE_NEW);
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
