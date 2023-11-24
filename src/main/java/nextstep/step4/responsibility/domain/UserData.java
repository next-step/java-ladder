package nextstep.step4.responsibility.domain;

public class UserData {
    private final UserInputProvider userNames;
    private final UserInputProvider userResults;

    public UserData(final UserInputProvider userNames, final UserInputProvider userResults) {
        this.userNames = userNames;
        this.userResults = userResults;
    }

    public UserInputProvider getUserNames() {
        return userNames;
    }

    public UserInputProvider getUserResults() {
        return userResults;
    }
}
