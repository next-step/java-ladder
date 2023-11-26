package nextstep.step4.responsibility.output;

import nextstep.step4.responsibility.domain.GameResultProvider;

public interface OutputHandler {
    void outputMakingLadderResult();

    void outputGameResult(GameResultProvider gameResult);
}
