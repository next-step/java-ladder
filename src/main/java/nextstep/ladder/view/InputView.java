package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);

    public static final String INPUT_PEOPLE_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_LADDER_HIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    public static final String RESULT_MESSAGE = "실행결과";

    public static void printPeopleName(){
        System.out.println(INPUT_PEOPLE_NAME_MESSAGE);
    }

    public static void printLadderHeight(){
        System.out.println(INPUT_LADDER_HIGHT_MESSAGE);
    }

    public static void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }
}
