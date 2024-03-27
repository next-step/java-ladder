package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PointsFactoryTest {

    @Test
    void 인원수가_주어지면_포인트_컬렉션을반환한다() {
        int countOfPerson = 4;

        List<Point> points = PointsFactory.createBy(countOfPerson);

        assertThat(points).hasSize(4);
    }
}
