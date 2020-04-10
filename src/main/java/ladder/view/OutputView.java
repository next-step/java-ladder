package ladder.view;

import ladder.model.LadderBridge;
import ladder.model.LadderLineOld;
import ladder.model.dto.LadderGameConsoleResult;
import ladder.model.dto.LadderGameMemberResult;
import ladder.model.dto.LadderPoleInfo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String BRIDGE_CONSOLE_STRING = "-";
    private static final String EMPTY_BRIDGE_CONSOLE_STRING = " ";
    private static final String POLE_CONSOLE_DELIMITER_STRING = "|";
    private static final String POLE_CONSOLE_SUFFIX_STRING = "|";
    private static final String POLE_CONSOLE_PREFIX_STRING = "     |";
    private static final String POLE_INFO_CONSOLE_DELIMITER_STRING = " ";
    private static final String POLE_INFO_CONSOLE_STRING_FORMAT = "%5s";
    private static final String LADDER_GAME_ALL_RESULT_KEYWORD = "all";

    private static Scanner scanner = new Scanner(System.in);

    private OutputView() {
    }

    public static void printLadderResult(final LadderGameConsoleResult result) {
        System.out.println("사다리 결과\n");

        List<LadderPoleInfo> ladderPoleInfos = result.getLadderPoleInfos();
        List<LadderLineOld> ladders = result.getLadderLines();

        printPoleInfo(ladderPoleInfos, LadderPoleInfo::getMemberName);
        printLadder(ladders, ladderPoleInfos.size());
        printPoleInfo(ladderPoleInfos, LadderPoleInfo::getLadderGameReword);
    }

    private static void printPoleInfo(final List<LadderPoleInfo> ladderPoleInfos, Function<LadderPoleInfo, String> poleInfoStringFunction) {
        String poleInfoString = ladderPoleInfos.stream()
                .map(poleInfo -> String.format(POLE_INFO_CONSOLE_STRING_FORMAT, poleInfoStringFunction.apply(poleInfo)))
                .collect(Collectors.joining(POLE_INFO_CONSOLE_DELIMITER_STRING));
        System.out.println(poleInfoString);
    }

    private static void printLadder(final List<LadderLineOld> lines, final int memberSize) {
        lines.forEach(line -> printLadderLine(line, memberSize));
    }

    private static void printLadderLine(final LadderLineOld ladderLine, final int memberSize) {
        String line = ladderLine.getBridges()
                .stream()
                .map(ladderBridge -> getBridgeString(memberSize, ladderBridge))
                .collect(Collectors.joining(POLE_CONSOLE_DELIMITER_STRING, POLE_CONSOLE_PREFIX_STRING, POLE_CONSOLE_SUFFIX_STRING));
        System.out.println(line);
    }

    private static String getBridgeString(final int memberSize, final LadderBridge ladderBridge) {
        return Optional.ofNullable(ladderBridge)
                .filter(bridge -> bridge == LadderBridge.EXIST)
                .map(bridge -> getBridgeConsoleStringAsMemberSize(BRIDGE_CONSOLE_STRING, memberSize))
                .orElseGet(() -> getBridgeConsoleStringAsMemberSize(EMPTY_BRIDGE_CONSOLE_STRING, memberSize));
    }

    private static String getBridgeConsoleStringAsMemberSize(final String bridgeCharacter, final int memberSize) {
        return IntStream.range(0, memberSize)
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
