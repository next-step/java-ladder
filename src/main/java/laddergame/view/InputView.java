package laddergame.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String[] askPersonNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String nextLine = SCANNER.nextLine();
        return nextLine.split(",");
    }

    public static int askMaxCountOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int count = SCANNER.nextInt();
        validateCount(count);
        return count;
    }

    private static void validateCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("1 이상의 수만 입력할 수 있습니다.");
        }
    }

    public static String askPersonNameWantToKnowResult(){
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }

    public static String[] askRewards(){
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String nextLine = SCANNER.nextLine();
        return nextLine.split(",");
    }

}
