package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class WinningPrizeTest {

    @DisplayName("플레이어 이름, 최종 위치를 키,값의 형태를 플레이어 이름, 당첨 상품의 키,값 형태로 바꾼다.")
    @Test
    void findWinningPrizeBy() {
        // given
        List<String> prizes = List.of("꽝", "5000", "꽝", "3000");
        WinningPrize winningPrize = new WinningPrize(prizes);

        Map<String, Integer> pointByName = new LinkedHashMap<>();
        IntStream.range(0, prizes.size())
            .forEach(i -> pointByName.put(String.valueOf(i), i));

        // when
        Map<String, String> prizeByName = winningPrize.convertPointToPrize(pointByName);

        // then
        IntStream.range(0, prizes.size())
            .forEach(i -> assertThat(prizeByName.get(String.valueOf(i))).isEqualTo(prizes.get(i)));
    }
}
