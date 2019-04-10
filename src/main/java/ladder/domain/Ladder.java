package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(int countOfPerson, int height) {
        this.ladder = generateLadder(countOfPerson, height);
    }

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    private List<Line> generateLadder(int countOfPerson, int height) {
        List<Line> lines = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
        return lines;
    }

    public Results playLadder(Players players, Winnings winnings) {
        List<Result> results = new ArrayList<>();
        Iterator<Player> playerIterator = players.iterator();
        while(playerIterator.hasNext()) {
            Player player = playerIterator.next();
            int playResult = player.playLadder(this);
            results.add(new Result(player.toString().trim(), winnings.valueOf(playResult).toString()));
        }

        return new Results(results);
    }

    public int ladderHeight() {
        return ladder.size();
    }

    public int lineCount() {
        return ladder.get(0).lineCount();
    }

    public Line getLine(int index) {
        return ladder.get(index);
    }

    public Iterator<Line> iterator() {
        return ladder.iterator();
    }
}
