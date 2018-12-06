package dto;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    public void 결과맵초기화() {
        Map<Player,String> result = new HashMap<>();
        result.put(new Player("test1"),"zero");
        result.put(new Player("test2"),"10000");
        GameResult gameResult = new GameResult(result);
        assertThat(gameResult.hasResult()).hasSize(2);
    }

    @Test
    public void 출력테스트() {
        Map<Player,String> result = new HashMap<>();
        result.put(new Player("test1"),"zero");
        result.put(new Player("test2"),"10000");
        GameResult gameResult = new GameResult(result);
        System.out.println(gameResult.toString());
    }
}
