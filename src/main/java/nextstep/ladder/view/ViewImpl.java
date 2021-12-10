package nextstep.ladder.view;

import nextstep.ladder.domain.entity.Ladder;
import nextstep.ladder.domain.entity.LadderHeight;
import nextstep.ladder.domain.entity.Line;
import nextstep.ladder.domain.entity.Name;
import nextstep.ladder.domain.entity.Names;
import nextstep.ladder.domain.entity.Point;
import nextstep.ladder.domain.entity.Symbol;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class ViewImpl implements View {

  private static final String RESULT_MESSAGE = "실행결과";
  private static final int FIRST_INDEX = 1;
  private static final int LADDER_SIZE = 5;
  private static final int MAX_BLANK_SIZE = 6;

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
    resultView.printMessage(printLadder(ladder));
  }

  private String printNames(Names names) {
    return names.stream()
                .map(Name::tellName)
                .map(name -> name.concat(Symbol.printSymbolAsSize(Symbol.BLANK, MAX_BLANK_SIZE - name.length())))
                .collect(Collectors.joining());
  }

  private String printLadder(Ladder ladder) {
    return ladder.stream()
                 .map(this::printLine)
                 .collect(joining(System.lineSeparator()));
  }

  private String printLine(Line line) {
    return line.stream().skip(FIRST_INDEX)
                        .map(this::printPoint)
                        .collect(
                                  joining(
                                          Symbol.VERTICAL_LINE.getValue(),
                                          Symbol.VERTICAL_LINE.getValue(),
                                          Symbol.VERTICAL_LINE.getValue()));
  }

  private String printPoint(Point point) {
    if (point.hasWay()) {
      return Symbol.printSymbolAsSize(Symbol.DASH, LADDER_SIZE);
    }

    return Symbol.printSymbolAsSize(Symbol.BLANK, LADDER_SIZE);
  }

}
