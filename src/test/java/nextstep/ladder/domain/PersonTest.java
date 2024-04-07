package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {

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

}
