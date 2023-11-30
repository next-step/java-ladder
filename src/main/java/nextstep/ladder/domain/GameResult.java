package nextstep.ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {

    private static final String ALL_PARTICIPATORS_RESULT_KEYWORD = "all";

    private final Participators participators;
    private final LadderResult ladderResult;

    public GameResult(Participators participators, LadderResult ladderResult) {
        this.participators = participators;
        this.ladderResult = ladderResult;
    }

    public String gameResult(String name) {
        if (name.equals(ALL_PARTICIPATORS_RESULT_KEYWORD)) {
            return makeAllParticipatorResult();
        }

        int location = participators.findParticipatorLocation(name);
        return ladderResult.getResult(location);
    }

    private String makeAllParticipatorResult() {
        return IntStream.range(0, participators.participatorCount())
                .boxed()
                .map(this::makeOneParticipatorResult)
                .collect(Collectors.joining("\n"));
    }

    private String makeOneParticipatorResult(Integer index) {
        return participators.getName(index) + " : " + ladderResult.getResult(participators.getParticipator(index).getLocation());
    }
}
