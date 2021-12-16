package nextstep.ladder.model;

public class Ladder {

    private final Players players;
    private final Lines lines;
    private final Results results;

    public Ladder(Players players, Lines lines, Results results) {
        this.players = players;
        this.lines = lines;
        this.results = results;
    }


    public Players getPlayers() {
        return players;
    }

    public Lines getLines() {
        return lines;
    }

    public Results getResults() {
        return results;
    }
}
