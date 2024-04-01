package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {

    private final GameInfo gameInfo;
    private final Ladder ladder;

    public LadderGame(List<String> users, int floor, List<String> winProducts, LineStrategy lineStrategy) {
        validate(users, winProducts);

        this.gameInfo = GameInfo.of(Users.from(users), WinProducts.of(winProducts));
        this.ladder = Ladder.of(floor, users.size(), lineStrategy);
    }

    private void validate(List<String> users, List<String> winProducts) {
        if (users.size() != winProducts.size()) {
            throw new IllegalArgumentException("참가자 수와 상품 수가 상이합니다.");
        }
    }

    public List<String> getParticipants() {
        return gameInfo.getParticipantsList();
    }

    public String getWinProduct(String name) {
        validateParticipant(name);
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
}
