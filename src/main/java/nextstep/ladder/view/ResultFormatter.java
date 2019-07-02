package nextstep.ladder.view;

import nextstep.ladder.model.GameResult;
import nextstep.ladder.model.Players;

import java.util.stream.IntStream;

public class ResultFormatter implements Formatter<GameResult> {
    private static final String LINE_CONNECTOR = " : ";

    @Override
    public String format(GameResult gameResult) {
        StringBuilder builder = new StringBuilder();
        Players players = gameResult.getPlayers();

        IntStream.range(0, players.countOfPlayer())
                .boxed()
                .map(n -> players.getName(n) + LINE_CONNECTOR + gameResult.getPrize(n))
                .map(resultText -> resultText + LineFormatter.LINE_END)
                .forEach(builder::append);

        return builder.toString();
    }
}
