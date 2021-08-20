package nextstep.ladder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static nextstep.ladder.CommonConstans.NUMBER_ZERO;
import static nextstep.ladder.CommonConstans.SEPARATOR_COMMA;

public class ExecuteLadderGame {
    private List<Ladder> ladders = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    public ExecuteLadderGame(String players, int ladderHeight) {
        setPlayers(players.trim().split(SEPARATOR_COMMA));
        setLadders(ladderHeight);
    }


    public static ExecuteLadderGame of(String players, int ladderHeight) {
        return new ExecuteLadderGame(players, ladderHeight);
    }

    private void setPlayers(String[] players) {
        Arrays.stream(players).forEach(player -> this.players.add(Player.of(player)));
    }

    private void setLadders(int ladderHeight) {
        IntStream.range(NUMBER_ZERO, ladderHeight)
                .forEach(row -> ladders.add(Ladder.of(players.size(), new RandomLine())));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<Ladder> getladders() {
        return Collections.unmodifiableList(this.ladders);
    }
}
