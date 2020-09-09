package nextstep.ladder.util;

import nextstep.ladder.domain.*;

import java.util.List;

public class JudgeLadderResult {

    private Ladder ladder;

    private final Users users;

    private JudgeLadderResult(Ladder ladder, Users users) {
        this.ladder = ladder;
        this.users = users;
    }

    public static JudgeLadderResult newInstance(Ladder ladder, Users users) {
        return new JudgeLadderResult(ladder, users);
    }

    public LadderResultBoard judge(boolean isShowOneUser, String target) {

        LadderResultBoard ladderResultBoard = LadderResultBoard.create();
        if (!isShowOneUser) {
            allUserLastPosition(ladderResultBoard, users);
            return ladderResultBoard;
        }

        User user = users.getUsers(target);
        userLastPosition(ladderResultBoard, user);
        return ladderResultBoard;
    }

    public void allUserLastPosition(LadderResultBoard ladderResultBoard, Users users) {
        for (User user : users.getUsers()) {
            userLastPosition(ladderResultBoard, user);
        }
    }

    public void userLastPosition(LadderResultBoard ladderResultBoard, User user) {
        ladder.run(user);
        ladderResultBoard.addUserLastLadderPosition(user);
    }

}
