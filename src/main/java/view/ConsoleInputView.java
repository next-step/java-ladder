package view;

import util.StringParser;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> inputUserNames() {
        System.out.println("참여할 사람의 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return StringParser.split(scanner.nextLine());
    }

    public static List<String> inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");

        return StringParser.split(scanner.nextLine());
    }

    public static Integer inputLadderHeight() {
        System.out.println("최대 사라리 높이는 몇 개인가요?");

        Integer height = scanner.nextInt();
        scanner.nextLine();

        return height;
    }

    public static String inputLadderDifficulty() {
        System.out.println("실행할 사다리 난이도는?");

        return scanner.nextLine();
    }

    public static String inputNameForResult() {
        System.out.println("결과를 보고 싶은 사람은?");

        return scanner.nextLine();
    }
}
