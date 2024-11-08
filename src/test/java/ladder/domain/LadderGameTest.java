package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private  static  Players FIVE_PLAYERS = new Players(new String[]{"a","b","c","d","e"});
    private  static  Players THREE_PLAYERS = new Players(new String[]{"a","b","c"});
    private static String[] THREE_RESULTS = new String[]{"꽝", "천원", "2천원"};
    @Test
    void create() {
        LadderGame ladderGame = new LadderGame(6, FIVE_PLAYERS, new RandomDecision());
        assertThat(ladderGame.getLines()).hasSize(6);
    }
    class TestDecision implements BridgeDecision {
        private Stack<Boolean> stack;

        public TestDecision(Stack<Boolean> stack) {
            this.stack = stack;
        }
        @Override
        public Boolean isBridgeTarge() {
            return stack.pop();
        }
    }
    private static Stack getTestStack() {
        Stack<Boolean> stack = new Stack<>();
        stack.push(true);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        return stack;
    }
    @Test
    void getAllPlayerResult() {
        LadderGame ladderGame = new LadderGame(4, THREE_PLAYERS, new TestDecision(getTestStack()));
        Map<String, String> result = ladderGame.getAllPlayerResult(THREE_RESULTS);
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.keySet().containsAll(List.of("a","b","c")));
        assertThat(result.entrySet().containsAll(Arrays.asList(THREE_RESULTS)));
        assertThat(result.get(THREE_PLAYERS.getPlayerNames().get(0))).isEqualTo(THREE_RESULTS[2]);
        assertThat(result.get(THREE_PLAYERS.getPlayerNames().get(1))).isEqualTo(THREE_RESULTS[0]);
        assertThat(result.get(THREE_PLAYERS.getPlayerNames().get(2))).isEqualTo(THREE_RESULTS[1]);
    }
}
