package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리 생성 시 높이 만큼 라인이 생성되고 입력한 이름 만큼 사람 리스트가 생성 된다.")
    @Test
    void create_ladder() {
        // given
        List<String> nameList = List.of("하하", "호호");
        int height = 5;

        // when
        Ladder ladder = new Ladder(nameList, height);

        // then
        assertThat(ladder.names()).hasSize(nameList.size());
        assertThat(ladder.lines()).hasSize(height);
    }

}
