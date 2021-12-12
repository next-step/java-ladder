package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import nextstep.ladder.exception.CategorySizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class CategoryTest {

    static Stream<Arguments> generate() {
        List<Item> items = new ArrayList<>();
        items.add(StringFactory.item("꽝"));
        items.add(StringFactory.item("꽝"));
        items.add(StringFactory.item("꽝"));
        items.add(StringFactory.item("성공"));

        Players players = new StringAsPlayers("pobi,honux,crong,jk").players();

        return Stream.of(Arguments.of(items, players));
    }

    @ParameterizedTest
    @MethodSource("generate")
    @DisplayName("생성 성공")
    void create(List<Item> items, Players players) {
        assertThat(new Category(items, players)).isInstanceOf(Category.class);
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
