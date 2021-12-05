package nextstep.step2;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.LadderGame;
import nextstep.step2.dto.GameInfoDto;
import nextstep.step2.dto.LadderInfoDto;
import nextstep.step2.view.InputView;
import nextstep.step2.view.OutputView;
import nextstep.step2.vo.BooleanGenerateStrategy;
import nextstep.step2.vo.Name;
import nextstep.step2.vo.RandomBooleanGenerateStrategy;

public class main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LadderGame game = createLadderGame(inputView);

        outputView.renderLadder(game);

        while (true) {
            playGame(inputView, outputView, game);
        }

    }

    private static void playGame(InputView inputView, OutputView outputView, LadderGame game) {
        String player = inputView.inputPlayer();

        if (player.equals("all")) {
            outputView.renderResults(game.playAllGame());
            return;
        }

        outputView.renderResult(game.playGame(Name.from(player)));
    }

    private static LadderGame createLadderGame(InputView inputView) {
        String namesString = inputView.inputNames();
        String giftString = inputView.inputGifts();

        GameInfoDto gameInfoDto = GameInfoDto.of(namesString, giftString);

        String heightString = inputView.inputHeight();
        Ladder ladder = createLadder(namesString, heightString);

        return createLadderGame(gameInfoDto, ladder);
    }

    private static LadderGame createLadderGame(GameInfoDto gameInfoDto, Ladder ladder) {
        return LadderGame.ofWithGamInfoDtoAndLadder(gameInfoDto, ladder);
    }

    private static Ladder createLadder(String namesString, String heightString) {
        LadderInfoDto ladderInfoDto = LadderInfoDto.of(namesString, heightString);
        BooleanGenerateStrategy strategy = new RandomBooleanGenerateStrategy();
        return Ladder.ofWithLadderInfoAndStrategy(ladderInfoDto, strategy);
    }
}
