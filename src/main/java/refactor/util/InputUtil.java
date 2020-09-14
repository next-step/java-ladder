package refactor.util;

import java.util.Scanner;

public class InputUtil {

    public static Scanner scanner = new Scanner(System.in);

    private InputUtil() {}

    public static String returnString(String question) {
        System.out.println(question);
        return returnStringWithBlank();
    }

    public static String returnStringWithBlank() {
        return scanner.nextLine();
    }

    public static int returnInteger(String question) {
        System.out.println(question);
        int result = scanner.nextInt();
        scanner.nextLine(); //개행문자(엔터)를 제거하기위해 추가
        return result;
    }
}
