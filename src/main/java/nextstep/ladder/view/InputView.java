package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    public static final String DELIMITER = ",";
    private Scanner sc;
    private InputValidator inputValidator;

    public InputView() {
        this.sc = new Scanner(System.in);
        this.inputValidator = new InputValidator();
    }

    public String[] inputPlayerName() {
        print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        try {
            String input = input();
            inputValidator.validatePlayerName(input, DELIMITER);
            return input.split(DELIMITER);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPlayerName();
        }
    }

    public int inputHeight() {
        print("최대 사다리 높이는 몇 개인가요?");

        try {
            String input = input();
            inputValidator.validateHeight(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputHeight();
        }
    }

    private void print(String message) {
        System.out.println(message);
    }

    private String input() {
        return sc.nextLine();
    }
}
