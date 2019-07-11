package nextstep.ladder;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String[] getUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputUserNames = scanner.nextLine();
        return StringUtil.splitBySeparator(",", inputUserNames);
    }

    public static int getMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxHeight = scanner.nextInt();
        scanner.nextLine();
        return maxHeight;
    }

    public static String[] getResults(int expectedLength) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n");
        String inputResult = scanner.nextLine();
        String[] results = StringUtil.splitBySeparator(",", inputResult);
        if (results.length != expectedLength) {
            throw new IllegalArgumentException("참여자 수와 결과 수는 일치해야합니다.");
        }
        return results;
    }

    public static String getInputResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

}
