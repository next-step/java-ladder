package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {
    Ladder ladder;

    @BeforeEach
    private void before() {
        Members members = Members.from("pobi,mouse,kiti");
        ladder = Ladder.of(members, new LadderLayer(2), () -> true);
    }

    @Test
    public void move() {
        System.out.println(ladder);
        assertThat(ladder.move(0)).isEqualTo(0);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {-1, 4, 3})
    public void move_위치_오입력_IllegalArgumentException(int param) {
        assertThatThrownBy(() -> {
            ladder.move(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
