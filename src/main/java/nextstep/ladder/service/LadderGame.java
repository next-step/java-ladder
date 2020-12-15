package nextstep.ladder.service;

import nextstep.ladder.domain.Member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.MemberList;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
    InputView inputView;
    ResultView resultView;

    public LadderGame(InputView inputView, ResultView resultView){
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void operator(){
        MemberList members = new MemberList();
        members.setMembers(inputView.getMembers());
        int height = inputView.getLadderHeight();
        Ladder ladder = new Ladder();
        ladder.setLadder(members.getMembers().size(), height);

        resultView.printMember(members);
        resultView.printLadder(ladder);
    }
    
}