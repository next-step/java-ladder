package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {

    @Test
    @DisplayName("사람 이름 5글자 초과시 IllegalArgumentException 발생 테스트")
    void nameMaxLengthOverTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player("abcdef"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사람 이름이 null 이거나 빈 값일 경우 IllegalArgumentException 발생 테스트")
    void nameIsNull(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player(input));
    }


    @Test
    @DisplayName("index 값 일치 테스트")
    void indexEqualsTest() {
        Player player = new Player("test", Index.ONE);
        assertThat(player.getIndex()).isEqualTo(new Index(Index.ONE));
    }

    @ParameterizedTest
    @CsvSource(value = {"3,true", "2,true", "1,false", "4,false"})
    @DisplayName("인접한 Point가 있는지 확인")
    void isAdjacentTest(int input, boolean output) {

        Player player = new Player("test", 3);
        Index index = new Index(input);
        assertThat(player.isAdjacent(index)).isEqualTo(output);
    }
}