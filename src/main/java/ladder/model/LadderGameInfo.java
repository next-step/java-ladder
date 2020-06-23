package ladder.model;

import java.util.Objects;

public class LadderGameInfo {

    private final Members members;
    private final LadderGameRewords ladderGameRewords;

    private LadderGameInfo(final Members members, final LadderGameRewords ladderGameRewords) {
        validate(members, ladderGameRewords);
        this.members = members;
        this.ladderGameRewords = ladderGameRewords;
    }

    public static LadderGameInfo create(final Members members, final LadderGameRewords ladderGameRewords) {
        return new LadderGameInfo(members, ladderGameRewords);
    }

    private void validate(final Members members, final LadderGameRewords ladderGameRewords) {
        if (Objects.isNull(members) || Objects.isNull(ladderGameRewords)) {
            throw new IllegalArgumentException("참여자와 결과는 NULL 이 아닙니다.");
        }

        if (members.count() != ladderGameRewords.count()) {
            throw new IllegalArgumentException("참여자와 결과의 갯수는 동일해야 합니다.");
        }
    }

    public LadderGameResult makeGameResult(final LadderPoles ladderPoles) {
        return LadderGameResult.create(members, ladderPoles.convertToGameRewords(ladderGameRewords));
    }

    public int count() {
        return members.count();
    }

    public Member getMember(final int index) {
        return members.get(index);
    }

    public LadderGameReword getOriginLadderGameReword(final int index) {
        return ladderGameRewords.get(index);

    }
}
