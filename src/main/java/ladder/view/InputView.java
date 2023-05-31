package ladder.view;

import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPLITTER = ",";
    private static final String PARTICIPATION_MENT_INPUT = "참여할 사람 이름을 입력하세요.";
    private static final String EXECUTION_RESULTS_INPUT = "실행 결과를 입력하세요.";
    private static final String MAXIMUM_LADDER_HEIGHT_INPUT = "최대 사다리 높이는 몇 개인가요?";
    public static final String WHO_DO_YOU_WANT_INPUT = "결과를 보고 싶은 사람은?";

    public String[] requestParticipants() {
        System.out.println(PARTICIPATION_MENT_INPUT);
        return SCANNER.next().split(SPLITTER);
    }

    public String[] requestExecutionResults() {
        System.out.println(EXECUTION_RESULTS_INPUT);
        return SCANNER.next().split(SPLITTER);
    }

    public int requestMaximumLadderHeight() {
        System.out.println(MAXIMUM_LADDER_HEIGHT_INPUT);
        return SCANNER.nextInt();
    }

    public static String requestWhoDoYouWant() {
        System.out.println(WHO_DO_YOU_WANT_INPUT);
        return SCANNER.next();
    }
}
