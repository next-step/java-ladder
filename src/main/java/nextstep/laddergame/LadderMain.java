package nextstep.laddergame;

import nextstep.laddergame.controller.LadderController;
import nextstep.laddergame.domain.Person;
import nextstep.laddergame.domain.dto.LadderDTO;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.ResultView;

import java.util.List;

public class LadderMain {
    private InputView inputView;
    private ResultView resultView;
    private LadderController ladderController;

    public LadderMain() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.ladderController = new LadderController();

    }
    public void run() {
        String participants =inputView.getParticipant();
        int ladderHeight = inputView.getLadderHeight();

        List<Person> people = ladderController.initParticipants(participants);
        LadderDTO ladder = ladderController.createLadder(ladderHeight);

        resultView.showPeople(people);
        resultView.showLadder(ladder);

    }
}
