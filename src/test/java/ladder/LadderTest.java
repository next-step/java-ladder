package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.Index;
import ladder.domain.Ladder;
import ladder.domain.LadderLine;
import ladder.domain.Point;
import ladder.exception.LadderHeightException;
import ladder.strategy.NoMovableStrategy;

class LadderTest {
    @DisplayName("참여할_사람의_인원_수와_사다리_높이가_주어지면_사다리_높이만큼의_Line객체를_가진_Ladder가_생성된다")
    @Test
    void newLadderTest() {
        int countOfPerson = 4;
        int height = 5;
        Ladder ladder = Ladder.from(countOfPerson, height, new NoMovableStrategy());

        assertThat(ladder).isInstanceOf(Ladder.class);
        assertThat(ladder.toList().size()).isEqualTo(height);
    }

    @DisplayName("사다리_높이가_0이하이면_예외가_발생한다")
    @Test
    void exceptionTest() {
        int countOfPerson = 4;
        int height = 0;
        assertThatThrownBy(() -> Ladder.from(countOfPerson, height, new NoMovableStrategy())).isInstanceOf(LadderHeightException.class);
    }

    @DisplayName("사다리와 시작인덱스가 주어진다면, 결과인덱스값을 알 수 있다")
    @Test
    void resultIndexOfTest() {
        // 기본 사다리 생성 |-----|
        List<Point> points = new ArrayList<>();
        points.add(Point.first(true));
        points.add(points.get(0).next(false));
        points.add(points.get(1).next(true));
        points.add(points.get(2).last());

        List<LadderLine> ladderLines = Collections.singletonList(LadderLine.from(points));
        Ladder ladder = Ladder.from(ladderLines);
        assertThat(ladder.resultIndexOf(Index.from(0))).isEqualTo(1);
        assertThat(ladder.resultIndexOf(Index.from(1))).isEqualTo(0);
    }

    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson, new NoMovableStrategy()));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2,  new NoMovableStrategy());
        System.out.println("ladder result : " + line.move(0));
    }
}
