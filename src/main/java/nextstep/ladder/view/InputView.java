package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    public static final String COMMA = ",";
    private static InputView instance = new InputView();
    private final Scanner scanner = new Scanner(System.in);


    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public String[] askPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playerNameString = scanner.nextLine();
        return playerNameString.split(COMMA);
    }


    public int askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }


    public void closeInputScanner() {
        scanner.close();
    }


}
