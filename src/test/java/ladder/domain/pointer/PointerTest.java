package ladder.domain.pointer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import ladder.domain.moving.Moving;
import ladder.domain.name.Name;
import ladder.domain.pointer.Pointer;
import ladder.domain.position.Position;
import org.junit.jupiter.api.Test;

class PointerTest {

    @Test
    void 한줄내려가기() {
        Pointer actual = Pointer.of(Name.of("name"), Position.of(1, 1));

        assertAll(
            () -> assertThat(actual.move(Moving.LEFT)).isEqualTo(Pointer.of(Name.of("name"), Position.of(2, 0))),
            () -> assertThat(actual.move(Moving.RIGHT)).isEqualTo(Pointer.of(Name.of("name"), Position.of(2, 2))),
            () -> assertThat(actual.move(Moving.FORWARD)).isEqualTo(Pointer.of(Name.of("name"), Position.of(2, 1))),
            () -> assertThat(actual.move(Moving.STOP)).isEqualTo(Pointer.of(Name.of("name"), Position.of(1, 1)))
        );
    }

    @Test
    void 포인터생성() {
        Pointer actual = Pointer.of(Name.of("player"), Position.of(0, 0));
        assertThat(actual).isEqualTo(Pointer.of(Name.of("player"), Position.of(0, 0)));
    }

}