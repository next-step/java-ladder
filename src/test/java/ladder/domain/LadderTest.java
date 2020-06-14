package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Ladder 클래스 테스트")
class LadderTest {

    @DisplayName("Ladder 객체를 생성할 수 있다.")
    @Test
    void create() {
        String names = "pobi,honux,crong,jk";
        List<String> nameList = Arrays.stream(names.split(",")).collect(Collectors.toList());
        int height = 5;

        Ladder ladder = new Ladder(new Players(nameList), new Height(height), new RandomPointGenerationStrategy());

        assertThat(ladder.getLines()).hasSize(height);
    }
}
