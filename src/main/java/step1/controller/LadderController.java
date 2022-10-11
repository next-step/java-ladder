package step1.controller;

import step1.domain.Height;
import step1.domain.Ladder;
import step1.domain.LadderGenerator;
import step1.domain.UserNames;
import step1.dto.LadderResultDto;
import step1.view.InputView;
import step1.view.PrintView;

public class LadderController {

    public static void main(String[] args) {
        UserNames userNames = UserNames.from(InputView.initJoinUserNames());
        Height height = new Height(InputView.initLadderHeight());

        Ladder ladder = LadderGenerator.generate(userNames.size(), height);
        PrintView.printResult(LadderResultDto.from(ladder, userNames));
    }
}
