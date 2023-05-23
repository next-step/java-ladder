package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class LadderGameTest {
    UserNames userNames;

    @BeforeEach
    void beforeEach() {
        this.userNames = UserNames.of(new String[]{"one", "two", "three"});
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void 사다리게임_생성_테스트(int ladderHeight) throws Exception {
        LadderGame ladderGame = LadderGame.create(new LadderHeight(ladderHeight), userNames);
        assertThat(ladderGame.toList().size()).as("사다리 높이 확인").isEqualTo(ladderHeight);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -12})
    public void 사다리게임_생성_예외_테스트(int ladderHeight) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> LadderGame.create(new LadderHeight(ladderHeight), userNames));
    }
}
