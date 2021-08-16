package ladderGame.view;

import java.util.stream.Collectors;
import ladderGame.dto.PlayersDto;
import ladderGame.model.Line;
import ladderGame.model.Lines;

public class PrintView {

  private static final String STRING_FORMAT_5SIZE = "%5s";

  private static final String HAVING_CONNECTION = "----|";

  private static final String NONE_CONNECTION = "|";

  public static void printUsersName(final PlayersDto playersDto) {
    System.out.println(playersDto.values()
        .stream()
        .map(player -> String.format(STRING_FORMAT_5SIZE, player.getName()))
        .collect(Collectors.joining()));
  }

  public static void createLadderView(final Lines lines) {
    lines.getLines()
        .stream()
        .map(PrintView::printLineData)
        .forEach(System.out::println);
  }

  private static String printLineData(final Line line) {
    return line.getPoints()
        .stream()
        .map(PrintView::printLine)
        .collect(Collectors.joining());
  }

  private static String printLine(final Boolean point) {
    if (point) {
      return String.format(STRING_FORMAT_5SIZE, HAVING_CONNECTION);
    }
    return String.format(STRING_FORMAT_5SIZE, NONE_CONNECTION);
  }
}