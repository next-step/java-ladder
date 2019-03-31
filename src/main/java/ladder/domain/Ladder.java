package ladder.domain;

import ladder.dto.Gamer;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lines;

    private List<Gamer> gamers;

    public Ladder(int height, int lineCount, List<Gamer> gamers) {
        lines = new ArrayList<>();
        this.gamers = gamers;
        for (int i = 0; i < lineCount; i++) {
            Line line = new Line(height);
            line.createRow();
            lines.add(line);
        }
    }

    public void checkLadder() {
        for (int i = 0; i < lines.size() - 1; i++) {
            lines.get(i).checkLine(lines.get(i + 1));
        }
    }

    public boolean containGamer(String name) throws IllegalArgumentException {
        boolean result = gamers.contains(new Gamer(name));
        if (!result)
            throw new IllegalArgumentException("해당참여자 없음");
        return true;
    }

    public List<Line> getLines() {
        return lines;
    }
}
