package nextstep.ladder.service;

import nextstep.ladder.domain.*;

import java.util.List;
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
        return new LadderGame(players, prizes, ladder).play();
    }

    public Prize getPrizeByPlayer(LadderGameResult result, String playerName) {
        return result.findByPlayer(playerName);
    }
}
