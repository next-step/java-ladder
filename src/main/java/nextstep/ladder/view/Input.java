package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LineStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {
    private static final String QUESTION_FOR_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String QUESTION_FOR_PRIZES = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String QUESTION_FOR_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String QUESTION_FOR_NAME_TO_SHOW_RESULT = "결과를 보고 싶은 사람은?";
    private static final String DELIMITER = ",";

    public static LadderGame initLadderGame(LineStrategy lineStrategy) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(QUESTION_FOR_NAMES);
        String names = scanner.nextLine();
        System.out.println();

        System.out.println(QUESTION_FOR_PRIZES);
        String prizes = scanner.nextLine();
        System.out.println();

        System.out.println(QUESTION_FOR_HEIGHT);
        int height = scanner.nextInt();
        System.out.println();

        return new LadderGame(height, split(names), split(prizes), lineStrategy);
    }

    private static List<String> split(String string) {
        return Arrays.stream(string.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static String getNameToShowResult() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(QUESTION_FOR_NAME_TO_SHOW_RESULT);
        String nameToShowResult = scanner.nextLine();
        System.out.println();

        return nameToShowResult;
    }
}
