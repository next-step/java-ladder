package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    public static final String DELIMITER = ",";
    private final Scanner sc;
    private final InputValidator inputValidator;

    public InputView() {
        this.sc = new Scanner(System.in);
        this.inputValidator = new InputValidator();
    }

    public String[] inputPlayerName() {
        println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        try {
            String input = input();
            inputValidator.validatePlayerName(input, DELIMITER);
            return input.split(DELIMITER);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPlayerName();
        }
    }

    public String[] inputPrize(int numOfPlayers) {
        println("");
        println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        try {
            String input = input();
            inputValidator.validatePrizes(input, DELIMITER, numOfPlayers);
            return input.split(DELIMITER);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPrize(numOfPlayers);
        }
    }

    public int inputHeight() {
        println("");
        println("최대 사다리 높이는 몇 개인가요?");

        try {
            String input = input();
            inputValidator.validateHeight(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputHeight();
        }
    }

    public String inputName() {
        println("");
        println("결과를 보고 싶은 사람은?");

        try {
            return input();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputName();
        }
    }

    private void println(String message) {
        System.out.println(message);
    }

    private String input() {
        return sc.nextLine();
    }
}
