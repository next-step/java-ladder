package nextstep.step2;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.LadderGame;
import nextstep.step2.dto.GameInfoDto;
import nextstep.step2.dto.LadderInfoDto;
import nextstep.step2.view.InputView;
import nextstep.step2.view.OutputView;
import nextstep.step2.vo.BooleanGenerateStrategy;
import nextstep.step2.vo.RandomBooleanGenerateStrategy;

public class main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String namesString = inputView.inputNames();
        String heightString = inputView.inputHeight();

        Ladder ladder = getLadder(namesString, heightString);

        LadderGame game = getLadderGame(namesString, ladder);

        outputView.renderLadder(game);
    }

    private static LadderGame getLadderGame(String namesString, Ladder ladder) {
        GameInfoDto gameInfoDto = GameInfoDto.of(namesString, null);
        return LadderGame.of(gameInfoDto, ladder);
    }

    private static Ladder getLadder(String namesString, String heightString) {
        LadderInfoDto ladderInfoDto = LadderInfoDto.of(namesString, heightString);
        BooleanGenerateStrategy strategy = new RandomBooleanGenerateStrategy();
        return Ladder.of(ladderInfoDto, strategy);
    }
}
