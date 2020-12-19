package nextstep.ladder.domain;

public class LadderResult {
    private final User user;
    private final LadderGoal ladderGoal;

    public LadderResult(User user, LadderGoal ladderGoal) {
        this.user = user;
        this.ladderGoal = ladderGoal;
    }

    public LadderGoal getLadderGoal() {
        return ladderGoal;
    }

    public User getUser() {
        return user;
    }

    public boolean isUserResult(String name){
        return user.equalsByName(name);
    }

}
