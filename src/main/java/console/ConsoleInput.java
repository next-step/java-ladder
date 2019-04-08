package console;

import domain.DifficultyLevel;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInput {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> enterUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());
    }

    public static List<String> enterResults() {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        return Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());
    }

    public static int enterHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return scanner.nextInt();
    }

    public static DifficultyLevel enterDifficultyLevel() {
        System.out.println();
        System.out.println("실행할 사다리의 난이도는?");

        return DifficultyLevel.valueFrom(scanner.next());
    }

    public static String enterUserWantResult() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");

        return scanner.next();
    }
}
