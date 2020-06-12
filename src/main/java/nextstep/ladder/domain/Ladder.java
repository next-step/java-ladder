package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private List<Player> players;
    private List<Line> ladders;

    private Ladder(List<String> userNames, Integer ladderHeight) {
        this.players = new ArrayList<>();
        this.ladders = new ArrayList<>();

        initializePlayers(userNames);
        Integer countOfPerson = userNames.size();
        IntStream.range(0, ladderHeight).forEach(i -> initializeLadderLine(countOfPerson));
    }

    private void initializePlayers(List<String> userNames) {
        userNames.forEach(userName -> {
            Player player = Player.of(userName);
            this.players.add(player);
        });
    }

    private void initializeLadderLine(Integer countOfPerson) {
        Line line = new Line(countOfPerson, new RandomMountingBlockGenerator());
        this.ladders.add(line);
    }

    public static Ladder of(List<String> userNames, Integer ladderHeight) {
        return new Ladder(userNames, ladderHeight);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Line> getLadders() {
        return ladders;
    }
}
