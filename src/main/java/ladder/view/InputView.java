package ladder.view;

import ladder.domain.LadderGame;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputText = scanner.next();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        LadderGame ladderGame = new LadderGame(height, inputText);

        System.out.println("실행결과");
        System.out.println(ladderGame);
    }
}