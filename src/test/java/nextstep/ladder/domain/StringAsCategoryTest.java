package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import nextstep.ladder.exception.CategorySizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringAsCategoryTest {

    @ParameterizedTest
    @CsvSource(value = {"kim,dong,hyo,jo:꽝,5000,꽝,3000", "dong,hyo:꽝,5000", "jo,kim,lee,hee,hyo:꽝,5000,꽝,3000,꽝"}, delimiter = ':')
    @DisplayName("생성 성공")
    void create(String player, String item) {
        Players players = new StringAsPlayers(player).players();
        Category category = new StringAsCategory(item).category(players);

        assertThat(category).isInstanceOf(Category.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"kim,dong:꽝,5000,꽝,3000", "dong,hyo,kim:꽝,5000", "jo,kim,lee,hee,hyo:꽝,5000"}, delimiter = ':')
    @DisplayName("players 사이즈랑 일치하지 않을 경우 예외처리")
    void executionResultSizeException(String player, String item) {
        Players players = new StringAsPlayers(player).players();

        assertThatExceptionOfType(CategorySizeException.class)
            .isThrownBy(() -> new StringAsCategory(item).category(players));
    }

}
