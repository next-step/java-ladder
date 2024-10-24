package ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LadderOld {

    private final List<LineOld> lineOlds;

    public LadderOld(int height, int playerSize) {
        List<LineOld> lineOlds = new ArrayList<>();
        for (int index = 0; index < height; index++) {
            lineOlds.add(new LineOld(playerSize - 1, new RandomLineGenerator()));
        }
        this.lineOlds = lineOlds;
    }

    public LadderOld(List<LineOld> lineOlds) {
        this.lineOlds = lineOlds;
    }

    public LadderResult run(PlayersOld playersOld, InputResult inputResult) {
        HashMap<String, String> ladderResult = new HashMap<>();

        for (int startPoint = 0; startPoint < playersOld.size(); startPoint++) {
            int endPoint = runPerPerson(startPoint);
            ladderResult.put(playersOld.get(startPoint), inputResult.get(endPoint));
        }
        return new LadderResult(ladderResult);
    }

    int runPerPerson(int startPoint) {
        int endPoint = startPoint;
        for (LineOld lineOld : lineOlds) {
            endPoint += lineOld.findNextPoint(endPoint);
        }
        return endPoint;
    }

    public List<LineOld> getLines() {
        return lineOlds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LadderOld))
            return false;
        LadderOld ladderOld = (LadderOld)o;
        return Objects.equals(lineOlds, ladderOld.lineOlds);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lineOlds);
    }
}
