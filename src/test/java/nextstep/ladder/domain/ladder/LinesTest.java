package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.generator.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    @DisplayName("높이만큼 lines 리스트를 생성한다.")
    void test01() {
        int height = 5;
        Lines lines = Lines.create(height, 2);

        assertThat(lines.getRows()).hasSize(height);
    }

    @Test
    @DisplayName("사용자 수보다 하나작은 points 를 생성한다.")
    void test02() {
        int height = 5;
        int userCount = 5;
        Lines lines = Lines.create(height, userCount);

        assertThat(lines.getRows().get(0).getConnectionStatuses()).hasSize(userCount - 1);
    }

    @Test
    @DisplayName("크기를 반환한다.")
    void test03() {
        int height = 5;
        int userCount = 5;
        Lines lines = Lines.create(height, userCount);
        assertThat(lines.size()).isEqualTo(height);
    }

    @Test
    @DisplayName("특정 위치의 연결여부를 반환한다.")
    void test04() {
        Points points = Points.initialize(3, new RandomBooleanGenerator());
        Lines lines = new Lines(List.of(points));
        assertThat(lines.getRow(0)).isEqualTo(points);
    }

}
