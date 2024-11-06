package nextstep.ladder.service;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class LadderGameService {
    public Stream<Player> createPlayers(List<String> names) {
        return names.stream()
                .map(Player::new);
    }

    public Ladder createLadder(int height, int width) {
        return Ladder.createLadder(height, width);
    }

    public Stream<Prize> createPrizes(List<String> prizes) {
        return prizes.stream()
                .map(Prize::new);
    }

    public LadderGameResult play(List<Player> players, List<Prize> prizes, Ladder ladder) {
        LadderGameResult result;

        ladder.move();

        ListIterator<Player> playersIterator = players.listIterator();
        result = new OrderedLadderGameResult();

        playersIterator.forEachRemaining(player -> {
            result.add(player, prizes.get(ladder.getEndPoint(playersIterator.nextIndex())));
            playersIterator.next();
        });

        return result;
    }

    public Prize getPrizeByPlayer(LadderGameResult result, String playerName) {
        return result.findByPlayer(playerName);
    }
}
