package nextstep.laddergame;

import nextstep.laddergame.controller.LadderController;

import nextstep.laddergame.domain.Gift;
import nextstep.laddergame.domain.Gifts;
import nextstep.laddergame.domain.Person;
import nextstep.laddergame.domain.dto.LadderDTO;
import nextstep.laddergame.domain.dto.ResultDTO;
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
        String gameGifts = inputView.getGameGifts();

        int ladderHeight = inputView.getLadderHeight();

        List<Person> people = ladderController.initParticipants(participants);
        List<Gift> gifts = ladderController.initGameGifts(gameGifts);
        LadderDTO ladder = ladderController.createLadder(ladderHeight);

        resultView.showPeople(people);
        resultView.showLadder(ladder);
        resultView.showGift(gifts);

        String personName = inputView.getPersonName();
        while (!personName.equals("all")) {
            ResultDTO result = ladderController.getResult(personName);
            resultView.showResult(result);
            personName = inputView.getPersonName();
        }

        List<ResultDTO> allResult = ladderController.getAllResult();
        resultView.showAllResult(allResult);


    }
}
