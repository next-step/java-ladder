package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.member.Member;
import ladder.domain.reward.Reward;
import ladder.vo.Length;
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

    private void validateLadderGame(LadderGameInfo ladderGameInfo, Ladder ladder) {
        Length width = ladder.getWidth();
        Length ladderWidthForMembers = ladderGameInfo.getLadderWidthForMembers();

        if (!width.equals(ladderWidthForMembers)) {
            throw new IllegalArgumentException("It's a wrong ladder for the members");
        }
    }

    Coordinate getStartCoordinateOfMember(Member member) {
        CoordinateValue x = this.ladderGameInfo.getStartXCoordinateOfMember(member);
        CoordinateValue y = this.ladder.getStartYCoordinate();

        return new Coordinate(x, y);
    }

    public LadderGameResult getResult(Member member) {
        Coordinate resultCoordinate = this.ladder.getLadderResultCoordinate(getStartCoordinateOfMember(member));

        CoordinateValue x = resultCoordinate.getX();
        Reward reward = this.ladderGameInfo.getReward(x);

        return new LadderGameResult(member, reward);
    }

    public LadderGameResults getAllResult() {
        List<LadderGameResult> results = this.ladderGameInfo.getMembers().stream()
                .map(this::getResult)
                .collect(Collectors.toList());

        return new LadderGameResults(results);
    }
}
