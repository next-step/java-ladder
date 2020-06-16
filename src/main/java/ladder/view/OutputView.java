package ladder.view;

import ladder.model.Ladder;
import ladder.model.LadderBridge;
import ladder.model.LadderGame;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.model.LadderLine;
import ladder.model.Member;
import ladder.model.Members;

public class OutputView {

    private static final String MEMBER_NAME_DELIMITER = " ";
    private static final String MEMBER_NAME_FORMAT = "%5s";
    private static final String POLE_DELIMITER = "|";
    private static final String POLE_SUFFIX = "|";
    private static final String POLE_PREFIX = "     |";
    private static final String LINE_BRIDGE = "-";
    private static final String EMPTY_BRIDGE = " ";
    private static final int ZERO = 0;

    private OutputView() {
    }

    public static void printResult(final LadderGame ladderGame) {
        System.out.println("실행결과");

        Members members = ladderGame.getMembers();
        Ladder ladder = ladderGame.getLadder();

        printMemberNames(members.getMembers());
        printLadder(ladder.getLines(), members.count());
    }

    private static void printMemberNames(final List<Member> members) {
        String names = members.stream()
            .map(name -> String.format(MEMBER_NAME_FORMAT, name))
            .collect(Collectors.joining(MEMBER_NAME_DELIMITER));
        System.out.println(names);
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
}
