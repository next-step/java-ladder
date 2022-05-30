package nextstep.ladder.domain.member;

import nextstep.ladder.domain.line.point.Points;
import nextstep.ladder.domain.member.position.Position;
import nextstep.ladder.domain.runresult.RunResult;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberTest {
    public static final Member POBI = new Member("pobi", new Position(0, 10));
    public static final Member JASON = new Member("jason", new Position(1, 10));
    public static final Member PANG = new Member("pang", new Position(2, 10));
    public static final Member NEM = new Member("nem", new Position(3, 10));

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
                        new Member("pang", new Position(3, 11))
                );
            }
        }
    }

    @Nested
    class matchName_메서드는 {

        @Nested
        class 일치하는_이름이_주어질경우 {

            @Test
            void true를_리턴한다() {
                assertThat(PANG.matchName("pang")).isTrue();
            }

        }

        @Nested
        class 일치하지않는_이름이_주어질경우 {

            @Test
            void false를_리턴한다() {
                assertThat(PANG.matchName("xxx")).isFalse();
            }

        }
    }

    @Nested
    class getRunResult_메서드는 {

        @Nested
        class 포지션안에_해당하는_실행결과목록이_주어질경우 {

            @Test
            void 리턴한다() {
                List<RunResult> runResults = List.of(
                        new RunResult("꽝"),
                        new RunResult("3000"),
                        new RunResult("꽝"),
                        new RunResult("5000")
                );

                RunResult runResult = PANG.getRunResult(runResults);

                assertThat(runResult).isEqualTo(new RunResult("꽝"));
            }
        }
    }
}
