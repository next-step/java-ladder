package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    @DisplayName("getLadderAsString 메서드가 사용자 수만큼의 가로 폭과 지정된 높이만큼의 세로 길이를 가진 사다리 문자열을 반환한다.")
    void getLadderAsStringTest() {
        Users users = Users.from(Set.of("홍길동", "전우치", "고길동"));
        PositiveNumber height = new PositiveNumber(3);
        LadderGame ladderGame = new LadderGame(users, height);

        List<String> ladderAsString = Arrays.stream(ladderGame.getLadderAsString().split("\n"))
                .collect(Collectors.toList());

        for (String row : ladderAsString) {
            long pipeCount = row.chars().filter(it -> it == '|').count();
            assertThat(pipeCount).isEqualTo(users.size());
        }
        assertThat(ladderAsString)
                .hasSize(height.getValue());
    }
}