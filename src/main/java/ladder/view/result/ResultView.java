package ladder.view.result;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Position;
import ladder.domain.User;
import ladder.util.InputViewUtil;
import ladder.view.input.UserNameAndResult;

public class ResultView {
    private final Ladder ladder;
    private final UserNameAndResult userNameAndResult;

    public ResultView(UserNameAndResult userNameAndResult, Ladder ladder) {
        this.userNameAndResult = userNameAndResult;
        this.ladder = ladder;
    }

    public void showLadderGame() {
        System.out.println(this.userNameAndResult.userNameInputView());
        System.out.println(this.ladder);
        System.out.println(this.userNameAndResult.gameResultSettingInputView());
    }

    public void showResult() {
        LadderResult ladderResult = ladder.result();

        while (true) {
            System.out.println("결과를 보고 싶은 사람은?");
            final String target = InputViewUtil.getUserInput();

            System.out.println("실행 결과");

            if (target.trim().equalsIgnoreCase("all")) {
                showAllUserResult(ladderResult);
                break;
            }

            showSingleUserResult(ladderResult, target);
        }
    }

    private void showAllUserResult(LadderResult ladderResult) {
        this.userNameAndResult.userNameInputView().users().stream()
                .map(user -> user.name() + " : " + this.userNameAndResult.gameResultSettingInputView().resultByUserInitPosition(ladderResult.result(user)))
                .forEach(System.out::println);
    }

    private void showSingleUserResult(LadderResult ladderResult, String target) {

        User targetUser = this.userNameAndResult.userNameInputView().findUser(target);

        final Position subResult = ladderResult.result(targetUser);
        System.out.println(this.userNameAndResult.gameResultSettingInputView().resultByUserInitPosition(subResult));
    }
}
