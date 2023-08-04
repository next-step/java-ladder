package ladder.present;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.Column;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Results;
import ladder.domain.Row;
import ladder.domain.Scene;
import ladder.domain.Users;

public class Renderer {

  private static final String SHAPE_OF_PILLAR = "|";
  private static final String SHAPE_OF_EMPTY_LINE = "      ";
  private static final String SHAPE_OF_ALLOCATED_LINE = "------";

  private final int columnLimit;
  private final int rowLimit;
  private final Ladder ladder;
  private final Users users;
  private final Results results;

  private Renderer(int columnLimit, int rowLimit, Ladder ladder, Users users, Results results) {
    this.columnLimit = columnLimit;
    this.rowLimit = rowLimit;
    this.ladder = ladder;
    this.users = users;
    this.results = results;
  }

  public static Renderer of(Ladder ladder, Users users, Results results) {
    return new Renderer(
        ladder.getMaxColumn().getValue(),
        ladder.getMaxRow().getValue(),
        ladder,
        users,
        results
    );
  }

  private String renderingUserArea() {
    return users.names()
        .stream()
        .map(this::unifyWith)
        .collect(Collectors.joining())
        .trim();
  }

  public String renderingResultArea() {
    return results.getOriginalPrizes()
        .stream()
        .map(this::unifyWith)
        .collect(Collectors.joining())
        .trim();
  }

  private String unifyWith(String string) {
    return String.format("%7s", string);
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
    return ladder.existLine(new Line(columnIndex, rowIndex)) ? SHAPE_OF_ALLOCATED_LINE
        : SHAPE_OF_EMPTY_LINE;
  }

  public Scene renderingScene() {
    return new Scene(renderingSceneLadderArea(), renderingUserArea(), renderingResultArea());
  }
}
