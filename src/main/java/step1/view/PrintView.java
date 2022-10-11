package step1.view;

import java.util.List;
import java.util.stream.IntStream;

import step1.dto.BridgeDto;
import step1.dto.LadderResultDto;
import step1.dto.LineDto;

import static java.util.stream.Collectors.joining;

public class PrintView {

    private static final String INIT_JOIN_USER_NAMES_PHRASE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INIT_LADDER_HEIGHT_PHRASE = "최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_RESULT_INTRO_MESSAGE = "실행결과";

    private static final String NAMES_DELIMITER = " ";
    private static final int PRINT_NAME_LENGTH = 5;

    private static final String BAR = "|";
    private static final String BAR_FIRST_DELIMITER = "    ";
    private static final String BAR_DELIMITER = "     ";
    private static final String LADDER_WAY = "-----";

    private PrintView() {
    }

    public static void printInitJoinUserNamesPhrase() {
        System.out.println();
        System.out.println(INIT_JOIN_USER_NAMES_PHRASE);
    }

    public static void printInitLadderHeightPhrase() {
        System.out.println();
        System.out.println(INIT_LADDER_HEIGHT_PHRASE);
    }

    public static void printResult(LadderResultDto ladderResultDto) {
        System.out.println();
        System.out.println(LADDER_RESULT_INTRO_MESSAGE);
        System.out.println();

        List<String> userNames = ladderResultDto.getUserNames();
        printUserNames(userNames);

        List<LineDto> lineDtos = ladderResultDto.getLineDtos();
        IntStream.range(0, ladderResultDto.getHeight()).forEach(h -> DrawOneRowLine(lineDtos, h));
    }

    private static void DrawOneRowLine(List<LineDto> lineDtos, int height) {
        System.out.print(BAR_FIRST_DELIMITER + BAR);

        for (int idx = 1; idx < lineDtos.size(); idx++) {
            drawLadderWay(lineDtos.get(idx), height);
            System.out.print(BAR);
        }

        System.out.println();
    }

    private static void drawLadderWay(LineDto lineDto, int height) {
        BridgeDto targetBridgeDto = lineDto.getBridges().get(height);
        if (targetBridgeDto.isOpen()) {
            System.out.print(LADDER_WAY);
            return;
        }

        System.out.print(BAR_DELIMITER);
    }

    private static void printUserNames(List<String> userNames) {
        String userNamesOneRow = userNames.stream()
            .map(PrintView::toOutputNameFormat)
            .collect(joining(NAMES_DELIMITER));

        System.out.println(userNamesOneRow);
    }

    private static String toOutputNameFormat(String name) {
        return " ".repeat(PRINT_NAME_LENGTH - name.length()) + name;
    }
}

