package nextstep.ladder;

import nextstep.ladder.domain.Gifts;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Peoples;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGameMain {

    public static void main(String[] args) {
        String peopleNames = InputView.inputPeoples();
        Peoples peoples = Peoples.of(peopleNames);

        String giftNames = InputView.inputGifts();
        Gifts gifts = Gifts.of(giftNames);

        int height = InputView.inputLadderHeight();

        Ladder ladder = LadderGame.newInstance(peoples.size(), height);

        OutputView.printLadder(ladder, peoples, gifts);

        String resultName = InputView.inputResultName();
        Peoples resultPeoples = peoples.getResultPeoples(resultName);
        OutputView.printResult(ladder, resultPeoples, gifts);
    }
}
