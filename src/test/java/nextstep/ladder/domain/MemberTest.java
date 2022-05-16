package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.CannotNullOrEmptyException;
import nextstep.ladder.domain.exceptions.ExceedMaxNameLengthException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberTest {

    @Nested
    class 생성자는 {

        @Nested
        class null혹은_빈값이_주어진경우 {

            @ParameterizedTest
            @NullAndEmptySource
            void CannotNullOrEmptyException을_던진다(String nullOrEmptySource) {
                assertThatThrownBy(() -> new Member(nullOrEmptySource))
                        .isInstanceOf(CannotNullOrEmptyException.class);
            }

        }

        @Nested
        class _5글자가넘는_문자열이_주어질경우 {

            @ParameterizedTest
            @ValueSource(strings = {"123456"})
            void ExceedMaxNameLengthException을_던진다(String name) {
                assertThatThrownBy(() -> new Member(name))
                        .isInstanceOf(ExceedMaxNameLengthException.class);
            }

        }
    }

    @Nested
    class toString_메서드는 {

        @Test
        void 이름을_리턴한다() {
            String name = "name";

            Member member = new Member(name);

            assertThat(member.toString()).isEqualTo(name);
        }
    }
}
