package ladder.domain.play;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ItemsTest {
    @ParameterizedTest
    @MethodSource("userListByOnePerson")
    @NullAndEmptySource
    @DisplayName("사다리 참여자 생성 시 참여 갯수는 두 개 이상이어야 한다.")
    void validate_user_list(List<String> items) {
        assertThatThrownBy(() -> Items.of(items))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값은 " + Items.MIN_ITEM_SIZE + "개 이상이어야 합니다.");
    }

    static Stream<Arguments> userListByOnePerson() {
        return Stream.of(arguments(Arrays.asList("pobi")));
    }

    @ParameterizedTest
    @MethodSource("userListByTwoMorePerson")
    @DisplayName("사다리 참여자 생성 시 참여 갯수가 두 개 이상인 경우 정상 생성된다.")
    void create_ladder_items(List<String> items) {
        assertThat(Items.of(items)).isNotNull();
    }

    static Stream<Arguments> userListByTwoMorePerson() {
        return Stream.of(arguments(Arrays.asList("pobi", "honux")));
    }

    @ParameterizedTest
    @MethodSource("indexSuccessCase")
    @DisplayName("Items에서 index 구하기")
    void find_by_index(List<String> names, String name, int index) {
        Items items = Items.of(names);
        assertThat(items.findIndexBy(name)).isEqualTo(index);
    }

    static Stream<Arguments> indexSuccessCase() {
        return Stream.of(
                arguments(Arrays.asList("pobi", "honux"), "pobi", 0),
                arguments(Arrays.asList("pobi", "honux"), "honux", 1));
    }

    @ParameterizedTest
    @MethodSource("indexFailCase")
    @DisplayName("Items에서 요청 값이 없는 경우 유효성 검증")
    void not_find_by_index(List<String> names, String name) {
        Items items = Items.of(names);
        assertThatThrownBy(() -> items.findIndexBy(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 값입니다.");
    }

    static Stream<Arguments> indexFailCase() {
        return Stream.of(
                arguments(Arrays.asList("pobi", "honux"), "crong"));
    }
}