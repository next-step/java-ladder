package nextstep.ladder.domain;

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
            return allUserResult(ladderResultBoard);
        }

        return singleUserResult(ladderResultBoard, target);
    }

    private LadderResultBoard allUserResult(LadderResultBoard ladderResultBoard) {
        allUserLastPosition(ladderResultBoard, users);
        return ladderResultBoard;
    }

    private LadderResultBoard singleUserResult(LadderResultBoard ladderResultBoard, String userName) {
        User user = users.getUsers(userName);
        userLastPosition(ladderResultBoard, user);
        return ladderResultBoard;
    }

    public void allUserLastPosition(LadderResultBoard ladderResultBoard, Users users) {
        for (User user : users.getUsers()) {
            userLastPosition(ladderResultBoard, user);
        }
    }

    public void userLastPosition(LadderResultBoard ladderResultBoard, User user) {
        int userPosition = users.userIndex(user.getUserName());
        int lastPosition = ladder.run(userPosition);
        ladderResultBoard.addUserLastLadderPosition(user, lastPosition);
    }

}
