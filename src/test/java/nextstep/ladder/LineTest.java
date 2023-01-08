package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Members;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    @DisplayName("라인 생성 테스트")
    void lineSizeTest(){
        Members members = new Members("11,22,33,44");
        Line line = new Line(members);
        assertThat(members.getSize()).isEqualTo(4);
    }

    @Test
    @DisplayName("첫번째값은 false 테스트")
    void lineFirstValueTest(){
        Members members = new Members("11");
        Line line = new Line(members);
        assertThat(line.getPoints().get(0)).isEqualTo(false);
    }
}
