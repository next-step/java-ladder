package nextstep.ladder.service;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultVIew;

public class LadderGame {
    InputView inputView;
    ResultVIew resultView;

    public LadderGame(InputView inputView, ResultVIew resultView){
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void operator(){
        String[] list = inputView.getMembers();
        int height = inputView.getLadderHeight();
        LadderService ladderService = new LadderService();
        Ladder ladder = ladderService.setupLadder(list, height);
        resultView.printMember(list);
        resultView.printLadder(ladder);
    }
    
}