package step4.controller;

import java.util.List;

import step4.domain.Height;
import step4.domain.Ladder;
import step4.domain.LadderGameResult;
import step4.domain.LadderGameStarter;
import step4.domain.LadderGenerator;
import step4.domain.Prize;
import step4.domain.UserNames;
import step4.dto.LadderGameDto;
import step4.dto.LadderGameResultDto;
import step4.view.InputView;
import step4.view.PrintView;

public class LadderController {

    public static void main(String[] args) {
        UserNames userNames = UserNames.from(InputView.initJoinUserNames());
        List<Prize> prizes = Prize.from(InputView.initLadderGoals());
        Height height = new Height(InputView.initLadderHeight());

        Ladder ladder = LadderGenerator.generate(userNames.size(), height);
        PrintView.printLadderGame(LadderGameDto.from(ladder, userNames, prizes));

        LadderGameResult ladderGameResult = LadderGameStarter.start(ladder, userNames, prizes);
        printLadderGameResult(LadderGameResultDto.from(ladderGameResult));
    }

    private static void printLadderGameResult(LadderGameResultDto ladderGameResultDto) {
        while (true) {
            String inputUserName = InputView.initLadderGameResult();
            PrintView.printLadderGameResult(ladderGameResultDto, inputUserName);
            if (inputUserName.equals("all")) {
                break;
            }
        }
    }
}
