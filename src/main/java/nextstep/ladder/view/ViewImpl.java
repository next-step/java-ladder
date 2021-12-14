package nextstep.ladder.view;

import nextstep.ladder.domain.entity.Ladder;
import nextstep.ladder.domain.entity.LadderHeight;
import nextstep.ladder.domain.entity.Line;
import nextstep.ladder.domain.entity.Name;
import nextstep.ladder.domain.entity.Names;
import nextstep.ladder.domain.entity.Point;
import nextstep.ladder.domain.entity.Prize;
import nextstep.ladder.domain.entity.Symbol;
import nextstep.ladder.domain.entity.PrizeGroup;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class ViewImpl implements View {

  private static final String RESULT_MESSAGE = "실행결과";
  private static final int INIT = 0;
  private static final int FIRST_INDEX = 1;
  private static final int INIT_LADDER_SIZE = 2;
  private static final int LADDER_SIZE = 5;
  private static final int MAX_BLANK_SIZE = 6;
  private static final String RESULT_DELIMITER = "   :   ";
  private static final String ALL = "all";

  private final InputView inputView;
  private final ResultView resultView;
  private final StringBuilder stringBuilder = new StringBuilder();

  public ViewImpl(InputView inputView, ResultView resultView) {
    this.inputView = inputView;
    this.resultView = resultView;
  }

  @Override
  public Names getNames() {
    return inputView.inputNames();
  }

  @Override
  public PrizeGroup getResults(Names names) {
    return inputView.inputWinner(names);
  }

  @Override
  public String getTarget() {
    return inputView.inputTarget();
  }

  @Override
  public LadderHeight getLadderHeight() {
    return inputView.inputLadderHeight();
  }

  @Override
  public void printLadder(Names names, Ladder ladder) {
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
    if (line.size() == INIT_LADDER_SIZE) {
      return printLineOnlyOne(line);
    }

    return line.stream()
               .skip(FIRST_INDEX)
               .limit(line.size() - INIT_LADDER_SIZE)
               .map(this::printPoint)
               .collect(
                         joining(
                                 Symbol.VERTICAL_LINE.getValue(),
                                 Symbol.VERTICAL_LINE.getValue(),
                                 Symbol.VERTICAL_LINE.getValue()));
  }

  private String printLineOnlyOne(Line line) {
    return line.stream()
               .map(point -> Symbol.BLANK.getValue())
               .collect(joining(Symbol.VERTICAL_LINE.getValue()));
  }

  private String printPoint(Point point) {
    if (point.hasWay()) {
      return Symbol.printSymbolAsSize(Symbol.DASH, LADDER_SIZE);
    }

    return Symbol.printSymbolAsSize(Symbol.BLANK, LADDER_SIZE);
  }

  @Override
  public void printPrize(PrizeGroup prizeGroup) {
    String collect = prizeGroup.stream()
            .map(Prize::getRank)
            .map(rank -> rank.concat(Symbol.printSymbolAsSize(Symbol.BLANK, MAX_BLANK_SIZE - rank.length())))
            .collect(joining());

    System.out.println(collect);
  }

  @Override
  public void printResult(Map<String, Integer> resultMap, PrizeGroup prizeGroup) {
    String target = getTarget();

    while (!target.equals(ALL)) {
      Integer index = resultMap.get(target);
      Prize prize = prizeGroup.getResult(index - FIRST_INDEX);

      resultView.printMessage(toResult(target, prize.getRank()));
      target = getTarget();
    }

    resultView.printMessage(toResult(resultMap, prizeGroup));
  }

  private String toResult(Map<String, Integer> resultMap, PrizeGroup prizeGroup) {
    stringBuilder.setLength(INIT);

    resultMap.forEach((key, index) -> stringBuilder.append(key)
             .append(RESULT_DELIMITER)
             .append(prizeGroup.getResult(index - FIRST_INDEX)
                            .getRank())
             .append(System.lineSeparator()));

    return stringBuilder.toString();
  }

  private String toResult(String name, String prize) {
    stringBuilder.setLength(INIT);

    stringBuilder.append(name)
                 .append(RESULT_DELIMITER)
                 .append(prize);

    return stringBuilder.toString();
  }

}
