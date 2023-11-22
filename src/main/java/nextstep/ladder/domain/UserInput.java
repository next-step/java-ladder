package nextstep.ladder.domain;

public class UserInput {
    private final LadderHeight ladderHeight;
    private final UserData userData;

    public UserInput(final UserData userData, final LadderHeight ladderHeight) {
        this.userData = userData;
        this.ladderHeight = ladderHeight;
    }

    public UserNames userNames() {
        return this.userData.userNames();
    }

    public UserResults userResults() {
        return this.userData.userResults();
    }

    public LadderHeight ladderHeight() {
        return this.ladderHeight;
    }

    public int height() {
        return this.ladderHeight.height();
    }

    public int userNamesSize() {
        return this.userData.userNamesSize();
    }
}
