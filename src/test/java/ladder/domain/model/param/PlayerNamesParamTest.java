package ladder.domain.model.param;

import ladder.exception.PlayerCountArgumentException;
import ladder.exception.PlayerNameArgumentException;
import ladder.param.PlayerNamesParam;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNamesParamTest {

    @Test
    public void 생성자_테스트() {
        assertThatThrownBy(() -> {
            new PlayerNamesParam("");
        }).isInstanceOf(PlayerNameArgumentException.class)
                .hasMessageContaining("비어 있는 값을 입력하였습니다.");
    }

    @Test
    public void 최소인원_테스트() {
        assertThatThrownBy(() -> {
            new PlayerNamesParam("tyoark").convertParamToModel();
        }).isInstanceOf(PlayerCountArgumentException.class)
                .hasMessageContaining("최소인원 보다 작습니다.");

    }
}

