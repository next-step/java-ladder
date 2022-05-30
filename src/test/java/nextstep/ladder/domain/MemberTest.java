package nextstep.ladder.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberTest {
    public static final Member POBI = new Member("pobi");
    public static final Member JASON = new Member("jason");
    public static final Member PANG = new Member("pang");
    public static final Member NEM = new Member("nem");

    @Nested
    class toString_메서드는 {

        @Test
        void 이름을_리턴한다() {
            assertThat(PANG.toString()).isEqualTo("pang");
        }
    }

    @Nested
    class move_메서드는 {

        @Nested
        class points가_주어지면 {

            @Test
            void 이동_혹은_정지한다() {
                PANG.move(Points.of(Arrays.asList(
                        true, false, true
                )));

                assertThat(PANG).isEqualTo(
                        new Member("pang", new Position(1, 1))
                );
            }
        }
    }
}
