package nextstep.ladder.domain;

public class UserData {
    private final UserNames userNames;
    private final UserResults userResults;

    public UserData(final UserNames userNames, final UserResults userResults) {
        this.userNames = userNames;
        this.userResults = userResults;
    }

    public UserNames userNames() {
        return userNames;
    }

    public int userNamesSize() {
        return this.userNames.size();
    }

    public UserResults userResults() {
        return userResults;
    }
}
