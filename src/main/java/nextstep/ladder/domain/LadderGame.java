package nextstep.ladder.domain;

import nextstep.ladder.model.GameResult;
import nextstep.ladder.model.GamerResult;
import nextstep.ladder.model.Gamers;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.stream.IntStream;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final GamerResult gamerResult = new GamerResult();

    public void start() {
        Gamers gamers = new Gamers(inputView.receiveGamers());
        GameResult gameResult = new GameResult(inputView.receiveGameResult());
        gameResult.validateGameResultCount(gamers);

        int height = inputView.receiveMaxHeight();
        Ladder ladder = new Ladder(height, gamers.getCountOfPerson());

        resultView.printResult(gamers, ladder, gameResult);

        startLadderGame(gamers, ladder, gameResult);
        printGamerResult();
    }

    private void printGamerResult() {
        while (true) {
            String gamer = inputView.receiveGamerNameForResult();

            if (gamer.equals("0")) {
                resultView.printGameOver();
                return;
            }

            resultView.printGamerResult(gamerResult, gamer);
        }
    }

    private void startLadderGame(Gamers gamers, Ladder ladder, GameResult gameResult) {
        IntStream.range(0, gamers.getCountOfPerson())
                .forEach(startPosition -> {
                    int finalPosition = getFinalPosition(ladder, startPosition);
                    String gamerName = gamers.getGamerNameByPosition(startPosition);
                    String result = gameResult.getGameResultByPosition(finalPosition);
                    gamerResult.addResult(gamerName, result);
                });
    }

    private int getFinalPosition(Ladder ladder, int startPosition) {
        return IntStream.range(0, ladder.getHeight())
                .reduce(startPosition, (position, height) -> getNextPosition(ladder, position, height));
    }

    private int getNextPosition(Ladder ladder, int position, int height) {
        if (height >= ladder.getHeight()) {
            throw new IndexOutOfBoundsException("사다리 높이를 초과했습니다: " + height);
        }

        if (position < 0 || position > ladder.getLines().get(height).getPoints().size()) {
            throw new IndexOutOfBoundsException("잘못된 포지션입니다.: " + position);
        }

        boolean moveRight = position < ladder.getLines().get(height).getPoints().size() &&
                ladder.getLines().get(height).getPoints().get(position).getValue();

        boolean moveLeft = position > 0 && ladder.getLines().get(height).getPoints().get(position - 1).getValue();

        if (moveRight) {
            position++;
        }

        if (moveLeft) {
            position--;
        }

        return position;
    }
}
