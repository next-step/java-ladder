package nextstep.ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.error.exception.LadderHeightSizeException;
import nextstep.ladder.error.exception.UserSizeEmptyException;
import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    public void 높이와_사람의_수가_전달될때_높이와_사람의_수만큼_라인들이_생겨야_한다 (){
        int height = 5;
        int countOfPerson = 4;
        Lines lines = new Lines(height, countOfPerson);

        assertThat(lines.size()).isEqualTo(5);
    }

    @Test
    public void 사다리_높이가_1보다_작을_경우_예외가_발생해야_한다 (){
        assertThatThrownBy(() -> new Lines(0, 3 ))
            .isInstanceOf(LadderHeightSizeException.class)
            .hasMessage("사다리의 높이는 0보다 커야 합니다 입력값: 0");
    }
}
