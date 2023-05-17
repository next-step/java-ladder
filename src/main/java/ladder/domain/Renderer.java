package ladder.domain;

import ladder.control.Preferences;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Renderer {
    private final int columnLimit;
    private final int rowLimit;
    private final Lines lines;
    private final Users users;

    public Renderer(int columnLimit, int rowLimit, Lines lines, Users users) {
        this.columnLimit = columnLimit;
        this.rowLimit = rowLimit;
        this.lines = lines;
        this.users = users;
    }

    private List<String> renderingSceneLadderArea() {
        return IntStream.range(0, rowLimit)
                .mapToObj(rowIndex -> renderingHorizontal(Row.of(rowIndex), columnLimit))
                .collect(Collectors.toList());
    }

    private String renderingHorizontal(Row rowIndex, int range) {
        return IntStream.range(0, range)
                .mapToObj(columnIndex -> renderingPixel( Column.of(columnIndex), rowIndex))
                .collect(Collectors.joining());
    }

    private String renderingPixel(Column columnIndex, Row rowIndex) {
        return Preferences.pillarShape()
                .concat(lineShape(columnIndex, rowIndex));
    }

    private String lineShape(Column columnIndex, Row rowIndex) {
        return lines.existLine(new Line(columnIndex,rowIndex)) ? Preferences.allocatedLineShape() : Preferences.emptyLineShape();
    }

    public Scene renderingSceneWithUser() {
        return new Scene(renderingSceneLadderArea(),renderingSceneUserArea());
    }

    private String renderingSceneUserArea() {
        return users.names().stream()
                .collect(Collectors.joining(Preferences.userDelimiter()));
    }
}
