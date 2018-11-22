package domain;

import util.GenerateLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {

    private final List<Line> lines;
    private final Players players;
    private final int countOfPlayer;
    private final GenerateLine generateLine;

    public Ladder(final Players players, final int countOfPlayer, final GenerateLine generateLine) {

        this.lines = new ArrayList<>();
        this.players = players;
        this.countOfPlayer = countOfPlayer;
        this.generateLine = generateLine;

        addFirstLine();
        addMiddleLine();
        addLastLine();

    }

    public List<Line> getLines() {
        return lines;
    }

    public int getCountOfPlayer() {
        return countOfPlayer;
    }

    private void addFirstLine() {
        for (int i = 0; i < this.players.calculatorPlayersLength(); i++) {
            if (i == 0) {
                this.lines.add(Line.fromFirst(this.countOfPlayer, this.generateLine));
            }
        }
    }

    private void addMiddleLine() {
        for (int i = 1; i < this.players.calculatorPlayersLength(); i++) {
            Line line = this.lines.get(i - 1);
            this.lines.add(Line.fromMiddle(this.countOfPlayer, line, this.generateLine));
        }
    }

    private void addLastLine() {
        for (int i = 0; i <= this.players.calculatorPlayersLength(); i++) {
            if (i == this.players.calculatorPlayersLength() - 1) {
                this.lines.add(Line.fromLast(this.countOfPlayer, this.generateLine));
            }
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Ladder ladder = (Ladder) o;
        return countOfPlayer == ladder.countOfPlayer &&
                Objects.equals(lines, ladder.lines) &&
                Objects.equals(players, ladder.players) &&
                Objects.equals(generateLine, ladder.generateLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines, players, countOfPlayer, generateLine);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ladder{");
        sb.append("lines=").append(lines);
        sb.append(", players=").append(players);
        sb.append(", countOfPlayer=").append(countOfPlayer);
        sb.append(", generateLine=").append(generateLine);
        sb.append('}');
        return sb.toString();
    }

}
