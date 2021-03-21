package laddarGame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private Players players;
    private List<Boolean> line;
    private Random random = new Random();

    public Line(String playerNames) {
        List<Boolean> line = createLine();
        valid(line);
        this.players = new Players(playerNames);
    }

    public Line(String playerNames, List<Boolean> line) {
        this.players = new Players(playerNames);
        valid(line);
        this.line = line;
    }

    private void valid(List<Boolean> line) {
        for (int i = 0; i < line.size(); i++) {
            isDuplicate(line.get(i), line.get(i + 1), conditional());
        }
    }

    private void isDuplicate(boolean curPoint, boolean nextPoint, Conditional conditional) {
        boolean duplicated = conditional.test(curPoint, nextPoint);
        if (duplicated) {
            throw new IllegalArgumentException("가로라인은 두번 연속 나올 수 없습니다.");
        }
    }

    public List<Boolean> createLine() {
        List<Boolean> line = new ArrayList<>();
        boolean lastBoolean = true;
        for (int i = 0; i < players.playerCount(); i++) {
            boolean randomBoolean = random();
            lastBoolean = addLine(lastBoolean, randomBoolean, conditional());
            line.add(lastBoolean);
        }
        return line;
    }

    public Conditional conditional() {
        return (last, random) -> last == true && random == true;
    }

    private boolean addLine(boolean lastBoolean, boolean randomBoolean, Conditional conditional) {
        if (conditional.test(lastBoolean, randomBoolean)) {
            return false;
        }
        return randomBoolean;
    }

    public boolean random() {
        return random.nextBoolean();
    }
}

