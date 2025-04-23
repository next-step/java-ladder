package ladder.view;

import ladder.domain.*;

import java.util.List;

public class LadderView {
    private static final int SPACES_BETWEEN_NAMES = 5;

    public static void printLadder(Participants participants, Ladder ladder, Rewards rewards) {
        List<Integer> nameLengths = participants.getNameLengths();
        printParticipants(participants);
        for (Line line : ladder.getLines()) {
            System.out.println(formatLadderLines(line, nameLengths));
        }
        printResults(rewards, nameLengths);
    }

    private static void printParticipants(Participants participants) {
        List<Participant> names = participants.getNames();
        System.out.println();
        for (Participant name : names) {
            System.out.printf("%s" + " ".repeat(SPACES_BETWEEN_NAMES), name.getName());
        }
        System.out.println();
    }

    private static String formatLadderLines(Line line, List<Integer> nameLengths) {
        int leftPadding = nameLengths.get(0) / 2;

        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(leftPadding));

        List<LinePoint> linePoints = line.getLinePoints();
        for (int i = 0; i < linePoints.size() - 1; i++) {
            Point point = linePoints.get(i).getPoint();
            int repeatNum = (nameLengths.get(i) + nameLengths.get(i + 1)) / 2 + SPACES_BETWEEN_NAMES - 1;
            sb.append("|");
            sb.append(point.getCurrent() ? "-".repeat(repeatNum) : " ".repeat(repeatNum));
        }

        sb.append("|");
        return sb.toString();
    }

    private static void printResults(Rewards rewards, List<Integer> nameLengths) {
        List<Integer> resultLengths = rewards.getResultLengths();
        int leftPadding = 0;
        if (nameLengths.get(0) > resultLengths.get(0)) {
            leftPadding = (nameLengths.get(0) - resultLengths.get(0)) / 2;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(leftPadding));
        sb.append(rewards.getValues().get(0).getValue());

        for (int i = 1; i < nameLengths.size(); i++) {
            int spaces = SPACES_BETWEEN_NAMES + (nameLengths.get(i) - resultLengths.get(i) + nameLengths.get(i - 1) - resultLengths.get(i - 1)) / 2;
            sb.append(" ".repeat(spaces));
            sb.append(rewards.getValues().get(i).getValue());
        }

        System.out.println(sb);
    }

    public static void printTargetResult(Results results, Target target) {
        System.out.println("실행 결과");
        if (target.getName().equalsIgnoreCase("all")) {
            System.out.println(String.join(System.lineSeparator(), results.printAll()));
        } else {
            System.out.println(results.printTarget(target.getName()));
        }
    }
}
