package nextstep.ladder.view;

import nextstep.ladder.domain.MaxHeightOfLadder;
import nextstep.ladder.domain.member.Members;
import nextstep.ladder.domain.runresult.RunResults;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_RUN_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_MEMBER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAX_HEIGHT_OF_LADDER_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String ANYONE_WHO_WANTS_TO_SEE_RESULTS_MESSAGE = "결과를 보고 싶은 사람은?";

    public static Members inputMemberNames() {
        println(INPUT_MEMBER_NAMES_MESSAGE);

        try {
            String userNames = SCANNER.nextLine();
            return new Members(userNames);
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
        }

        return inputMemberNames();
    }

    public static MaxHeightOfLadder inputMaxHeightOfLadder() {
        println(INPUT_MAX_HEIGHT_OF_LADDER_MESSAGE);

        try {
            String string = SCANNER.nextLine();
            return new MaxHeightOfLadder(string);
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
        }

        return inputMaxHeightOfLadder();
    }

    public static RunResults inputRunResults() {
        println(INPUT_RUN_RESULTS);

        try {
            String string = SCANNER.nextLine();
            return new RunResults(string);
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
        }

        return inputRunResults();
    }

    public static String inputName() {
        println(ANYONE_WHO_WANTS_TO_SEE_RESULTS_MESSAGE);

        try {
            return SCANNER.nextLine();
        } catch (IllegalArgumentException e){
            println(e.getMessage());
        }

        return inputName();
    }

    private static void println(String e) {
        System.out.println(e);
    }
}
