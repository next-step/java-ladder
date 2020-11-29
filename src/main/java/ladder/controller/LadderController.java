package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.domain.LadderConfig.USER_NAME_SEPARATOR;

public class LadderController {

    private LadderController() {}

    public static void ladderCreator() {
        String names = InputView.inputUserName();
        int height = InputView.inputHeight();

        List<String> userNames = splitUserNames(names);
        Lines lines = Ladder.createLines(userNames.size(),height,new LadderMoveStrategy());
        ResultView.printGameResult(userNames,lines);
    }

    private static List<String> splitUserNames(String userNames) {
        return Arrays.stream(userNames.split(USER_NAME_SEPARATOR))
                .collect(Collectors.toList());
    }
}
