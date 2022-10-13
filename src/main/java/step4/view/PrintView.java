package step4.view;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import step4.dto.LadderGameResultDto;
import step4.dto.BridgeDto;
import step4.dto.LadderGameDto;
import step4.dto.LineDto;

import static java.util.stream.Collectors.joining;

public class PrintView {

    private static final String INIT_JOIN_USER_NAMES_PHRASE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INIT_LADDER_GOALS_PHRASE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INIT_LADDER_HEIGHT_PHRASE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INIT_LADDER_GAME_RESULT_PHRASE = "결과를 보고 싶은 사람은?";
    private static final String RESULT_LADDER_INTRO_MESSAGE = "사다리 결과";
    private static final String RESULT_GAME_INTRO_MESSAGE = "실행 결과";

    private static final String NAMES_DELIMITER = " ";
    private static final String PRIZES_DELIMITER = " ";
    private static final int USER_NAME_LENGTH = 5;
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

    public static void INIT_LADDER_GOALS_PHRASE() {
        System.out.println();
        System.out.println(INIT_LADDER_GOALS_PHRASE);
    }

    public static void printInitLadderHeightPhrase() {
        System.out.println();
        System.out.println(INIT_LADDER_HEIGHT_PHRASE);
    }

    public static void printInitLadderGameResultPhrase() {
        System.out.println();
        System.out.println(INIT_LADDER_GAME_RESULT_PHRASE);
    }

    public static void printLadderGameResult(LadderGameResultDto ladderGameResultMap, String userName) {
        System.out.println();
        System.out.println(RESULT_GAME_INTRO_MESSAGE);

        Map<String, String> ladderGameResult = ladderGameResultMap.getLadderGameResult();

        if (userName.equals("all")) {
            ladderGameResult.keySet()
                .stream().map(key -> key + " : " + ladderGameResult.get(key))
                .forEach(System.out::println);
            return;
        }

        System.out.println(ladderGameResult.get(userName));
    }

    public static void printLadderGame(LadderGameDto ladderGameDto) {
        System.out.println();
        System.out.println(RESULT_LADDER_INTRO_MESSAGE);
        System.out.println();

        printUserNames(ladderGameDto.getUserNames());

        List<LineDto> lineDtos = ladderGameDto.getLineDtos();
        IntStream.range(0, ladderGameDto.getHeight()).forEach(h -> DrawOneRowLine(lineDtos, h));

        printPrizes(ladderGameDto.getPrizes());
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
        return " ".repeat(USER_NAME_LENGTH - name.length()) + name;
    }

    private static void printPrizes(List<String> prizes) {
        String prizeOneRow = prizes.stream()
            .map(PrintView::toOutputPrizeFormat)
            .collect(joining(PRIZES_DELIMITER));

        System.out.println(prizeOneRow);
    }
    private static String toOutputPrizeFormat(String prize) {
        return " ".repeat(PRINT_NAME_LENGTH - prize.length()) + prize;
    }
}

