package step1.controller;

import java.util.List;

import step1.domain.Height;
import step1.domain.Ladder;
import step1.domain.LadderGameResult;
import step1.dto.LadderGameResultDto;
import step1.domain.LadderGameStarter;
import step1.domain.LadderGenerator;
import step1.domain.Prize;
import step1.domain.UserNames;
import step1.dto.LadderGameDto;
import step1.view.InputView;
import step1.view.PrintView;

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
