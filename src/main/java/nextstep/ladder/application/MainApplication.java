package nextstep.ladder.application;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.util.StringUtil;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        String nameString = InputView.inputNameString();
        String resultString = InputView.inputResultString();

        int height = InputView.inputLadderHeight();
        List<String> names = StringUtil.separator(nameString);
        List<String> results = StringUtil.separator(resultString);
        Ladder ladder = PlayLadder.createLadder(names, height, results);

        ResultView.printNames(names);
        ResultView.printLadder(ladder);
        ResultView.printResults(results);

        List<User> users = PlayLadder.playLadder(ladder, names);

        String findResultName = null;
        InputView.emptyLine();
        while (!"all".equals(findResultName)) {
            findResultName = InputView.inputFindResultString();
            ResultView.printFindResult(findResultName, users, ladder);
        }
        InputView.closeScanner();
    }
}
