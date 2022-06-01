package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LinkTest {
    @Test
    void right() {
        int to = new Link(0, Way.first(true)).move();
        assertThat(to).isEqualTo(1);
    }

    @Test
    void left() {
        int to = new Link(1, Way.first(true).next(false)).move();
        assertThat(to).isEqualTo(0);
    }

//    @Test
//    void invalid() {
//        Link link = new Link(0, Node.first(true).next(false));
//        assertThatThrownBy(() -> link.move()).isInstanceOf(RuntimeException.class);
//    }

    @Test
    void down() {
        int to = new Link(0, Way.first(false).next(false)).move();
        assertThat(to).isEqualTo(0);
    }
}
