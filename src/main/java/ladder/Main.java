package ladder;

import ladder.domain.Ladder;
import ladder.domain.RandomLineFactory;
import ladder.external.RandomFactory;
import ladder.view.InputDto;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputDto inputDto = InputView.scan();

        Ladder ladder = new Ladder(inputDto.getNames().size(), inputDto.getHeight(), new RandomLineFactory(new RandomFactory()));

        ResultView.printLadderResult(inputDto.getNames(), ladder, inputDto.getLadderResults());
    }
}
