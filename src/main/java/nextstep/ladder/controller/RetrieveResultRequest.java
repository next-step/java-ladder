package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.LadderGame;

import java.util.Objects;

public final class RetrieveResultRequest {

    private final Ladder ladder;
    private final UsersLadderResults usersLadderResults;

    private RetrieveResultRequest(Ladder ladder, UsersLadderResults usersLadderResults) {
        this.ladder = ladder;
        this.usersLadderResults = usersLadderResults;
    }

    public static RetrieveResultRequest of(Ladder ladder, UsersLadderResults usersLadderResults) {
        validate(ladder, usersLadderResults);
        return new RetrieveResultRequest(ladder, usersLadderResults);
    }

    private static void validate(Ladder ladder, UsersLadderResults usersLadderResults) {
        if (Objects.isNull(ladder)) {
            throw new IllegalArgumentException("전달된 사다리 정보가 null입니다.");
        }
        if (Objects.isNull(usersLadderResults)) {
            throw new IllegalArgumentException("전달된 사다리 결과 요청 정보가 null입니다.");
        }
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderGame ladderGame() {
        return new LadderGame(ladder, usersLadderResults);
    }
}
