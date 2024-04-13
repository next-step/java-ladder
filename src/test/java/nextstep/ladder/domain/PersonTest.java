package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {

    @Test
    void position() {
        assertThat(new Person("현구막", 0)).isEqualTo(new Person("현구막", 0));
    }

    @DisplayName("참가자는 이름을 갖는다")
    @Test
    void name() {
        assertThat(new Person("현구막")).isEqualTo(new Person("현구막"));
    }

    @DisplayName("참가자의 이름은 NAME_LENGTH_STANDARD를 초과할 수 없다. 초과한다면 IllegalArgumentException을 반환한다 ")
    @Test
    void lessThanFive() {
        String name = "현구막리뷰어님블로그멋있어요";
        assertThatThrownBy(() -> new Person(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("참가자(%s)의 이름 글자수는 NAME_LENGTH_STANDARD를 초과할 수 없습니다", name));
    }

    @DisplayName("참가자의 이름이 null이거나 공백이면 예외를 반환한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void nullAndEmptyNameException(String input) {
        assertThatThrownBy(() -> new Person(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("참가자의 이름은 (%s)와 같이 공백이거나 null일 수 없습니다.", input));
    }

    @DisplayName("처음 주자(position이 0인 주자)가 점(가로선)을 만나면 오른쪽으로 이동한다")
    @Test
    void crossLadderByTrue() {
        Person hyunNineMak = new Person("현구막", new Position(0));

        Rungs rungs = new Rungs(List.of(RungTest.TRUE, RungTest.FALSE));
        hyunNineMak.crossLadder(rungs);

        Assertions.assertThat(hyunNineMak).isEqualTo(new Person("현구막", new Position(1)));
    }

    @DisplayName("처음 주자(position이 0인 주자)가 점(가로선)을 만나지 않으면 가만히 있는다")
    @Test
    void crossLadderByFalse() {
        Person hyunNineMak = new Person("현구막", new Position(0));

        Rungs rungs = new Rungs(List.of(RungTest.FALSE, RungTest.TRUE));
        hyunNineMak.crossLadder(rungs);

        Assertions.assertThat(hyunNineMak).isEqualTo(new Person("현구막", new Position(0)));
    }



}
