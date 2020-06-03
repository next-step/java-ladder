package nextstep.ladder.domain;

public class Ladder {

    private final Players players;
    private final Lines lines;

    private Ladder(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    public static Ladder newInstance(Players players, Lines lines) {
        validatePlayers(players);
        validateLines(lines);

        return new Ladder(players, lines);
    }

    private static void validatePlayers(Players players) {
        if (players == null) {
            throw new IllegalArgumentException("참여자 정보가 존재하지 않습니다.");
        }
    }

    private static void validateLines(Lines lines) {
        if (lines == null) {
            throw new IllegalArgumentException("사다리 라인 정보가 존재하지 않습니다.");
        }
    }

    public Players getPlayers() {
        return this.players;
    }

    public Lines getLines() {
        return this.lines;
    }
}
