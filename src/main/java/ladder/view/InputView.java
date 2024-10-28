package ladder.view;

import java.util.Scanner;

public class InputView {
    private final static String PARTICIPANT_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String LADDER_COUNT_QUESTION = "최대 사다리 높이는 몇 개인가요?";
    private final static String LADDER_RESULT_QUESTION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private final static String RESULT_PERSON_SENTENCE = "결과를 보고 싶은 사람은?";

    private final static Scanner SCANNER = new Scanner(System.in);

    public static String participantQuestion() {
        System.out.println(PARTICIPANT_QUESTION);
        return SCANNER.nextLine();
    }

    public static String ladderResultQuestion() {
        System.out.println(LADDER_RESULT_QUESTION);
        return SCANNER.nextLine();
    }

    public static int ladderCountQuestion() {
        System.out.println();
        System.out.println(LADDER_COUNT_QUESTION);
        int count = SCANNER.nextInt();
        SCANNER.nextLine();
        return count;
    }

    public static String getLadderPlayResult() {
        System.out.println();
        System.out.println(RESULT_PERSON_SENTENCE);
        String personName = SCANNER.nextLine();

        if(personName.isBlank()) {
            throw new IllegalArgumentException(RESULT_PERSON_SENTENCE);
        }
        return personName;
    }

}
