package ladder.view;

import java.util.Scanner;

public class InputView {

    public static String inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String inputLadderGameResult() {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String inputLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String inputShowLadderResult() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String inputDifficulty() {
        System.out.println();
        System.out.println("실행할 사다리의 난이도는?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
