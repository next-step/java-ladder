package ladder.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final String COMMA =",";
    public static String setNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean lengthValidate(String name) {
        if(name.length() > 5)
            throw new IllegalArgumentException("사람에 이름을 최대5글자까지 부여할 수 있습니다");
        return true;
    }

    public static String[] splitString(String input){
        return input.split(COMMA);
    }

    public static String[] trimString(String[] input){
        return Arrays.stream(input).map(String::trim).toArray(String[]::new);
    }

    public static String[] enterPlayers() {
        return trimString(splitString(setNames()));
    }

    public static int enterHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
