package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LineStrategy;
import nextstep.ladder.domain.Name;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {
    private static final String QUESTION_FOR_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String QUESTION_FOR_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String DELIMITER = ",";

    public static LadderGame initLadder(LineStrategy lineStrategy) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(QUESTION_FOR_NAME);
        String names = scanner.nextLine();
        System.out.println();

        System.out.println(QUESTION_FOR_HEIGHT);
        int height = scanner.nextInt();
        System.out.println();

        return new LadderGame(height, split(names), lineStrategy);
    }

    private static List<Name> split(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(String::trim)
                .map(Name::new)
                .collect(Collectors.toList());
    }
}
