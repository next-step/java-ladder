package ladder.view;

import ladder.model.LadderBridge;
import ladder.model.LadderLine;
import ladder.model.Member;
import ladder.model.dto.LadderGameConsoleResult;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String BRIDGE_CONSOLE_STRING = "-";
    private static final String EMPTY_BRIDGE_CONSOLE_STRING = " ";
    private static final String POLE_CONSOLE_DELIMITER_STRING = "|";
    private static final String POLE_CONSOLE_SUFFIX_STRING = "|";
    private static final String POLE_CONSOLE_PREFIX_STRING = "     |";
    private static final String MEMBER_NAME_CONSOLE_DELIMITER_STRING = " ";
    private static final String MEMBER_NAME_CONSOLE_STRING_FORMAT = "%5s";

    private OutputView() {
    }

    public static void printResult(final LadderGameConsoleResult result) {
        System.out.println("실행결과\n");

        List<Member> members = result.getMembers();
        List<LadderLine> ladders = result.getLadderLines();

        printMemberNames(members);
        
        printLadder(ladders, members.size());
    }

    private static void printMemberNames(final List<Member> members) {
        String names = members.stream()
                .map(name -> String.format(MEMBER_NAME_CONSOLE_STRING_FORMAT, name))
                .collect(Collectors.joining(MEMBER_NAME_CONSOLE_DELIMITER_STRING));
        System.out.println(names);
    }

    private static void printLadder(final List<LadderLine> lines, final int memberSize) {
        lines.forEach(line -> printLadderLine(line, memberSize));
    }

    private static void printLadderLine(final LadderLine ladderLine, final int memberSize) {
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
}
