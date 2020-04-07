package ladder.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderGameExecutionInfo {

    private final Members members;
    private final LadderGameRewords originLadderGameRewords;

    private LadderGameExecutionInfo(final Members members, final LadderGameRewords originLadderGameRewords) {
        validate(members, originLadderGameRewords);
        this.members = members;
        this.originLadderGameRewords = originLadderGameRewords;
    }

    private void validate(final Members members, final LadderGameRewords originLadderGameRewords) {
        if (Objects.isNull(members) || Objects.isNull(originLadderGameRewords)) {
            throw new IllegalArgumentException("members and ladderGameRewords must be existed.");
        }
    }

    public static LadderGameExecutionInfo newInstance(final Members members, final LadderGameRewords ladderGameRewords) {
        return new LadderGameExecutionInfo(members, ladderGameRewords);
    }

    public LadderGameResult makeGameResult(final LadderPoles ladderPoles) {
        return LadderGameResult.newInstance(members, convertGameRewordOrderAfterExecution(ladderPoles));
    }

    private LadderGameRewords convertGameRewordOrderAfterExecution(final LadderPoles ladderPoles) {
        List<LadderGameReword> ladderGameRewords = ladderPoles.getLadderPoles()
                .stream()
                .map(pole -> originLadderGameRewords.getLadderGameReword(pole.toInt()))
                .collect(Collectors.toList());

        return LadderGameRewords.newInstance(ladderGameRewords);
    }
}
