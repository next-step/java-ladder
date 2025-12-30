package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.user.User;

public class LadderResult {

    private final User user;
    private int position;

    public LadderResult(User user, int position) {
        this.user = user;
        this.position = position;
    }

    public void plusPosition() {
        this.position++;
    }

    public void minusPosition() {
        this.position--;
    }

    public User getUser() {
        return user;
    }

    public int getPosition() {
        return position;
    }
}
