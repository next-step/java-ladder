package ladder.model.dto;

import ladder.model.LadderGameRewords;
import ladder.model.Members;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameInfoTest {

    private Members members;

    @BeforeEach
    void init() {
        members = Members.create("a,b,c,d,e");
    }

    @DisplayName("사다리 게임 실행 정보 생성 테스트")
    @Test
    public void generateLadderTests() {
        assertThatCode(() -> LadderGameInfo.create(members, LadderGameRewords.create("꽝,5000,꽝,3000,2000")))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 실행 정보 테스트 - 참가자 수와 LadderGameRewords 의 갯수가 맞지 않을 때")
    @Test
    public void generateLadderGameExecutionInfoAbnormalTests() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGameInfo.create(members, LadderGameRewords.create("꽝,5000,꽝,3000")))
                .withMessageContaining("참여자와 결과의 갯수는 동일해야 합니다.");
    }
}
