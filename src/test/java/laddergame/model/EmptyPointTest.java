package laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmptyPointTest {

  @Test
  void getPosition() {
    Point emptyPoint = new EmptyPoint(new Position(0));
    assertThat(emptyPoint.getPosition()).isEqualTo(new Position(0));
  }

  @Test
  void getNextPosition() {
    Point emptyPoint = new EmptyPoint(new Position(0));
    assertThat(emptyPoint.getNextPosition()).isEqualTo(new Position(0));
  }
}