package ladder.view.input;

public class UserNameAndResult {
    private final UserNameInputView userNameInputView;
    private final GameResultSettingInputView gameResultSettingInputView;

    public UserNameAndResult(UserNameInputView userNameInputView, GameResultSettingInputView gameResultSettingInputView) {
        this.userNameInputView = userNameInputView;
        this.gameResultSettingInputView = gameResultSettingInputView;
    }

    public UserNameInputView userNameInputView() {
        return userNameInputView;
    }

    public GameResultSettingInputView gameResultSettingInputView() {
        return gameResultSettingInputView;
    }
}
