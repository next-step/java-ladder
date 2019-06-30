import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final String ESTABLISHED_LADDER = createLadderLineString("-");
    private static final String NOT_ESTABLISHED_LADDER = createLadderLineString(" ");
    private static final String LADDER_GUTTER = "|";

    private final List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    private static String createLadderLineString(String lineString) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < LadderPlayerName.MAX_PLAYER_NAME_LENGTH; i++) {
            builder.append(lineString);
        }

        return builder.toString();
    }

    private String buildLineString(LadderLine ladderLine) {
        StringBuilder builder = new StringBuilder();
        String leftBlank = String.format("%4s", " ");

        builder.append(leftBlank);

        ladderLine.getEstablishResults()
                  .stream()
                  .map(bool -> bool ? ESTABLISHED_LADDER : NOT_ESTABLISHED_LADDER)
                  .forEach(stringLine -> builder.append(LADDER_GUTTER).append(stringLine));

        builder.append(LADDER_GUTTER);

        return builder.toString();
    }

    public static Ladder of(int countOfColumn, int ladderHeight) {
        List<LadderLine> ladderLines = IntStream.range(0, ladderHeight)
                                                .mapToObj(index -> LadderLine.of(countOfColumn))
                                                .collect(Collectors.toList());

        return new Ladder(ladderLines);
    }

    @Override
    public String toString() {
        return this.ladderLines.stream()
                               .map(this::buildLineString)
                               .collect(Collectors.joining("\n"));
    }
}
