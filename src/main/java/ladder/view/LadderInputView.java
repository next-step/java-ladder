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

    public static String inputResult() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }
  
    public static int inputHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static List<String> splitInputName(String inputName) throws IllegalArgumentException {
        checkNamePattern(inputName);
        return Arrays.asList(inputName.split(","));
    }

    public static void checkNamePattern(String input) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^([a-zA-Z]{1,5},)+[a-zA-Z]{1,5}$");
        Matcher matcher = pattern.matcher(input.trim());
        if (!matcher.find()) {
            throw new IllegalArgumentException("패턴 불일치");
        }
    }

    public static List<String> splitInputResult(String inputResult, int gamerCount) throws IllegalArgumentException {
        checkResultPattern(inputResult);
        List<String> results = Arrays.asList(inputResult.split(","));
        if (results.size() != gamerCount) {
            throw new IllegalArgumentException("결과 갯수 맞지 않음");
        }
        return results;
    }

    private static void checkResultPattern(String input) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^([a-zA-Z가-힣0-9]{1,5},)+[a-zA-Z가-힣0-9]{1,5}$");
        Matcher matcher = pattern.matcher(input.trim());
        if (!matcher.find()) {
            throw new IllegalArgumentException("패턴 불일치");
        }
    }

    public static String inputGamer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
