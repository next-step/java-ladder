package ladder.ui;

import java.util.Scanner;

public class InputView {
    private static final String GET_GAMER_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String GET_HEIGHT_MSG = "최대 사다리 높이는 몇 개 인가요?";
    private static final String GET_RESULT_MSG = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String GET_EXPECT_RESULT_MSG = "결과를 보고 싶은 사람은?";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getGamers() {
        System.out.println(GET_GAMER_MSG);
        return scanner.nextLine();
    }

    public int getHeight() {
        System.out.println(GET_HEIGHT_MSG);
        return Integer.parseInt(scanner.nextLine());
    }

    public String getLadderResults(){
        System.out.println(GET_RESULT_MSG);
        return scanner.nextLine();
    }

    public String getExpectResult(){
        System.out.println(GET_EXPECT_RESULT_MSG);
        return scanner.nextLine();
    }
}
