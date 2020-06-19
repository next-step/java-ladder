package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String enterNameOfPerson() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String nameOfPerson = SCANNER.nextLine();
        return nameOfPerson;
    }

    public static String enterResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String results = SCANNER.nextLine();
        return results;
    }

    public static int enterLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = SCANNER.nextInt();
        SCANNER.nextLine();
        return ladderHeight;
    }


    public static String enterCuriousResult() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        String name = SCANNER.nextLine();
        return name;
    }
}
