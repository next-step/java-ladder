package nextstep.ladder.view;

import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Participators;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResultView {

    private static final String ALL_PARTICIPATORS_RESULT_KEYWORD = "all";

    public String gameResult(Participators participators, LadderResults ladderResults, String name) {
        if (name.equals(ALL_PARTICIPATORS_RESULT_KEYWORD)) {
            return makeAllParticipatorResult(participators, ladderResults);
        }

        int location = participators.findParticipatorLocation(name);
        return ladderResults.getResult(location);
    }

    private String makeAllParticipatorResult(Participators participators, LadderResults ladderResults) {
        return IntStream.range(0, participators.participatorCount())
                .boxed()
                .map(index -> makeOneParticipatorResult(participators.getName(index),
                        ladderResults.getResult(participators.getParticipator(index).getLocation()))
                )
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String makeOneParticipatorResult(String name, String result) {
        return name + " : " + result;
    }
}
