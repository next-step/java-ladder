package ladder.domain;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Renderer {
    private static final String SHAPE_OF_PILLAR = "|";
    private static final String SHAPE_OF_EMPTY_LINE = "      ";
    private static final String SHAPE_OF_ALLOCATED_LINE = "------";
    private static final String USERS_DELIMITER = ", ";

    private final int columnLimit;
    private final int rowLimit;
    private final Ladder ladder;
    private final Users users;

    public Renderer(int columnLimit, int rowLimit, Ladder ladder, Users users) {
        this.columnLimit = columnLimit;
        this.rowLimit = rowLimit;
        this.ladder = ladder;
        this.users = users;
    }

    private List<String> renderingSceneLadderArea() {
        return IntStream.range(0, rowLimit)
                .mapToObj(rowIndex -> renderingHorizontal(Row.of(rowIndex), columnLimit))
                .collect(Collectors.toList());
    }

    private String renderingHorizontal(Row rowIndex, int range) {
        return IntStream.range(0, range)
                .mapToObj(columnIndex -> renderingPixel(Column.of(columnIndex), rowIndex))
                .collect(Collectors.joining());
    }

    private String renderingPixel(Column columnIndex, Row rowIndex) {
        return SHAPE_OF_PILLAR.concat(lineShape(columnIndex, rowIndex));
    }

    private String lineShape(Column columnIndex, Row rowIndex) {
        return ladder.existLine(new Line(columnIndex, rowIndex)) ? SHAPE_OF_ALLOCATED_LINE : SHAPE_OF_EMPTY_LINE;
    }

    public Scene renderingSceneWithUser() {
        return new Scene(renderingSceneLadderArea(), renderingSceneUserArea());
    }

    private String renderingSceneUserArea() {
        return users.names().stream()
                .collect(Collectors.joining(USERS_DELIMITER));
    }
}
