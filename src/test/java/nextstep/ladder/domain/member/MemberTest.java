package nextstep.ladder.domain.member;

import nextstep.ladder.domain.line.point.Points;
import nextstep.ladder.domain.member.position.Position;
import nextstep.ladder.domain.runresult.RunResult;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MemberTest {
    public static final Member POBI = new Member("pobi", new Position(0, 10));
    public static final Member JASON = new Member("jason", new Position(1, 10));
    public static final Member PANG = new Member("pang", new Position(2, 10));
    public static final Member NEM = new Member("nem", new Position(3, 10));

    public static Member create(String name) {
        return new Member(name);
    }

    private static Member createPang() {
        return create("pang");
    }

    @Nested
    class toString_메서드는 {

        @Test
        void 이름을_리턴한다() {
            Member pang = createPang();

            assertThat(pang.toString()).isEqualTo("pang");
        }
    }

    @Nested
    class move_메서드는 {

        @Nested
        class points가_주어지면 {

            @Test
            void 이동_혹은_정지한다() {
                Member pang = createPang();

                pang.move(Points.of(Arrays.asList(
                        true, false, true
                )));

                assertThat(pang).isEqualTo(
                        new Member("pang", new Position(1, 1))
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
                Member pang = createPang();

                assertThat(pang.matchName("pang")).isTrue();
            }

        }

        @Nested
        class 일치하지않는_이름이_주어질경우 {

            @Test
            void false를_리턴한다() {
                Member pang = createPang();

                assertThat(pang.matchName("xxx")).isFalse();
            }

        }
    }

    @Nested
    class getRunResult_메서드는 {

        @Nested
        class 포지션안에_해당하는_실행결과목록이_주어질경우 {

            @Test
            void 찾은_실형결과를_리턴한다() {
                Member pang = createPang();
                List<RunResult> runResults = List.of(
                        new RunResult("꽝"),
                        new RunResult("3000"),
                        new RunResult("꽝"),
                        new RunResult("5000")
                );

                RunResult runResult = pang.getRunResult(runResults);

                assertThat(runResult).isEqualTo(new RunResult("꽝"));
            }


        }

        @Nested
        class 포지션에_없는_실형결과목록이_주어질경우 {

            @Test
            void IllegalArgumentException을_던진다() {
                Member pang = createPang();

                assertThatIllegalArgumentException()
                        .isThrownBy(() -> pang.getRunResult(List.of()));
            }
        }

    }
}
