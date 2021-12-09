package nextstep.ladder.view;

import nextstep.ladder.domain.entity.Ladder;
import nextstep.ladder.domain.entity.LadderHeight;
import nextstep.ladder.domain.entity.Line;
import nextstep.ladder.domain.entity.Name;
import nextstep.ladder.domain.entity.Names;
import nextstep.ladder.domain.entity.Point;
import nextstep.ladder.domain.entity.Symbol;

import static java.util.stream.Collectors.joining;

public class ViewImpl implements View {

  private static final String RESULT_MESSAGE = "실행결과";
  private static final int ONE = 1;

  private final InputView inputView;
  private final ResultView resultView;

  public ViewImpl(InputView inputView, ResultView resultView) {
    this.inputView = inputView;
    this.resultView = resultView;
  }

  @Override
  public Names getNames() {
    return inputView.inputNames();
  }

  @Override
  public LadderHeight getLadderHeight() {
    return inputView.inputLadderHeight();
  }

  @Override
  public void printResult(Names names, Ladder ladder) {
    resultView.printMessage(RESULT_MESSAGE);
    resultView.printMessage(printNames(names));
    resultView.printMessage(printLadder(names, ladder));
  }

  private String printNames(Names names) {
    return names.stream()
            .map(Name::tellName)
            .collect(joining(Symbol.BLANK.getValue()));
  }

  private String printLadder(Names names, Ladder ladder) {
    return ladder.stream()
                 .map(line -> printLine(line, names.maxSize()))
                 .collect(joining(System.lineSeparator()));
  }

  private String printLine(Line line, int size) {
    String collectPoint = line.stream()
                              .skip(ONE)
                              .map(point -> printPoint(point, size))
                              .collect(joining(Symbol.VERTICAL_LINE.getValue()));

    return Symbol.VERTICAL_LINE.getValue().concat(collectPoint).concat(Symbol.VERTICAL_LINE.getValue());
  }

  private String printPoint(Point point, int size) {
    if (point.hasWay()) {
      return Symbol.printSymbolAsSize(Symbol.DASH, size);
    }

    return Symbol.printSymbolAsSize(Symbol.BLANK, size);
  }

}
