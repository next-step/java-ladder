package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.exception.PersonCountTooLowException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

  LineCreationStrategy lineCreationStrategy;

  @BeforeEach
  void setUp() {
    lineCreationStrategy = () -> Stream.of(new Point(true), new Point(false))
        .collect(Collectors.toList());
  }

  @Test
  @DisplayName("사람의 수를 입력받아서 Line을 생성한다.")
  void create() {
    //given
    final int countOfPerson = 2;

    //when
    final Line line = new Line(countOfPerson, lineCreationStrategy);

    //then
    assertThat(line).isEqualTo(new Line(countOfPerson, lineCreationStrategy));
  }

  @Test
  @DisplayName("사람의 수는 최소 2명이어야 한다.")
  void createFailWhenUnderTwoPerson() {
    assertAll(
        () -> assertThatThrownBy(() -> new Line(0, lineCreationStrategy))
            .isInstanceOf(PersonCountTooLowException.class)
            .hasMessage(PersonCountTooLowException.PERSON_COUNT_TOO_LOW),
        () -> assertThatThrownBy(() -> new Line(1, lineCreationStrategy))
            .isInstanceOf(PersonCountTooLowException.class)
            .hasMessage(PersonCountTooLowException.PERSON_COUNT_TOO_LOW)
    );
  }
}
