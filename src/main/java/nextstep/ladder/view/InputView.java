package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private String userNames;
    private String ladderHeight;
    private String result;
    private String resultTarget;
    private final Scanner sc;

    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개 인가요?";
    private static final String INPUT_USER_NAMES_MESSAGE = "참여한 사람 이름을 입력 하세요. (이름은 쉼표(,)로 구분 하세요.";
    private static final String INPUT_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요.";
    private static final String INPUT_RESULT_TARGET_MESSAGE = "결과를 보고 싶은 사람은?";

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public void inputNames(){
        System.out.println(INPUT_USER_NAMES_MESSAGE);
        userNames = sc.nextLine();
        System.out.println();
    }

    public void inputReward(){
        System.out.println(INPUT_RESULT_MESSAGE);
        result = sc.nextLine();
        System.out.println();
    }

    public void inputHeight(){
        System.out.println(INPUT_HEIGHT_MESSAGE);
        ladderHeight = sc.nextLine();
        System.out.println();
    }

    public void inputRewardTarget(){
        System.out.println(INPUT_RESULT_TARGET_MESSAGE);
        resultTarget = sc.nextLine();
        System.out.println();
    }

    public String getUserNames() {
        return userNames;
    }

    public String getLadderHeight() {
        return ladderHeight;
    }

    public String getReward() {
        return result;
    }

    public String getResultTarget() {
        return resultTarget;
    }
}
