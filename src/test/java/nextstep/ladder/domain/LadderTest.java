package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {"4,5"}, delimiter = ',')
    @DisplayName("사다리 생성 테스트")
    void createLadderTest(int userCount, int height) {
        Users users = Users.create("test1,test2,test3,test4");
        LadderHeight ladderHeight = LadderHeight.create(height);
        LadderGenerator ladderGenerator = LadderGenerator.create(users, ladderHeight);
        Ladder ladder = ladderGenerator.make();

        assertThat(ladder.getLadder()).hasSize(height);
    }
}
