package nextstep.ladder.domain.view;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static nextstep.ladder.domain.laddar.LadderGame.DELIMITER_MARK;
import static nextstep.ladder.domain.laddar.LadderGame.DELIMITER_WORD;

public class InputView {
    private static final String INPUT_PLAYERS_MESSAGE = String.format("참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구분하세요)", DELIMITER_WORD);
    private static final String INPUT_ENDPOINTS_MESSAGE = String.format("실행 결과를 입력하세요. (결과는 쉼표(%s)로 구분하세요)", DELIMITER_MARK);
    private static final String MAX_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String WHO_WANT_RESULT = "결과를 보고 싶은 사람은?";

    private static final String SPACE_MARK = " ";
    private static final String BLANK_MARK = "";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String playerNames() {
        ResultView.println(INPUT_PLAYERS_MESSAGE);
        return SCANNER.nextLine().replaceAll(SPACE_MARK, BLANK_MARK);
    }

    public static String endpoints() {
        ResultView.println(INPUT_ENDPOINTS_MESSAGE);
        return SCANNER.nextLine().replaceAll(SPACE_MARK, BLANK_MARK);
    }

    public static int ladderHeight() {
        ResultView.println(MAX_LADDER_HEIGHT_MESSAGE);
        return parseInt(SCANNER.nextLine());
    }

    public static String whoWantsToSeeTheResults() {
        ResultView.println(WHO_WANT_RESULT);
        return SCANNER.nextLine().replaceAll(SPACE_MARK, BLANK_MARK);
    }
}
