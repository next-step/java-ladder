package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_SEPARATOR = ",";

    public String[] inputPersonNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine().split(INPUT_SEPARATOR);
    }

    public String[] inputExecutionResults() {
        System.out.println(String.format("%n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"));
        return scanner.nextLine().split(INPUT_SEPARATOR);
    }

    public int inputLadderHeight() {
        System.out.println(String.format("%n최대 사다리 높이는 몇 개 인가요?"));
        return Integer.parseInt(scanner.nextLine());
    }

    public String inputPersonName() {
        System.out.println(String.format("%n결과를 보고 싶은 사람은?"));
        return scanner.nextLine();
    }
}
