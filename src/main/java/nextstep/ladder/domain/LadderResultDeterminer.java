package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderResultDeterminer {

    private final LadderResult ladderResult;
    private final Ladder ladder;
    private final Names names;

    public LadderResultDeterminer(final LadderResult ladderResult, final Ladder ladder, final Names names) {
        validate(ladderResult, names);
        this.ladderResult = ladderResult;
        this.ladder = ladder;
        this.names = names;
    }

    public String determineResult(final Name name) {
        final int column = ladder.move(names.findStartColumn(name));
        return ladderResult.getResultByIndex(column);
    }

    private void validate(final LadderResult ladderResult, final Names names) {
        if (ladderResult.getResultNumber() != names.getNumberOfNames()) {
            throw new IllegalArgumentException("실행 결과의 개수가 참여자의 수와 일치하지 않습니다.");
        }
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names.getNames());
    }
}
