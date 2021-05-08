package nextstep.model;

import java.util.Locale;
import java.util.stream.IntStream;

public class Games {
    private final Ladder ladder;

    public Games(Ladder ladder) {
        this.ladder = ladder;
    }

    public String personResult(String[] names, Players players, Player player, LadderResult ladderResult) {
        if (howMany(names, players, player, ladderResult)) return ladderResult.allResult();

        int resultIndex = start(names, player, ladderResult);
        return ladderResult.resultByIndex(resultIndex);
    }

    private boolean howMany(String[] names, Players players, Player player, LadderResult ladderResult) {
        if (player.player().toLowerCase(Locale.ROOT).equals("all")) {
            for (String name : names) {
                this.start(names, players.filter(name), ladderResult);
            }
            return true;
        }
        return false;
    }

    private int start(String[] names, Player player, LadderResult ladderResult) {
        int playerIndex = userIndex(names, player);
        int resultIndex = playerIndex;

        for (LadderLine ladderLine : this.ladder.ladderLines) {
            Point point = ladderLine.getPoints().get(resultIndex);
            if (point.getDirection().isLeft()) {
                resultIndex--;
            }
            if (point.getDirection().isRight()) {
                resultIndex++;
            }
        }
        ladderResult.setResult(player, ladderResult.resultByIndex(resultIndex));
        return resultIndex;
    }

    private int userIndex(String[] names, Player player) {
        int playerIndex = IntStream.range(0, names.length)
                .filter(i -> player.player().equals(names[i]))
                .findFirst()
                .getAsInt();
        if (playerIndex < 0) {
            throw new IllegalArgumentException("No user");
        }
        return playerIndex;
    }
}
