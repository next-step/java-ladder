package nextstep.ladder.view;

import java.util.stream.Collectors;

import nextstep.ladder.domain.Junction;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Leg;
import nextstep.ladder.domain.ParticipantName;

public class LadderFormatter {

    public static String format(Ladder ladder) {
        StringBuilder sb = new StringBuilder();

        String names = formatNames(ladder);

        sb.append(names).append("\n");

        String ladderStr = formatLadder(ladder);

        sb.append(ladderStr);

        String results = formatResults(ladder);

        sb.append(results);

        return sb.toString();
    }

    private static String formatNames(Ladder ladder) {
        return ladder.getLegs()
            .stream()
            .map(Leg::getName)
            .map(name -> leftPad(name.getValue(), ParticipantName.NAME_WIDTH, ' '))
            .collect(Collectors.joining(""));
    }

    private static String formatResults(Ladder ladder) {
        return ladder.getLegs()
            .stream()
            .map(Leg::getResult)
            .map(result -> leftPad(result, ParticipantName.NAME_WIDTH, ' '))
            .collect(Collectors.joining(""));
    }


    private static String formatLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();

        for (int level = 0; level < ladder.getHeight(); level++) {
            for (Leg leg : ladder.getLegs()) {
                Junction junction = leg.getJunction(level);

                if (junction.hasLeft()) {
                    sb.append(leftPad("|", ParticipantName.NAME_WIDTH, '-'));
                    continue;
                }

                sb.append(leftPad("|", ParticipantName.NAME_WIDTH, ' '));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private static String leftPad(String s, int width, char padChar) {
        int padSize = Math.max(0, width - s.length());
        return String.valueOf(padChar).repeat(padSize) + s;
    }


}
