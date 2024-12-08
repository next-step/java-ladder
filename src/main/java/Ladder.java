import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final List<String> playerNames;
    private final List<String> resultNames;

    public Ladder(List<Line> lines, String[] playerNames, String[] resultNames) {
        this(lines, List.of(playerNames), List.of(resultNames));
    }

    public Ladder(List<Line> lines, List<String> playerNames, List<String> resultNames) {
        this.lines = lines;
        this.playerNames = playerNames;
        this.resultNames = resultNames;
    }

    public List<TravelResult> travelAll() {
        List<TravelResult> travelResults = new ArrayList<>();

        for (int i = 0; i < playerCount(); i++) {
            travelResults.add(this.travel(i));
        }

        return travelResults;
    }

    public TravelResult travel(String playerName) {
        OptionalInt index = IntStream.range(0, this.playerNames.size())
                .filter(i -> playerName.equals(this.playerNames.get(i)))
                .findFirst();

        if (index.isEmpty()) {
            return new TravelResult("INVALID", "INVALID", Pos.invalid());
        }

        return this.travel(index.getAsInt());
    }

    public TravelResult travel(int startPlayer) {
        Pos resultPos = this.move(startPlayer);

        return new TravelResult(
                this.playerNames.get(startPlayer),
                this.resultNames.get(resultPos.getX()),
                resultPos
        );
    }

    public Pos move(int startX) {
        Pos curPos = new Pos(startX, 0);

        for (Line line : lines) {
            curPos = line.move(curPos.getX());
        }

        return curPos;
    }

    public int height() {
        return lines.size();
    }

    public int playerCount() {
        if (lines.isEmpty()) return 0;

        return lines.get(0).size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (String playerName : playerNames) {
            sb.append("    ");
            sb.append(playerName);
        }
        sb.append("\n");

        for (Line line : lines) {
            sb.append(line.toString());
            sb.append("\n");
        }

        for (String resultName : resultNames) {
            sb.append("    ");
            sb.append(resultName);
        }
        sb.append("\n");

        return sb.toString();
    }
}
