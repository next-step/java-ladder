package ladder.controller;

import ladder.Ladder;
import ladder.NameList;
import ladder.utils.StringToIntConverter;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    public static void run() {
        String nameString = InputView.nameOfPlayer();
        NameList nameList = new NameList(nameString);

        int heightOfLadder = StringToIntConverter.toInt(InputView.heightOfLadder());

        Ladder ladder = new Ladder(heightOfLadder, nameList.numOfName());

        OutputView.printLadderGameResult(nameList, ladder);
    }
}
