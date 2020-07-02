package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private String userNames;
    private String ladderHeight;
    private final Scanner sc;

    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개 인가요?";
    private static final String INPUT_USER_NAMES_MESSAGE = "참여한 사람 이름을 입력 하세요. (이름은 쉼표(,)로 구분 하세요.";

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public void inputNames(){
        System.out.println(INPUT_USER_NAMES_MESSAGE);
        userNames = sc.nextLine();

        System.out.println();
    }

    public void inputHeight(){
        System.out.println(INPUT_HEIGHT_MESSAGE);
        ladderHeight = sc.nextLine();
        System.out.println();
    }

    public String getUserNames() {
        return userNames;
    }

    public String getLadderHeight() {
        return ladderHeight;
    }
}
