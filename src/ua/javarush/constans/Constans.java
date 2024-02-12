package ua.javarush.constans;

import java.util.Arrays;
import java.util.List;

public class Constans {
    public static final String ERROR_NUM_FORMAT         = "Введене число має бути цiлим. Спробуйте ще раз: ";
    public static final String ERROR_MISSED_PARAMETER   = "Ви не ввели третiй параметр ключ";
    public static final String ERROR_UNSUCCESSFULLY     = "Unsuccessfully";
    public static final String ERROR_OPTION_WRONG       = "Потрiбно ввести [1] або [2] або [3]. Спробуйте ще раз";
    public static final String ERROR_MSG                = "Нажаль сталася помилка. Спробуйте перезапустити програму";
    public static final String ERROR_FILE_EXIST         = "Вказаний файл не знайдено.Перевiрте  шлях до файлу ";
    public static final String ERROR_NOT_EXIST_COMMAND  = "Введена неiснуюча команда ";


    public static final String MSG_SUCCESSFULLY         = "Successfully";
    public static final String MSG_GREETINGS            = "Ця програма допоможе Вам зашифровувати/розшифрувати текстовi файли.";
    public static final String MSG_PATH_LABEL           = "Введiть шлях до файлу який потрібно зашифровувати/розшифрувати:";
    public static final String MSG_COMMAND              = "Натиснiть 1: щоб зашифрувати файл\r\n\t\t  2: щоб розшифрувати файл\r\n\t\t  3: BRUTE-FORCE";
    public static final String MSG_KEY_LABEL            = "Введiть ключ яким Ви хочете зашифровувати/розшифрувати файл. Цiле цисло: ";
    public static final String MSG_PATH_LABEL_AGAIN     = "Введiть шлях до файлу ще раз:";
    public static final String MSG_FILE_OK              = "Файл успiшно опрацьовано.";


    public static final List<Character> ENGLISH_ALPHABET = Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '.', ',', '«', '»', '\"', '\'', ':', '!', '?', ' ');


    public static final List<Character> UKRAINE_ALPHABET = Arrays.asList(
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я',
            'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я',
            '.', ',', '«', '»', '\"', '\'', ':', '!', '?', ' ');

}