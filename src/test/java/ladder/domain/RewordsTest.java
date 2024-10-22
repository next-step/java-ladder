package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static ladder.domain.RewordTest.r1;
import static ladder.domain.RewordTest.r2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewordsTest {
    public static final Rewords rs1 = new Rewords(List.of(r1, r2));
    public static final Rewords rs2 = new Rewords(List.of(r1));


    @ParameterizedTest
    @DisplayName("범위외에 인덱스를 요청할 때 예외를 발생시킨다.")
    @ValueSource(ints = {-1, 2})
    void 범위외_인덱스_예외(int index) {
        assertThatThrownBy(() -> rs1.get(index))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("해당 인덱스를 반환한다.")
    void 인덱스_반환() {
        assertThat(rs1.get(0)).isEqualTo(r1);
    }

    @Test
    @DisplayName("생성된 사이즈만큼 사이즈를 반환한다.")
    void 객체_사이즈_반환() {
        assertThat(rs1.getSize()).isEqualTo(2);
    }
}
