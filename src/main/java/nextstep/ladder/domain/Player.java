package nextstep.ladder.domain;

import nextstep.ladder.view.OutputView;

import java.util.Objects;

public class Player {
  private final String name;
  static final int MAX_NAME_LENGTH = 5;

  public Player(String name) {
    validate(name);
    this.name = name;
  }

  private void validate(String name) {
    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
    }
  }

  public String play(Ladder ladder, int startIndex) {
    int finalIndex = ladder.move(startIndex);
    return ladder.resultAt(finalIndex);
  }

  public static Player of(String name) {
    return new Player(name);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return Objects.equals(name, player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  public String toConsoleOutput() {
    return String.format("%" + OutputView.SPACE_WIDTH + "s", name);
  }
}
