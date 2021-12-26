package nextstep.ladder.model;

import java.util.Objects;

public class Ladder {

    private final Players players;
    private final Lines lines;
    private final Results results;

    public Ladder(Players players, Lines lines, Results results) {
        validationIsNull(players, lines, results);
        this.players = players;
        this.lines = lines;
        this.results = results;
    }

    private void validationIsNull(Players players, Lines lines, Results results) {
        if (Objects.isNull(players) || Objects.isNull(lines) || Objects.isNull(results)) {
            throw new IllegalArgumentException("사다리게임 생성 요소가 부족합니다.");
        }
    }

    public Report game() {
        players.move(lines);
        return new Report(players, results);
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
