package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LadderInputView {

    public static String inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static int inputHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static List<String> splitInputName(String inputName) throws IllegalArgumentException {
        checkPattern(inputName);
        return Arrays.asList(inputName.split(","));
    }

    public static void checkPattern(String input) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^([a-zA-Z]{1,5},)+[a-zA-Z]{1,5}$");
        Matcher matcher = pattern.matcher(input.trim());
        if (!matcher.find()) {
            throw new IllegalArgumentException("패턴 불일치");
        }
    }
}
