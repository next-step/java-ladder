package nextstep.step4.domain;

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
}
