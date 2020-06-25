package ladder.domain;

import java.util.List;

public class LadderGame {
    private List<User> users;
    private Ladder ladder;
    private List<LadderResult> ladderResults;

    public LadderGame(List<User> users, List<LadderResult> ladderResults, Ladder ladder) {
        validateUserCountAndResultCount(users, ladderResults);
        this.users = users;
        this.ladder = ladder;
        this.ladderResults = ladderResults;
    }

    private void validateUserCountAndResultCount(List<User> users, List<LadderResult> ladderResults) {
        if(users.size() != ladderResults.size()) {
            throw new IllegalArgumentException("사용자의 수와 사다리 결과의 수다 다릅니다.");
        }
    }

    public LadderResult gameStart(User user) {
        int startPosition = getStartPositionIndex(user);

        for (int i = 0; i < ladder.getHeight(); i++) {
            if(ladder.isEnabledShortLineOfLeft(i, startPosition)) {
                startPosition--;
            }
            if(ladder.isEnabledShortLineOfRight(i, startPosition)) {
                startPosition++;
            }
        }
        System.out.println("startPosition -> " + startPosition);
        return ladderResults.get(startPosition);
    }



    private int getStartPositionIndex(User user) {
        for (int i = 0; i < users.size() ; i++) {
            if(users.get(i).equals(user)) {
                return i;
            }
        }
        throw new IllegalArgumentException("게임에 참여하지 않은 사용자 입니다.");
    }



}
