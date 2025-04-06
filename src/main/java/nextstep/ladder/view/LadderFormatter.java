package nextstep.ladder.view;

import java.util.stream.Collectors;

import nextstep.ladder.domain.Junction;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Leg;
import nextstep.ladder.domain.ParticipantName;

public class LadderFormatter {

    public static String format(Ladder ladder) {
        StringBuilder sb = new StringBuilder();

        String names = ladder.getLegs()
            .stream()
            .map(Leg::getName)
            .map(name -> String.format("%" + ParticipantName.NAME_WIDTH + "s ", name))
            .collect(Collectors.joining(""));

        sb.append(names).append("\n");

        String ladderStr = formatLadder(ladder);

        sb.append(ladderStr);

        return sb.toString();
    }

    private static String formatLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();

        for (int level = 0; level < ladder.getHeight(); level++) {
            sb.append(" ".repeat(ParticipantName.NAME_WIDTH - 1));
            for (Leg leg : ladder.getLegs()) {
                sb.append("|");
                Junction junction = leg.getJunction(level);
                if (junction.hasRight()) {
                    sb.append("-".repeat(ParticipantName.NAME_WIDTH));
                    continue;
                }

                sb.append(" ".repeat(ParticipantName.NAME_WIDTH));
            }
            sb.append("\n");
        }

        return sb.toString();
    }


}
