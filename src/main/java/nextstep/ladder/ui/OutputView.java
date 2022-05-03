package nextstep.ladder.ui;

import nextstep.ladder.domain.*;

import java.util.List;

public class OutputView {

    public static final String PARTICIPANT_PRINT_FORMAT = "%-6s";
    public static final String PRIZE_PRINT_FORMAT = "%-6s";
    public static final String BRIDGE = "|-----";
    public static final String EMPTY_BRIDGE = "|     ";

    private OutputView() {
        throw new UnsupportedOperationException();
    }

    public static void printParticipants(Participants participants) {
        participants.getParticipants()
                .forEach(participant -> System.out.printf(PARTICIPANT_PRINT_FORMAT, participant.getName()));
        System.out.println();
    }

    public static void printLines(Ladder ladder) {
        ladder.getLines()
                .forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        List<Boolean> bridges = line.getBridges();
        for (boolean bridge : bridges) {
            System.out.print(mapBridgeToString(bridge));
        }
        System.out.println();
    }

    private static String mapBridgeToString(boolean bridge) {
        if (bridge) {
            return BRIDGE;
        }
        return EMPTY_BRIDGE;
    }

    public static void printPrizes(Prizes prizes) {
        prizes.getPrizes()
                .forEach(prize -> System.out.printf(PRIZE_PRINT_FORMAT, prize.getPrize()));
        System.out.println();
    }

    public static void printResult(LadderGameResult result, String name) {
        if (name.equals("all")) {
            result.getResult()
                    .forEach(((participant, prize) -> printResult(participant.getName(), prize.getPrize())));
            return;
        }
        printResult(name, result.findPrizeByName(name));
    }

    private static void printResult(String name, String prize) {
        System.out.println(name + " : " + prize);
    }
}
