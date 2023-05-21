package ladder.domain.model.Param;

import ladder.exception.WinResultsArgumentException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinResultsParamTest {

    @Test
    public void 생성자_테스트() {
        assertThatThrownBy(() -> {
            new WinResultsParam("");
        }).isInstanceOf(WinResultsArgumentException.class)
                .hasMessageContaining("비어 있는 값을 입력하였습니다.");
    }

    @Test
    public void 플레이어인원_결과값_카운트가_동일한지_테스트() {
        assertThatThrownBy(() -> {
            new WinResultsParam("tyoa1, test2, tset3, tset4, test5, test6").convertParamToModel(5);
        }).isInstanceOf(WinResultsArgumentException.class)
                .hasMessageContaining("플레이어 수와 결과 값이 일치하지 않습니다.");

    }
}

