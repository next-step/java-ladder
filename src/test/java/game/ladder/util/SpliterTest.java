package game.ladder.util;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SpliterTest {

    @Test
    public void 붙어있는_콤마() {
        String line = "a,b,c,d";

        List<String> split = Spliter.split(line);

        assertThat(split).hasSize(4).containsSequence("a","b","c","d");
    }

    @Test
    public void 콤마_뒤만_떨어져_있을때() {
        String line = "a, b, c, d";

        List<String> split = Spliter.split(line);

        assertThat(split).hasSize(4).containsSequence("a","b","c","d");
    }

    @Test
    public void 콤마_앞에만_떨어져_있을때() {
        String line = "a ,b ,c ,d";

        List<String> split = Spliter.split(line);

        assertThat(split).hasSize(4).containsSequence("a","b","c","d");
    }

    @Test
    public void 불규칙하게_떨어져_있을때() {
        String line = "a ,   b ,c,   d";

        List<String> split = Spliter.split(line);

        assertThat(split).hasSize(4).containsSequence("a","b","c","d");
    }
}