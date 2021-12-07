package ladder.view.result;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Position;
import ladder.domain.User;
import ladder.util.InputViewUtil;
import ladder.view.input.GameResultSettingInputView;
import ladder.view.input.UserNameInputView;

public class ResultView {
    private final UserNameInputView userNames;
    private final Ladder ladder;
    private final GameResultSettingInputView results;

    public ResultView(UserNameInputView userNames, Ladder ladder, GameResultSettingInputView results) {
        this.userNames = userNames;
        this.ladder = ladder;
        this.results = results;
    }

    public void showLadderGame() {
        System.out.println(this.userNames);
        System.out.println(this.ladder);
        System.out.println(this.results);
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
        userNames.users().stream()
                .map(user -> user.name() + " : " + results.resultByUserInitPosition(ladderResult.result(user)))
                .forEach(System.out::println);
    }

    private void showSingleUserResult(LadderResult ladderResult, String target) {
        User targetUser = userNames.findUser(target);

        final Position subResult = ladderResult.result(targetUser);
        System.out.println(results.resultByUserInitPosition(subResult));
    }
}
