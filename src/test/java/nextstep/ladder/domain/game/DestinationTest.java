package nextstep.ladder.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DestinationTest {

    @Test
    @DisplayName("목적지 생성 테스트 - 순서가 같으면 동치는 같고 hashCode는 다르다.")
    void create(){
        Destination destination = Destination.of(Order.from(5), Result.from("꽝"));
        assertThat(destination).isEqualTo(Destination.of(Order.from(5), Result.from("")));
        assertThat(destination.hashCode()).isNotEqualTo(Destination.of(Order.from(5), Result.from("")).hashCode());
    }
}
