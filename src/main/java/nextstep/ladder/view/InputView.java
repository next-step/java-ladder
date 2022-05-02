package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String USER_INPUT_DELIMITER = ",";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] inputPlayersName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playerNamesWithComma = this.inputScannerString();
        System.out.println();
        return splitPlayersNames(playerNamesWithComma);
    }

    private String[] splitPlayersNames(String playerNamesWithComma) {
        return playerNamesWithComma.split(USER_INPUT_DELIMITER);
    }

    public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return inputScannerInt();
    }

    private String inputScannerString() {
        return scanner.nextLine();
    }

    private int inputScannerInt() {
        return scanner.nextInt();
    }

    public String[] inputLaddersResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return inputScannerString().split(USER_INPUT_DELIMITER);
    }

    public String inputWinner() {
        scanner.nextLine();
        System.out.println("결과를 보고 싶은 사람은?");
        return inputScannerString();
    }
}
