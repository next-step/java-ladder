package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {
    @DisplayName("객체 생성 테스트")
    @Test
    void create() {
        Names names = Names.from("kjh,yuu,sin,han");
        Height height = new Height(5);
        Ladder ladder = Ladder.of(names.entryMemberCount(), height, () -> true);

        GameResult expected = new GameResult(ladder, names);

        assertThat(expected).isNotNull();
    }

    @DisplayName("사다리에 따른 게임결과가 맞는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "false:kjh:0", "false:yuu:1", "false:sin:2", "false:han:3",
            "true:kjh:1", "true:yuu:0", "true:sin:3", "true:han:2"} , delimiter = ':')
    void gameResultIndexTest(boolean strategy, Name name, int index) {
        Names names = Names.from("kjh,yuu,sin,han");
        Height height = new Height(1);
        // 사다리
        // | | | |
        Ladder ladder = Ladder.of(names.entryMemberCount(), height, () -> strategy);

        GameResult expected = new GameResult(ladder, names);

        assertThat(expected.getResultIndex(name)).isEqualTo(index);
    }
}
