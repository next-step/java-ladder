package ladder.domain;

public class Result {
    private final User user;
    private final WinningItem winningItem;

    public Result(User user, WinningItem winningItem) {
        this.user = user;
        this.winningItem = winningItem;
    }

    public User getUser() {
        return user;
    }

    public WinningItem getWinningItem() {
        return winningItem;
    }
}
