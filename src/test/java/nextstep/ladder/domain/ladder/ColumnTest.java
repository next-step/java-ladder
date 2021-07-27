package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.Fixture.ALWAYS_GENERATE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 한 행에서 기둥을 담당하는 컬럼 클래스 테스트")
class ColumnTest {

    @DisplayName("기본적으로 컬럼은 발판 생성 전략을 가지고 초기화를 한다.")
    @Test
    void init() {
        assertThat(Column.init(ALWAYS_GENERATE_STRATEGY)).isInstanceOf(Column.class);
    }

    @DisplayName("첫번 째 컬럼은 하나의 스텝을 가진다.")
    void initFirstColumn() {

    }

    @DisplayName("두번째 부터 마지막 전 컬럼 까지는 이전 컬럼의 스텝 종류에 영향을 받아 생성한다.")
    void initMiddleColumn() {

    }

    @DisplayName("마지막 컬럼 이전 컬럼의 스텝 종류에 영향을 받아 생성한다.")
    void initLastColumn() {

    }
}
