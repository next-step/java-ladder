package ladder.domain.item;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemsTest {

    @Test
    @DisplayName("이름들을 받아 사다리 결과들을 생성한다.")
    void Items_ItemNames() {
        final List<String> itemNames = List.of("item1", "item2", "item3");
        final Items items = Items.from(itemNames);

        assertThat(items.names())
                .containsExactlyElementsOf(itemNames);
    }

    @Test
    @DisplayName("사다리 결과가 하나도 없는 경우 예외를 던진다.")
    void Items_EmptyItemNames_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Items.from(List.of()));
    }

    @Test
    @DisplayName("포지션에 해당하는 사다리 결과를 반환한다.")
    void Get_ItemAtPosition() {
        final Items items = Items.from(List.of("item1", "item2", "item3"));

        assertThat(items.get(1))
                .isEqualTo(new Item("item2"));
    }

    @Test
    @DisplayName("포지션에 해당하는 사다리 결과가 없는 경우 예외를 던진다.")
    void Get_NoItemAtPosition_Exception() {
        final Items items = Items.from(List.of("item1", "item2", "item3"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> items.get(3));
    }
}
