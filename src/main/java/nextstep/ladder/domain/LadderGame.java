package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final GameInfo gameInfo;
    private final Ladder ladder;
    private final LadderResult ladderResult;

    public LadderGame(List<String> users, int floor, List<String> winProducts, LineStrategy lineStrategy) {
        this.gameInfo = GameInfo.of(Users.from(users), WinProducts.of(winProducts));
        this.ladder = Ladder.of(floor, users.size(), lineStrategy);
        this.ladderResult = new LadderResult(getResultLadderGame());
    }

    private List<String> getResultLadderGame() {
        return this.gameInfo.getParticipantsList().stream()
                .map(this::calculateUserWinProduct)
                .collect(Collectors.toList());
    }

    public List<String> getParticipants() {
        return gameInfo.getParticipantsList();
    }

    private String calculateUserWinProduct(String name) {
        int destinationPosition = this.ladder.destinationPosition(this.gameInfo.getUserDepartPosition(name));

        return this.gameInfo.getWinProductsOf(destinationPosition);
    }

    private void validateParticipant(String name) {
        if (!this.gameInfo.hasUserName(name)) {
            throw new IllegalArgumentException("조회하려는 참여자가 존재하지 않습니다.");
        }
    }

    public List<Line> getLadderInfo() {
        return this.ladder.getLadderInfo();
    }

    public String getWinProduct(String name) {
        validateParticipant(name);
        return this.ladderResult.getValueOfIndex(this.gameInfo.getUserDepartPosition(name));
    }
}
