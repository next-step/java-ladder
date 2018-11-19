package ui;

import domain.Ladder;
import domain.NameTag;
import domain.InputTagGroup;
import domain.ResultTagGroup;
import util.StringUtil;
import view.InputView;
import view.ResultView;

import java.util.List;

public class ConsoleUI {
    public static void main(String[] args) {

        String names = InputView.inputNames();
        List<NameTag> nameTagList = StringUtil.makeNameTags(names);

        String result = InputView.inputResults();
        List<NameTag> resultTagList = StringUtil.makeNameTags(result);
        ResultTagGroup resultTagGroup = ResultTagGroup.of(resultTagList);

        int height = InputView.inputHeight();
        Ladder ladder = Ladder.ofGroup(height, nameTagList);

        InputTagGroup nameTagGroup = InputTagGroup.of(nameTagList, ladder);

        ResultView.ladderResult();
        ResultView.printNameTags(nameTagGroup);
        ResultView.printLadder(ladder);
        ResultView.printResultNameTags(resultTagGroup);
        ResultView.printFinalResult(nameTagGroup, resultTagGroup);
    }
}
