package ladder.domain;

import ladder.exception.InvalidNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static ladder.domain.Name.NOT_ALLOW_EMPTY_NAME_MESSAGE;
import static ladder.domain.Name.NOT_ALLOW_EXCEED_MAX_NAME_LENGTH_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerNameTest {

    @Test
    @DisplayName("이름을 생성한다")
    void create() {
        Name actual = new PlayerName("pobi");
        Name expected = new PlayerName("pobi");
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "이름 생성 오류: 공백이 입력되었을 경우 이름생성 오류가 발생한다")
    @NullAndEmptySource
    void create_공백_실패(String emptyName) {
        assertThatThrownBy(() -> {
                    new PlayerName(emptyName);
                }).isInstanceOf(InvalidNameException.class)
                .hasMessage(NOT_ALLOW_EMPTY_NAME_MESSAGE);
    }

    @Test
    @DisplayName("이름 생성 오류: 5글자를 초과하면 이름생성 오류가 발생한다")
    void create_5글자초과_실패() {
        assertThatThrownBy(() -> {
            Name name = new PlayerName("pobi22");
        }).isInstanceOf(InvalidNameException.class)
                .hasMessage(NOT_ALLOW_EXCEED_MAX_NAME_LENGTH_MESSAGE);
    }

    @Test
    @DisplayName("이름의 길이를 출력한다")
    void length() {
        Name name = new PlayerName("pobi");
        int actual = name.length();
        assertThat(actual).isEqualTo(4);
    }

    @Test
    @DisplayName("이름을 출력한다")
    void name() {
        Name name = new PlayerName("pobi");
        String actual = name.name();

        assertThat(actual).isEqualTo("pobi");
    }
}
