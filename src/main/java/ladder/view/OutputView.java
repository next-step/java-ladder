package ladder.view;

import ladder.LadderBridge;
import ladder.LadderGame;
import ladder.LadderLine;
import ladder.Member;
import ladder.dto.LadderConsoleResult;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String BRIDGE_CONSOLE_STRING = "-";
    private static final String EMPTY_BRIDGE_CONSOLE_STRING = " ";
    private static final String POLE_CONSOLE_STRING_DELIMITER = "|";
    private static final String POLE_CONSOLE_STRING_SUFFIX = "|";
    private static final String POLE_CONSOLE_STRING_PREFIX = "     |";
    private static final String MEMBER_NAME_CONSOLE_STRING = "%5s";

    private OutputView() {
    }

    public static void printResult(LadderGame ladderGame) {
        System.out.println("실행결과\n");

        LadderConsoleResult result = LadderConsoleResult.newInstance(ladderGame);

        printMemberNames(result.getMembers());
        printLadder(result.getLadderLines(), result.getMembers().size());
    }

    private static void printMemberNames(List<Member> members) {
        String names = members.stream()
                .map(name -> String.format(MEMBER_NAME_CONSOLE_STRING, name))
                .collect(Collectors.joining(EMPTY_BRIDGE_CONSOLE_STRING));
        System.out.println(names);
    }

    private static void printLadder(List<LadderLine> lines, int memberSize) {
        lines.forEach(line -> printLadderLine(line, memberSize));
    }

    private static void printLadderLine(LadderLine ladderLine, int memberSize) {
        String line = ladderLine.getBridges()
                .stream()
                .map(ladderBridge -> getBridgeString(memberSize, ladderBridge))
                .collect(Collectors.joining(POLE_CONSOLE_STRING_DELIMITER, POLE_CONSOLE_STRING_PREFIX, POLE_CONSOLE_STRING_SUFFIX));
        System.out.println(line);
    }

    private static String getBridgeString(int memberSize, LadderBridge ladderBridge) {
        return Optional.ofNullable(ladderBridge)
                .filter(bridge -> bridge == LadderBridge.EXIST)
                .map(bridge -> getBridgeConsoleStringAsMemberSize(BRIDGE_CONSOLE_STRING, memberSize))
                .orElseGet(() -> getBridgeConsoleStringAsMemberSize(EMPTY_BRIDGE_CONSOLE_STRING, memberSize));
    }

    private static String getBridgeConsoleStringAsMemberSize(String bridgeCharacter, int memberSize) {
        return IntStream.range(0, memberSize)
                .mapToObj(i -> bridgeCharacter)
                .collect(Collectors.joining());
    }
}
