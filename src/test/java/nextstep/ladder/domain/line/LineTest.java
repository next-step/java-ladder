package nextstep.ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 한_라인은_사람의_수보다_하나_작게_생성되어야_한다() {
        int countOfPerson = 6;
        Line line = new Line(countOfPerson);

        assertThat(line.size()).isEqualTo(countOfPerson - 1);
    }

    @Test
    void 이전_사다리_상태가_Truu라면_다음_상태는_True일수_없다()
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        Line line = new Line(5); // 예시로 사용할 Line 객체 생성
        Method addLineValue = Line.class.getDeclaredMethod("addLineValue",
            LadderConstructionStatus.class);
        addLineValue.setAccessible(true);

        LadderConstructionStatus ladderConstructionStatus = new LadderConstructionStatus(true);

        //when
        LadderConstructionStatus actual = (LadderConstructionStatus) addLineValue.invoke(line,
            ladderConstructionStatus);

        //then
        assertThat(actual.isLadderConstructionStatus()).isEqualTo(false);
    }
}
