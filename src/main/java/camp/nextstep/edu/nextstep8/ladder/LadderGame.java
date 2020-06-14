package camp.nextstep.edu.nextstep8.ladder;

import camp.nextstep.edu.nextstep8.ladder.entity.Ladder;

public class LadderGame {
    public static void main(String[] args) {
        String joinMemberStr = LadderGameInput.getJoinMembers();
        int height = LadderGameInput.getLadderHeight();

        Ladder ladder = new Ladder(joinMemberStr, height).make();
        LadderGameView.show(ladder);
    }
}
