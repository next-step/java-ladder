package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;
import ladder.vo.coordinate.Coordinate;
import ladder.vo.coordinate.CoordinateValue;

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
        Coordinate startCoordinate = getStartCoordinateOfMember(member);
        int startIndex = startCoordinate.getXValue();
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

    Coordinate getStartCoordinateOfMember(Member member) {
        CoordinateValue x = this.ladderGameInfo.getStartXCoordinateOfMember(member);
        CoordinateValue y = new CoordinateValue(this.ladder.getHeight());

        return new Coordinate(x, y);
    }

    private void validateLadderGame(LadderGameInfo ladderGameInfo, Ladder ladder) {
        int ladderSize = ladder.getWidth();
        int ladderWidthForMembers = ladderGameInfo.getLadderWidthForMembers().getValue();


        if (ladderSize != ladderWidthForMembers) {
            throw new IllegalArgumentException("It's a wrong ladder for the members");
        }
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
}
