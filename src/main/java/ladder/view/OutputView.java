package ladder.view;

import java.util.Scanner;
import java.util.function.Function;
import ladder.model.Ladder;
import ladder.model.LadderBridge;
import ladder.model.LadderGame;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.model.LadderGameMemberResult;
import ladder.model.LadderGameResult;
import ladder.model.LadderLine;
import ladder.model.LadderPoleInfo;
import ladder.model.Member;
import ladder.model.Members;
import ladder.model.dto.LadderGameResultDto;

public class OutputView {

    private static final String RESULT_OUTPUT_TEXT = "사다리결과";
    private static final String MEMBER_NAME_DELIMITER = " ";
    private static final String MEMBER_NAME_FORMAT = "%5s";
    private static final String POLE_DELIMITER = "|";
    private static final String POLE_SUFFIX = "|";
    private static final String POLE_PREFIX = "     |";
    private static final String LINE_BRIDGE = "-";
    private static final String EMPTY_BRIDGE = " ";
    private static final String LADDER_GAME_ALL_RESULT_KEYWORD = "all";
    private static final int ZERO = 0;

    private static Scanner scanner = new Scanner(System.in);

    private OutputView() {
    }

    public static void printResult(final LadderGameResultDto result) {
        System.out.println(RESULT_OUTPUT_TEXT);

        List<LadderPoleInfo> ladderPoleInfos = result.getLadderPoleInfos();
        List<LadderLine> ladders = result.getLadderLines();

        printPoleInfo(ladderPoleInfos, LadderPoleInfo::getMemberName);
        printLadder(ladders, ladderPoleInfos.size());
        printPoleInfo(ladderPoleInfos, LadderPoleInfo::getLadderGameReword);
    }

    private static void printPoleInfo(final List<LadderPoleInfo> ladderPoleInfos, Function<LadderPoleInfo, String> poleInfoStringFunction) {
        String poleInfoString = ladderPoleInfos.stream()
            .map(poleInfo -> String.format(MEMBER_NAME_FORMAT, poleInfoStringFunction.apply(poleInfo)))
            .collect(Collectors.joining(MEMBER_NAME_DELIMITER));
        System.out.println(poleInfoString);
    }

    private static void printLadder(final List<LadderLine> lines, final int memberCount) {
        lines.forEach(line -> printLadderLine(line, memberCount));
    }

    private static void printLadderLine(final LadderLine ladderLine, final int memberCount) {
        String line = ladderLine.getBridges()
            .stream()
            .map(ladderBridge -> printBridge(memberCount, ladderBridge))
            .collect(Collectors.joining(POLE_DELIMITER, POLE_PREFIX, POLE_SUFFIX));
        System.out.println(line);
    }

    private static String printBridge(final int memberCount, final LadderBridge ladderBridge) {
        return Optional.ofNullable(ladderBridge)
            .filter(bridge -> bridge == LadderBridge.EXIST)
            .map(bridge -> printBridgeByBridgeCharacter(LINE_BRIDGE, memberCount))
            .orElseGet(() -> printBridgeByBridgeCharacter(EMPTY_BRIDGE, memberCount));
    }

    private static String printBridgeByBridgeCharacter(final String bridgeCharacter, final int memberCount) {
        return IntStream.range(ZERO, memberCount)
            .mapToObj(i -> bridgeCharacter)
            .collect(Collectors.joining());
    }

    public static void printLadderGameResult(final LadderGameMemberResult ladderGameMemberResult) {
        String member = "";
        while (!LADDER_GAME_ALL_RESULT_KEYWORD.equals(member)) {
            System.out.println("\n결과를 보고 싶은 사람은?");
            member = scanner.nextLine();

            System.out.println("\n실행 결과");
            System.out.println(ladderGameMemberResult.get(member));
        }
    }
}
