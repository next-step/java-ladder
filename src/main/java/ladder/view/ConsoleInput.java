package ladder.view;

import java.util.Scanner;

public class ConsoleInput {

    public static String readPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static String readRewards() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static String readLadderDifficulty() {
        System.out.println("실행할 사다리의 난이도는? (상, 중, 하 선택)");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static String readNameForRewards() {
        System.out.println();
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
