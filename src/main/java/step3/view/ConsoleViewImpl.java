package step3.view;

import step3.exceptions.OutOfRangePlayerNameException;
import step3.ladder.Ladder;
import step3.ladder.LadderGame;
import step3.ladder.LadderPlayers;
import step3.ladder.Player;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public class ConsoleViewImpl implements View {
    public static final String ERROR_NO_INPUT_NAMES = "작성된 이름이 없습니다.";
    public static final String ERROR_INVALID_LADDER_HEIGHT = "1 이상의 값을 입력해 주세요";

    private final InputView inputView;
    private final ResultView resultView;

    public ConsoleViewImpl(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    @Override
    public String getPlayerNames() {
        try{
            String playerNames = inputView.getPlayerNames();
            isValidNames(playerNames);
            return playerNames;
        }catch(OutOfRangePlayerNameException | NoSuchElementException error){
            System.out.println(error.getMessage());
            return getPlayerNames();
        }
    }

    private void isValidNames(String playerNames) {
        isValidNullAndEmpty(playerNames);
        isValidEachName(playerNames);
    }

    private void isValidEachName(String playerNames) {
        Stream.of(playerNames.split(LadderGame.DELIMITER))
                .forEach(Player::isNameSizeUnder5);
    }

    private void isValidNullAndEmpty(String playerNames) {
        if (Objects.isNull(playerNames) || "".equals(playerNames)) {
            throw new NoSuchElementException(ERROR_NO_INPUT_NAMES);
        }
    }

    @Override
    public Integer getLadderHeight() {
        try{
            Integer ladderHeight = inputView.getLadderHeight();
            Ladder.isValidLineHeight(ladderHeight);

            return ladderHeight;
        }catch(IllegalArgumentException error){
            System.out.println(ERROR_INVALID_LADDER_HEIGHT);
            return getLadderHeight();
        }
    }

    @Override
    public void drawLadder(LadderPlayers players, Ladder ladder) {
        try{
            resultView.drawLadder(players, ladder);
        }catch(Exception error){
            System.out.println(error.getMessage());
        }
    }
}
