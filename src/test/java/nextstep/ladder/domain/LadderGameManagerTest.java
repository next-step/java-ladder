package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameManagerTest {

    @ParameterizedTest
    @CsvSource(value = {"test1,test2,test3,test4:5:4"}, delimiter = ':')
    @DisplayName("사다리게임매니져의 생성테스트")
    void createLadderGameManagerTest(String userNames, int ladderHeight, int userCount) {
        LadderGameManager ladderGameManager = LadderGameManager.create(userNames, ladderHeight);

        assertThat(ladderGameManager.getLadderHeight()).isEqualTo(ladderHeight);
        assertThat(ladderGameManager.getUsers()).hasSize(userCount);
    }
}
