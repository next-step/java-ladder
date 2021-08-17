package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String GET_PARTICIPANT_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String GET_LADDER_MAX_LENGTH_QUESTION = "최대 사다리 높이는 몇 개인가요?";
    private static final String GET_RESULTS_QUESTION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String GET_RESULT_QUESTION = "결과를 보고 싶은 사람은?";

    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final String SPLIT_CUSTOM_REGEX = ",|, | ,";


    public static List<String> getParticipant() {
        String trimParticipant = getString(GET_PARTICIPANT_QUESTION);
        return toList(trimParticipant);
    }

    public static List<String> getResults() {
        String trimResults = getString(GET_RESULTS_QUESTION);
        return toList(trimResults);
    }

    private static String getString(String question) {
        System.out.println(question);
        String participantString = scanner.nextLine();
        return participantString.replace(SPACE, BLANK);
    }

    private static List<String> toList(String string) {
        return Arrays.asList(string.split(SPLIT_CUSTOM_REGEX));
    }

    public static int getLadderMaxLength() {
        System.out.println(GET_LADDER_MAX_LENGTH_QUESTION);
        return scanner.nextInt();
    }


    public static String getResult() {
        System.out.println(GET_RESULT_QUESTION);
        return scanner.nextLine();
    }
}
