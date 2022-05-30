package nextstep.ladder.domain.member;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MembersTest {
    public static final Members members = new Members(Arrays.asList(
            MemberTest.POBI,
            MemberTest.JASON,
            MemberTest.PANG,
            MemberTest.NEM
    ));

    @Nested
    class toString_메서드는 {

        @Test
        void 이름_목록을_리턴한다() {
            assertThat(members.toString()).isEqualTo("[pobi, jason, pang, nem]");
        }

    }

    @Nested
    class getPrettyString_메서드는 {

        @Test
        void 이름_길이에따라_공백이생긴_문자열을_리턴한다() {
            assertThat(members.getPrettyString()).isEqualTo("pobi  jason pang  nem");
        }
    }

    @Nested
    class size_메서드는 {

        @Test
        void 이름_길이를_리턴한다() {
            assertThat(members.size()).isEqualTo(4);
        }
    }

    @Nested
    class findByName_메서드는 {

        @Nested
        class 존재하는_멤버의_이름이_주어질경우 {

            @Test
            void 해당_멤버를_리턴한다() {
                Member pobi = members.findByName("pobi");

                assertThat(pobi).isEqualTo(MemberTest.POBI);
            }
        }

        @Nested
        class 존재하지않는_멤버의_이름이_주어질경우 {

            @Test
            void IllegalArgumentException을_던진다() {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> members.findByName("xxx"));
            }
        }
    }
}
