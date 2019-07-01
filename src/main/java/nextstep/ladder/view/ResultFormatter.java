package nextstep.ladder.view;

import nextstep.ladder.model.Game;
import nextstep.ladder.model.Players;

import java.util.stream.IntStream;

public class ResultFormatter implements Formatter<Game> {
    private static final String LINE_CONNECTOR = " : ";

    @Override
    public String format(Game game) {
        StringBuilder builder = new StringBuilder();
        Players players = game.getPlayers();

        IntStream.range(0, players.countOfPlayer())
                .boxed()
                .map(n -> players.getName(n) + LINE_CONNECTOR + game.getPrize(n))
                .map(resultText -> resultText + LineFormatter.LINE_END)
                .forEach(builder::append);

        return builder.toString();
    }
}
