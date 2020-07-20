package view;

import domain.LadderLevel;
import domain.Players;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Players inputPersonNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return Players.of(scanner.nextLine().split(","));
    }

    public static String[] inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        return scanner.nextLine().split(",");
    }

    public static LadderLevel inputLadderLevel() {
        System.out.println("실행할 사디리의 난이도는?");

        return LadderLevel.of(scanner.next());
    }

    public static String inputWho() {
        System.out.println("결과를 보고 싶은 사람은?");

        return scanner.next();
    }
}
