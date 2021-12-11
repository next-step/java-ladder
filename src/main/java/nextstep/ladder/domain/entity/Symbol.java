package nextstep.ladder.domain.entity;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum Symbol {

  EMPTY_BLANK(""),
  BLANK(" "),
  DASH("-"),
  VERTICAL_LINE("|");

  private static final int ZERO = 0;

  private final String value;

  Symbol(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static String printSymbolAsSize(Symbol symbol, int size) {
    return IntStream.range(ZERO, size)
                    .mapToObj(idx -> symbol.getValue())
                    .collect(Collectors.joining(EMPTY_BLANK.getValue()));
  }

}
