package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final LadderGameInfo ladderGameInfo;
    private final Ladder ladder;

    public LadderGame(LadderGameInfo ladderGameInfo, Ladder ladder) {
        validateLadderGame(ladderGameInfo, ladder);

        this.ladderGameInfo = ladderGameInfo;
        this.ladder = ladder;
    }

    public LadderGameResult getResult(Member member) {
        int startIndex = this.ladderGameInfo.getIndexOfMember(member);
        int resultIndex = ladder.getResultIndex(startIndex);

        Reward reward = this.ladderGameInfo.getReward(resultIndex);

        return new LadderGameResult(member, reward);
    }

    public LadderGameResults getAllResult() {
        List<LadderGameResult> results = this.ladderGameInfo.getMembers().stream()
                .map(this::getResult)
                .collect(Collectors.toList());

        return new LadderGameResults(results);
    }

    public MemberGroup getMemberGroup() {
        return ladderGameInfo.getMemberGroup();
    }

    public Rewards getRewards() {
        return ladderGameInfo.getRewards();
    }

    public Ladder getLadder() {
        return ladder;
    }

    private void validateLadderGame(LadderGameInfo ladderGameInfo, Ladder ladder) {
        int ladderWidth = ladder.getWidth();
        int ladderWidthForMembers = ladderGameInfo.getLadderWidthForMembers();

        if (ladderWidth != ladderWidthForMembers) {
            throw new IllegalArgumentException("It's a wrong ladder for the members");
        }
    }

}
