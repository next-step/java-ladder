package ladder.domain;

import ladder.dto.Gamer;
import ladder.dto.Result;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lines;

    private List<Gamer> gamers;

    private List<Result> rewards;

    public Ladder(List<Gamer> gamers) {
        this.gamers = gamers;
    }

    public Ladder(int height, int lineCount, List<Gamer> gamers, List<Result> rewards) {
        this.gamers = gamers;
        this.rewards = rewards;
        lines = new ArrayList<>();
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
        deleteLastLineRow();
    }

    public void deleteLastLineRow() {
        lines.get(lines.size() - 1).deleteRow();
    }

    public Gamer containGamer(String name) throws IllegalArgumentException {
        boolean result = gamers.contains(new Gamer(name));
        if (!result)
            throw new IllegalArgumentException("해당참여자 없음");
        return getGamer(name);
    }

    private Gamer getGamer(String name) {
        return gamers.stream()
                .filter(gamer -> gamer.equals(new Gamer(name)))
                .findFirst()
                .get();
    }

    public void matchingReward() {
        for (int i = 0; i < lines.size(); i++) {
            gamers.get(i).setResult(rewards.get(downLine(i, 0)));
        }
    }

    private int downLine(int line, int height) {
        //마지막 높이
        if (height == lines.get(0).getHeight()) {
            return line;
        }

        int nowHeight = height;
        int nowLine = line;
        //왼쪽에 길있음
        if (lines.get(nowLine).getRows().get(nowHeight).isRow()) {
            nowHeight++;
            nowLine++;
        } else if (nowLine > 0 && lines.get(nowLine - 1).getRows().get(nowHeight).isRow()) {
            //오른쪽에 길있음
            nowHeight++;
            nowLine--;
        } else {
            //양쪽 모두 길없음
            nowHeight++;
        }

        return downLine(nowLine, nowHeight);
    }

    public List<Line> getLines() {
        return lines;
    }
}
