package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {"4,5"}, delimiter = ',')
    @DisplayName("사다리 생성 테스트")
    void createLadderTest(int userCount, int ladderHeight) {
        LadderGenerator ladderGenerator = LadderGenerator.create(userCount, ladderHeight);
        Ladder ladder = ladderGenerator.make();

        assertThat(ladder.getLadder()).hasSize(ladderHeight);
    }
}
