package ladder.view;

import java.util.List;
import java.util.Map;

import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.Participant;
import ladder.model.Participants;
import ladder.model.Point;
import ladder.model.Result;
import ladder.model.Reward;
import ladder.model.Rewards;

public final class OutputView {
    private static final String MARK_OF_POINT = "|";
    private static final String MARK_OF_EMPTY_LINE = " ";
    private static final String MARK_OF_CONNECTED_LINE = "-";
    private static final String FORMAT_OF_NAME = "%6s";
    public static final String EXPRESSION_OF_ALL = "all";
    public static final String MESSAGE_OF_RESULT = "실행 결과";

    public static void printLadderWithInformation(Participants participants, Rewards rewards, Ladder ladder) {
        System.out.println("사다리 결과\n");
        printParticipants(participants);
        printReturnLine();
        printLadder(ladder);
        printRewards(rewards);
        printReturnLine();
        printReturnLine();
    }

    public static boolean printResult(Result result, String nameOfParticipant) {
        System.out.println(MESSAGE_OF_RESULT);
        if (nameOfParticipant.equals(EXPRESSION_OF_ALL)) {
            printAllResult(result);
            return true;
        }
        printOneResult(result, nameOfParticipant);
        return false;
    }

    private static void printOneResult(Result result, String nameOfParticipant) {
        final Participant participant = result.getParticipant(nameOfParticipant);
        final Reward reward = result.getReward(participant);

        System.out.println(participant.getName() + " : " + reward.getReward());
        printReturnLine();
    }

    private static void printAllResult(Result result) {
        final Map<Participant, Reward> allResult = result.getAllResult();
        allResult.forEach((key, value) -> System.out.println(key.getName() + " : " + value.getReward()));
        printReturnLine();
    }

    private OutputView() {}

    private static void printParticipants(Participants participants) {
        participants.getParticipants()
                    .stream()
                    .map(Participant::getName)
                    .forEach(OutputView::printStringWithFormat);
    }

    private static void printRewards(Rewards rewards) {
        rewards.getRewards()
               .stream()
               .map(Reward::getReward)
               .forEach(OutputView::printStringWithFormat);
    }

    private static void printLadder(Ladder ladder) {
        final List<Line> lines = ladder.getLines();
        lines.forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        printWhiteSpace();
        final List<Point> points = line.getPoints();

        points.forEach(OutputView::printPoint);
        printReturnLine();
    }

    private static void printWhiteSpace() {
        for (int i = 0; i < Participant.MAX_LENGTH; i++) {
            System.out.print(MARK_OF_EMPTY_LINE);
        }
    }

    private static void printPoint(Point point) {
        if (point.isConnectedRight()) {
            printConnectedPoint();
            return;
        }
        printUnconnectedPoint();
    }

    private static void printUnconnectedPoint() {
        System.out.print(MARK_OF_POINT);
        for (int i = 0; i < Participant.MAX_LENGTH; i++) {
            System.out.print(MARK_OF_EMPTY_LINE);
        }
    }

    private static void printConnectedPoint() {
        System.out.print(MARK_OF_POINT);
        for (int i = 0; i < Participant.MAX_LENGTH; i++) {
            System.out.print(MARK_OF_CONNECTED_LINE);
        }
    }

    private static void printStringWithFormat(String name) {
        System.out.print(String.format(FORMAT_OF_NAME, name));
    }

    private static void printReturnLine() {
        System.out.println();
    }
}
