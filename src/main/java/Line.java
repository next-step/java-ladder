import java.util.ArrayList;
import java.util.List;

public class Line {
    private final int lineNumber;
    private final List<Cross> crosses;

    public Line(int lineNumber, List<Boolean> currents) {
        this.lineNumber = lineNumber;
        this.crosses = new ArrayList<>();

        if (currents.isEmpty()) { return; }

        Cross curCross = Cross.first(currents.get(0), this.lineNumber);
        this.crosses.add(curCross);

        for (int i = 1; i < currents.size(); i++) {
            curCross = curCross.add(currents.get(i));

            this.crosses.add(curCross);
        }

        this.crosses.add(curCross.last());
    }

    public Pos move(int startX) {
        Pos curPos = new Pos(startX, this.lineNumber);
        Pos prevPos = curPos;

        while(!curPos.yIs(this.lineNumber + 1)) {
            Pos nextPos = this.crosses.get(curPos.getX()).move(prevPos);

            prevPos = curPos;
            curPos = nextPos;
        }

        return curPos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Cross cross : this.crosses) {
            sb.append(cross.toString());
            sb.append(" ");
        }

        return sb.toString();
    }

    public int size() {
        return this.crosses.size();
    }
}
