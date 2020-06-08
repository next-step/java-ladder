package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RewordsTest {

    private Rewords rewords = Rewords.newInstance(Arrays.asList(
            Reword.newInstance("1000"),
            Reword.newInstance("꽝"),
            Reword.newInstance("2000")
    ), 3);

    @DisplayName("보상 리스트가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateRewordsIfRewordsIsNull() {
        assertThatThrownBy(() -> Rewords.newInstance(null, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보상 리스트 수와 참여자 수가 다르면 생성할 수 없다.")
    @Test
    void canNotCreateRewordsIfRewordCountNotEqPlayerCount() {
        assertThatThrownBy(() -> {
            List<Reword> rewords = Arrays.asList(Reword.newInstance("1000"));
            Rewords.newInstance(rewords, 2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보상 리스트에 유효하지 않은 보상이 있을 경우 생성할 수 없다.")
    @Test
    void canNotCreateRewordsIfRewordsContainsNull() {
        assertThatThrownBy(() -> {
            List<Reword> rewords = Arrays.asList(Reword.newInstance("1000"), null);
            Rewords.newInstance(rewords, 2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("객체를 생성할 수 있다.")
    @Test
    void canCreateRewords() {
        assertThat(this.rewords).isInstanceOf(Rewords.class);
    }

    @DisplayName("보상 리스트를 얻을 수 있다.")
    @Test
    void canToList() {
        assertThat(this.rewords.toList()).isInstanceOf(List.class);
    }

    @DisplayName("해당 위치의 보상을 얻을 수 있다,")
    @ParameterizedTest
    @MethodSource("generatePosition")
    void canFindByPosition(Position position, String result) {
        assertThat(this.rewords.findByPosition(position).toString()).isEqualTo(result);
    }

    static Stream<Arguments> generatePosition() {
        return Stream.of(
                Arguments.of(Position.newInstance(0), "1000"),
                Arguments.of(Position.newInstance(1), "꽝"),
                Arguments.of(Position.newInstance(2), "2000")
        );
    }
}
