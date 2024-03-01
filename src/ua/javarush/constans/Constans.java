package ua.javarush.constans;

import java.util.Arrays;
import java.util.List;

public class Constans {

    public static final String ERROR_NUM_FORMAT         = "The entered number must be an integer. Try again:";
    public static final String ERROR_MISSED_PARAMETER   = "You did not enter the third parameter key";
    public static final String ERROR_UNSUCCESSFULLY     = "Unsuccessfully";
    public static final String ERROR_OPTION_WRONG       = "You must enter [1] or [2] or [3]. Try again";
    public static final String ERROR_FILE_EXIST         = "The specified file was not found. Check the file path";
    public static final String ERROR_NOT_EXIST_COMMAND  = "A non-existent command was entered";

    public static final String MSG_SUCCESSFULLY         = "Successfully";
    public static final String MSG_GREETINGS            = "This program will help you encrypt/decrypt text files.";
    public static final String MSG_PATH_LABEL           = "Enter the path to the file to be encrypted/decrypted:";
    public static final String MSG_COMMAND              = "Press \t1: to encrypt the file\r\n\t\t2: To decrypt the file\r\n\t\t3: BRUTE-FORCE";
    public static final String MSG_KEY_LABEL            = "Enter the key with which you want to encrypt/decrypt the file. Whole number: ";
    public static final String MSG_PATH_LABEL_AGAIN     = "Enter the file path again:";

    public static final List<Character> ENGLISH_ALPHABET = Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '.', ',', '«', '»', '\"', '\'', ':', '!', '?', ' ');
    public static final List<Character> UKRAINE_ALPHABET = Arrays.asList(
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я',
            'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я',
            '.', ',', '«', '»', '\"', '\'', ':', '!', '?', ' ');
    public static final List<List<Character>> listOfAlphabet = Arrays.asList(ENGLISH_ALPHABET, UKRAINE_ALPHABET);
    public static final List<Character> alphabetByDefault = ENGLISH_ALPHABET;
}
