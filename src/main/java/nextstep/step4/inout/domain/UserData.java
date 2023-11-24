package nextstep.step4.inout.domain;

public class UserData {
    private final UserInputTexts userNames;
    private final UserInputTexts userResults;

    public UserData(final UserInputTexts userNames, final UserInputTexts userResults) {
        this.userNames = userNames;
        this.userResults = userResults;
    }

    public UserInputTexts getUserNames() {
        return userNames;
    }

    public UserInputTexts getUserResults() {
        return userResults;
    }

    public int size() {
        return this.userNames.size();
    }
}
