package ladder.view;

import ladder.domain.*;

import java.util.List;

public class LadderView {
    private static final int SPACES_BETWEEN_NAMES = 5;

    public static void printLadder(Participants participants, Ladder ladder) {
        List<Integer> nameLengths = participants.getNameLengths();
        printParticipants(participants);

        for (Line line : ladder.getLines()) {
            System.out.println(formatLadderLines(line, nameLengths));
        }
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

        List<Point> points = line.getPoints();
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            int repeatNum = (nameLengths.get(i) + nameLengths.get(i + 1)) / 2 + SPACES_BETWEEN_NAMES - 1;
            sb.append("|");
            sb.append(point.hasRight() ? "-".repeat(repeatNum) : " ".repeat(repeatNum));
        }

        sb.append("|");
        return sb.toString();
    }
}
