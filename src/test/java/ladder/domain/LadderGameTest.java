package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    @DisplayName("Element 중 가장 큰 이름 크기의 값을 반환한다.")
    void maxNameSize() {
        Elements elements = new Elements("tom", "tommy", "paul");
        Elements elements2 = new Elements("tom", "안녕하세요", "paul");
        LadderGame ladderGame = new LadderGame(elements, elements2, new Height(5));

        assertThat(ladderGame.maxNameSize()).isEqualTo(10);
    }
}