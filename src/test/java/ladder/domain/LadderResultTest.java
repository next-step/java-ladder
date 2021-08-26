package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class LadderResultTest {

    @Test
    public void String을_받아서_Result_객체를_생성할_수_있다(){
        //given
        //when
        LadderResult ladderResult = LadderResult.create("꽝");
        //then
        assertThat(ladderResult).isEqualTo(LadderResult.create("꽝"));
    }

    @Test
    public void 꽝_또는_금액이_아니면_익셉션이_발생한다(){
        //given
        //when
        //then
        assertThatThrownBy(() -> LadderResult.create("ㅎㅎ"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("꽝 또는 금액을 입력해 주세요. 입력된 결괏값 : ㅎㅎ");
    }

    @Test
    public void 꽝이_아니고_금액일_때_금액이_음수이면_익셉션이_발생한다(){
        //given
        //when
        //then
        assertThatThrownBy(() -> LadderResult.create("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 음수일 수 없습니다.");
    }
}
