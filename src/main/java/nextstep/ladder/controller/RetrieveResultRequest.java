package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.LadderGame;

import java.util.Objects;

public final class RetrieveResultRequest {

    private final Ladder ladder;
    private final UserLadderResults userLadderResults;

    private RetrieveResultRequest(Ladder ladder, UserLadderResults userLadderResults) {
        this.ladder = ladder;
        this.userLadderResults = userLadderResults;
    }

    public static RetrieveResultRequest of(Ladder ladder, UserLadderResults userLadderResults) {
        validate(ladder, userLadderResults);
        return new RetrieveResultRequest(ladder, userLadderResults);
    }

    private static void validate(Ladder ladder, UserLadderResults userLadderResults) {
        if (Objects.isNull(ladder)) {
            throw new IllegalArgumentException("전달된 사다리 정보가 null입니다.");
        }
        if (Objects.isNull(userLadderResults)) {
            throw new IllegalArgumentException("전달된 사다리 결과 요청 정보가 null입니다.");
        }
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderGame ladderGame() {
        return new LadderGame(ladder, userLadderResults);
    }
}
