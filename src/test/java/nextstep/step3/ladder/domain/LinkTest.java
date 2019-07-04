package nextstep.step3.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-30 03:09
 */
public class LinkTest {
    @DisplayName("Link 생성 예외 - current가 0번째 (왼쪽노드가 없을때)")
    @Test
    void createException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Link(0, false, true);
        }).withMessageContaining("왼쪽노드가 유효하지 않습니다. (0번째 Link의 왼쪽노드는 flase만 허용합니다.)");
    }

    @DisplayName("Link 생성 예외 - current와 left의 상태가 둘다 ture일 경우")
    @Test
    void createTrueException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Link(1, true, true);
        }).withMessageContaining("현재 Link와 Left Link가 모두 true면 안됩니다.");
    }

    @DisplayName("첫 번째 Link 생성")
    @Test
    void createFirst() {
        assertThat(Link.first(() -> true).matchIndex(0)).isTrue();
    }

    @DisplayName("다음 Link 생성")
    @Test
    void createNext() {
        Link link = Link.first(() -> true);
        assertThat(Link.next(link, () -> false).matchIndex(1)).isTrue();
    }

    @DisplayName("마지막 Link 생성")
    @Test
    void createLast() {
        Link link = Link.first(() -> true);
        assertThat(Link.last(link).matchIndex(1)).isTrue();
    }

    @DisplayName("이동을 확인한다 - true")
    @Test
    void moveTrue() {
        Link link = new Link(0, true, false);
        assertThat(link.move()).isEqualTo(1);
    }

    @DisplayName("이동을 확인한다 - false")
    @Test
    void moveFalse() {
        Link link = new Link(0, false, false);
        assertThat(link.move()).isEqualTo(0);
    }

    @DisplayName("이동을 확인한다 - 본인은 false, 왼쪽 Link는 true")
    @Test
    void moveFalseAndBeforeLinkTrue() {
        Link link = new Link(1, false, true);
        assertThat(link.move()).isEqualTo(0);
    }

    @DisplayName("현재 Link의 상태를 확인한다.")
    @Test
    void checkStatus() {
        assertThat(Link.first(() -> true).status()).isTrue();
    }
}
