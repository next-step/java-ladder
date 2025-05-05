package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    public static String getNames() {
        System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Integer getHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String getRewards() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String getPlayerName() {
        System.out.println("\n결과를 보고 싶은 사람은?(종료=quit)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
