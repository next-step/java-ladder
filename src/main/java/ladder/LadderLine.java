package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {

    private List<Boolean> ladderLine;
    private Random random;

    public LadderLine(int playersCount) {
        this.random = new Random();
        this.ladderLine = lineGenerator(playersCount);
    }

    // line 생성
    private List<Boolean> lineGenerator(int playersCount) {
        List<Boolean> lineMaterial = new ArrayList<>();
        lineMaterial.add(random.nextBoolean());
        for (int i = 1; i < playersCount-1; i++) {
            lineMaterial.add(lineChecker(lineMaterial.get(i - 1)));
        }
        return lineMaterial;
    }

    private boolean lineChecker(boolean line) {
        return line ? false : random.nextBoolean();
    }

    public int size() {
        return ladderLine.size();
    }

    public List<Boolean> getLadderLine() {
        return ladderLine;
    }
}
