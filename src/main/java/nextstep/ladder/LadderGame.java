package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.GameOrganizer;
import nextstep.ladder.domain.MatchResult;
import nextstep.ladder.dto.ViewDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.output.OutputView;

public class LadderGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        GameOrganizer gameOrganizer =  GameOrganizer.of(inputView.players(), inputView.ladderResults());
        int height = inputView.ladderHeight();
        Ladder ladder = Ladder.of(height, gameOrganizer.count());

        Visible outputView = new OutputView();
        outputView.view(gameOrganizer, ladder);
    }
}
