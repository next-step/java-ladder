package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.model.RandomGeneration;
import nextstep.ladder.domain.model.UnconditionalGeneration;
import org.junit.jupiter.api.Test;

public class LadderLineTest {
  @Test
  public void init() {
    int sizeOfPerson = 5;
    System.out.println(LadderLine.init(sizeOfPerson, RandomGeneration.getInstance()));
  }

  @Test
  public void move() {
    int sizeOfPerson = 6;
    LadderLine line = LadderLine.init(sizeOfPerson, UnconditionalGeneration.getInstance());
    for (int position = 0; position < sizeOfPerson; position++) {
      int nextPosition = position % 2 == 0 ? position + 1 : position - 1;
      assertThat(line.move(position)).isEqualTo(nextPosition);
    }
  }
}