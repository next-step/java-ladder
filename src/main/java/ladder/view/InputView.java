package ladder.view;

import java.util.Scanner;

public class InputView {

    public static String getUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return getString();
    }

    public static String getResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return getString();
    }

    public static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return getNumber();
    }

    public static String getTarget() {
        System.out.println("결과를 보고 싶은 사람은?");
        return getString();
    }

    private static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
