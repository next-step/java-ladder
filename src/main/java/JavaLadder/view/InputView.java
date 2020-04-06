package JavaLadder.view;

import java.util.Scanner;

public class InputView {
    private static final String NAME_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PRIZE_QUESTION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_QUESTION = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_SELECT_QUESTION = "결과를 보고 싶은 사람은?";

    private Scanner scanner;

    public String askName() {
        System.out.println(NAME_QUESTION);
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int askLadderHeight() {
        System.out.println(LADDER_QUESTION);
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String askPrize(){
        System.out.println(PRIZE_QUESTION);
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String askResultByPerson(){
        System.out.println(RESULT_SELECT_QUESTION);
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
