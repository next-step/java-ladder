package nextstep.ladder.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Nested
    class toString_메서드는 {

        @Test
        void 이름을_리턴한다() {
            String name = "name";

            Member member = new Member(name);

            assertThat(member.toString()).isEqualTo(name);
        }
    }

    @Nested
    class move_메서드는 {

        @Nested
        class points가_주어지면 {

            @Test
            void 이동_혹은_정지한다() {
                Member member = new Member("pobi");

                member.move(Points.of(Arrays.asList(
                        true, false, true
                )));

                assertThat(member).isEqualTo(
                        new Member("pobi", new Position(1, 1))
                );
            }
        }
    }
}
