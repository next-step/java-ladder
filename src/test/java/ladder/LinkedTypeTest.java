package ladder;

import ladder.domain.LinkedType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedTypeTest {
    @Test
    public void 미연결일때_다음연결_미연결() {
        // given
        LinkedType previous = LinkedType.NEITHER_LINKED;
        // when
        LinkedType next = previous.next(false);
        // then
        assertThat(next.isLeftLinked()).isFalse();
        assertThat(next.isRightLinked()).isFalse();
    }

    @Test
    public void 미연결일때_다음연결_오른쪽연결() {
        // given
        LinkedType previous = LinkedType.NEITHER_LINKED;
        // when
        LinkedType next = previous.next(true);
        // then
        assertThat(next.isLeftLinked()).isFalse();
        assertThat(next.isRightLinked()).isTrue();
    }

    @Test
    public void 첫연결일때() {
        // given
        LinkedType previous1 = LinkedType.first(true);
        LinkedType previous2 = LinkedType.first(false);
        // when
        // then
        assertThat(previous1.isLeftLinked()).isFalse();
        assertThat(previous1.isRightLinked()).isTrue();
        assertThat(previous2.isLeftLinked()).isFalse();
        assertThat(previous2.isRightLinked()).isFalse();
    }

    @Test
    public void 마지막연결일때() {
        // given
        LinkedType previous1 = LinkedType.NEITHER_LINKED;
        LinkedType previous2 = LinkedType.ONLY_LEFT_LINKED;
        LinkedType previous3 = LinkedType.ONLY_RIGHT_LINKED;
        // when
        // then
        assertThat(previous1.last().isRightLinked()).isFalse();
        assertThat(previous2.last().isRightLinked()).isFalse();
        assertThat(previous3.last().isRightLinked()).isFalse();
    }

    @Test
    public void 오른쪽연결일때_다음연결_왼쪽연결() {
        // given
        LinkedType previous = LinkedType.ONLY_RIGHT_LINKED;
        // when
        LinkedType current1 = previous.next(true);
        LinkedType current2 = previous.next(false);
        // then
        assertThat(current1.isLeftLinked()).isTrue();
        assertThat(current1.isRightLinked()).isFalse();
        assertThat(current2.isLeftLinked()).isTrue();
        assertThat(current2.isRightLinked()).isFalse();
    }
}
