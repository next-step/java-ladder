package ladder;

import static laddergame.domain.line.LineStatus.CONNECTION;
import static laddergame.domain.line.LineStatus.DETACHMENT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.ArrayList;
import java.util.List;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderGame;
import laddergame.domain.line.Line;
import laddergame.domain.person.Participants;
import laddergame.domain.results.ResultMatcher;
import laddergame.domain.results.Results;
import laddergame.utils.CommaSplit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LadderResultTest {

    @DisplayName("실행 결과를 추가할 수 있다")
    @Test
    void test1() throws Exception {
        //given
        String result = "1000,2000,0,10000";
        String[] strings = CommaSplit.of(result);

        //when
        Results results = new Results(strings);

        //then
        then(results.get()).contains("1000", "2000", "0", "10000");
    }

    @DisplayName("참가자 수와 실행 결과의 수가 일치하지 않으면 예외를 던진다.")
    @Test
    void test2() throws Exception {
        var persons = Participants.of(new String[]{"a"});
        var lines = new ArrayList<>(List.of(new Line(List.of(DETACHMENT))));
        var ladder = new Ladder(lines);
        var ladderGame = LadderGame.create(ladder, persons);
        var results = new Results(new String[]{"1000", "0"});

        assertThatThrownBy(() -> {
            new ResultMatcher(ladderGame, results);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("실행결과와 참가자 수 가 일치하지 않습니다.");
    }

    @DisplayName("참가자들과 일치하는 이름을 입력하지 않으면 예외를 던진다.")
    @Test
    void test3() throws Exception {
        var persons = Participants.of(new String[]{"a", "b"});
        var lines = new ArrayList<>(List.of(new Line(List.of(DETACHMENT))));
        var ladder = new Ladder(lines);
        var ladderGame = LadderGame.create(ladder, persons);
        var results = new Results(new String[]{"1000", "0"});

        ResultMatcher resultMatcher = new ResultMatcher(ladderGame, results);

        assertThatThrownBy(() -> {
            resultMatcher.match("c");
        })
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("찾을 수 없는 참가자 입니다.");
    }

    @Nested
    @DisplayName("참여자가 짝수일 경우")
    class Ladder_Particiapants2 {

        @DisplayName(" line이 다면, 첫 번째 사람이 첫 번째 결과에 매칭된다. ")
        @Test
        void test5() throws Exception {
            //given
            var persons = Participants.of(new String[]{"a", "b"});
            var lines = new ArrayList<>(List.of(new Line(List.of(DETACHMENT))));
            var ladder = new Ladder(lines);
            var ladderGame = LadderGame.create(ladder, persons);
            var results = new Results(new String[]{"1000", "0"});

            //when
            var resultMatcher = new ResultMatcher(ladderGame, results);

            then(resultMatcher.match("a")).isEqualTo("1000");
            then(resultMatcher.match("b")).isEqualTo("0");
        }

        @DisplayName(" line 1개가 연결돼 있으면, 첫 번째 사람이 마지막 결과에 매칭된다. ")
        @Test
        void test2() throws Exception {
            //given
            var persons = Participants.of(new String[]{"a", "b"});
            var lines = new ArrayList<>(List.of(new Line(List.of(CONNECTION))));
            var ladder = new Ladder(lines);
            var ladderGame = LadderGame.create(ladder, persons);
            var results = new Results(new String[]{"1000", "0"});

            //when
            var resultMatcher = new ResultMatcher(ladderGame, results);

            then(resultMatcher.match("a")).isEqualTo("0");
            then(resultMatcher.match("b")).isEqualTo("1000");
        }

        @DisplayName(" line 2개가 연결되어 있으면, 첫 번째 사람이 첫 번째 결과에 매칭된다. ")
        @Test
        void test3() throws Exception {
            //given
            var persons = Participants.of(new String[]{"a", "b"});
            var lines = new ArrayList<>(
                List.of(
                    new Line(List.of(CONNECTION)),
                    new Line(List.of(CONNECTION))
                )
            );
            var ladder = new Ladder(lines);
            var ladderGame = LadderGame.create(ladder, persons);
            var results = new Results(new String[]{"1000", "0"});

            //when
            ResultMatcher resultMatcher = new ResultMatcher(ladderGame, results);

            //then
            then(resultMatcher.match("a")).isEqualTo("1000");
            then(resultMatcher.match("b")).isEqualTo("0");
        }

        @DisplayName(" line 3개가 연결되어 있으면, 첫 번째 사람이 마지막 결과에 매칭된다. ")
        @Test
        void test4() throws Exception {
            //given
            var persons = Participants.of(new String[]{"a", "b"});
            var lines = new ArrayList<>(
                List.of(
                    new Line(List.of(CONNECTION)),
                    new Line(List.of(CONNECTION)),
                    new Line(List.of(CONNECTION))
                )
            );
            var ladder = new Ladder(lines);
            var ladderGame = LadderGame.create(ladder, persons);
            var results = new Results(new String[]{"1000", "0"});

            //when
            ResultMatcher resultMatcher = new ResultMatcher(ladderGame, results);

            //then
            then(resultMatcher.match("a")).isEqualTo("0");
            then(resultMatcher.match("b")).isEqualTo("1000");
        }
    }

    @Nested
    @DisplayName("참여자가 홀수(a,b,c)일 경우")
    class Participants3 {

        /*
          a b c
          |-| |

        */
        @DisplayName("line이 1개가 a,b 사이에 있을 경우 a는 두 번째 결과, b는 첫 번째 결과, c는 세번째 결과를 갖는다.")
        @Test
        void test1() throws Exception {
            //given
            var persons = Participants.of(new String[]{"a", "b", "c"});
            var lines = new ArrayList<>(
                List.of(
                    new Line(List.of(CONNECTION, DETACHMENT))
                )
            );
            var ladder = new Ladder(lines);
            var ladderGame = LadderGame.create(ladder, persons);
            var results = new Results(new String[]{"1", "2", "3"});

            //when
            ResultMatcher resultMatcher = new ResultMatcher(ladderGame, results);

            //then
            assertSoftly(soft -> {
                soft.assertThat(resultMatcher.match("a")).isEqualTo("2");
                soft.assertThat(resultMatcher.match("b")).isEqualTo("1");
                soft.assertThat(resultMatcher.match("c")).isEqualTo("3");
            });
        }

        @DisplayName("line이 1개가 b,c 사이에 있을 경우 a는 첫 번째 결과, b는 세 번째 결과, c는  두 번째 결과를 갖는다.")
        @Test
        void test2() throws Exception {
            //given
            var persons = Participants.of(new String[]{"a", "b", "c"});
            var lines = new ArrayList<>(
                List.of(
                    new Line(List.of(DETACHMENT, CONNECTION))
                )
            );
            var ladder = new Ladder(lines);
            var ladderGame = LadderGame.create(ladder, persons);
            var results = new Results(new String[]{"1", "2", "3"});

            //when
            ResultMatcher resultMatcher = new ResultMatcher(ladderGame, results);

            //then
            assertSoftly(soft -> {
                soft.assertThat(resultMatcher.match("a")).isEqualTo("1");
                soft.assertThat(resultMatcher.match("b")).isEqualTo("3");
                soft.assertThat(resultMatcher.match("c")).isEqualTo("2");
            });
        }

        @DisplayName("line이 2개가 a,b 사이에 있을 경우 a는 첫 번째 결과, b는 두 번째 결과, c는  세 번째 결과를 갖는다.")
        @Test
        void test3() throws Exception {
            //given
            var persons = Participants.of(new String[]{"a", "b", "c"});
            var lines = new ArrayList<>(
                List.of(
                    new Line(List.of(CONNECTION, DETACHMENT)),
                    new Line(List.of(CONNECTION, DETACHMENT))
                )
            );
            var ladder = new Ladder(lines);
            var ladderGame = LadderGame.create(ladder, persons);
            var results = new Results(new String[]{"1", "2", "3"});

            //when
            ResultMatcher resultMatcher = new ResultMatcher(ladderGame, results);

            //then
            assertSoftly(soft -> {
                soft.assertThat(resultMatcher.match("a")).isEqualTo("1");
                soft.assertThat(resultMatcher.match("b")).isEqualTo("2");
                soft.assertThat(resultMatcher.match("c")).isEqualTo("3");
                soft.assertThat(resultMatcher.matchAll())
                    .containsEntry("a", "1")
                    .containsEntry("b", "2")
                    .containsEntry("c", "3");
            });
        }

        @DisplayName("line이 2개가 b,c 사이에 있을 경우 a는 첫 번째 결과, b는 두 번째 결과, c는  세 번째 결과를 갖는다.")
        @Test
        void test4() throws Exception {
            //given
            var persons = Participants.of(new String[]{"a", "b", "c"});
            var lines = new ArrayList<>(
                List.of(
                    new Line(List.of(DETACHMENT, CONNECTION)),
                    new Line(List.of(DETACHMENT, CONNECTION))
                )
            );
            var ladder = new Ladder(lines);
            var ladderGame = LadderGame.create(ladder, persons);
            var results = new Results(new String[]{"1", "2", "3"});

            //when
            ResultMatcher resultMatcher = new ResultMatcher(ladderGame, results);

            //then
            assertSoftly(soft -> {
                soft.assertThat(resultMatcher.match("a")).isEqualTo("1");
                soft.assertThat(resultMatcher.match("b")).isEqualTo("2");
                soft.assertThat(resultMatcher.match("c")).isEqualTo("3");
            });
        }

        @DisplayName("line이 2개가 (a,b), (c,b) 사이에 있을 경우 a는 세 번째 결과, b는 첫 번째 결과, c는 두 번째 결과를 갖는다.")
        @Test
        void test5() throws Exception {
            //given
            var persons = Participants.of(new String[]{"a", "b", "c"});
            var lines = new ArrayList<>(
                List.of(
                    new Line(List.of(CONNECTION, DETACHMENT)),
                    new Line(List.of(DETACHMENT, CONNECTION))
                )
            );
            var ladder = new Ladder(lines);
            var ladderGame = LadderGame.create(ladder, persons);
            var results = new Results(new String[]{"1", "2", "3"});

            //when
            ResultMatcher resultMatcher = new ResultMatcher(ladderGame, results);

            //then
            assertSoftly(soft -> {
                soft.assertThat(resultMatcher.match("a")).isEqualTo("3");
                soft.assertThat(resultMatcher.match("b")).isEqualTo("1");
                soft.assertThat(resultMatcher.match("c")).isEqualTo("2");
            });
        }

        @DisplayName("line이 2개가 (c,b), (a,b) 사이에 있을 경우 a는 두 번째 결과, b는 세 번째 결과, c는 첫 번째 결과를 갖는다.")
        @Test
        void test9() throws Exception {
            //given
            var persons = Participants.of(new String[]{"a", "b", "c"});
            var lines = new ArrayList<>(
                List.of(
                    new Line(List.of(DETACHMENT, CONNECTION)),
                    new Line(List.of(CONNECTION, DETACHMENT))
                )
            );
            var ladder = new Ladder(lines);
            var ladderGame = LadderGame.create(ladder, persons);
            var results = new Results(new String[]{"1", "2", "3"});

            //when
            ResultMatcher resultMatcher = new ResultMatcher(ladderGame, results);

            //then
            assertSoftly(soft -> {
                soft.assertThat(resultMatcher.match("a")).isEqualTo("2");
                soft.assertThat(resultMatcher.match("b")).isEqualTo("3");
                soft.assertThat(resultMatcher.match("c")).isEqualTo("1");
            });
        }


        /*
            a b c
            |-| |
            | |-|
            |-| |
        */
        @DisplayName("line이 3개가 (a,b), (c,d), (a,b) 사이에 있을 경우 a는 세 번째 결과, b는 두 번째 결과, c는 첫 번째 결과를 갖는다.")
        @Test
        void test6() throws Exception {
            //given
            var persons = Participants.of(new String[]{"a", "b", "c"});
            var lines = new ArrayList<>(
                List.of(
                    new Line(List.of(CONNECTION, DETACHMENT)),
                    new Line(List.of(DETACHMENT, CONNECTION)),
                    new Line(List.of(CONNECTION, DETACHMENT))
                )
            );
            var ladder = new Ladder(lines);
            var ladderGame = LadderGame.create(ladder, persons);
            var results = new Results(new String[]{"1", "2", "3"});

            //when
            ResultMatcher resultMatcher = new ResultMatcher(ladderGame, results);

            //then
            assertSoftly(soft -> {
                soft.assertThat(resultMatcher.match("a")).isEqualTo("3");
                soft.assertThat(resultMatcher.match("b")).isEqualTo("2");
                soft.assertThat(resultMatcher.match("c")).isEqualTo("1");
            });
        }

        /*
            a b c
            |-| |
            | |-|
            | |-|
        */
        @DisplayName("line이 3개가 (a,b), (c,d), (b,c) 사이에 있을 경우 a는 두 번째 결과, b는 첫 번째 결과, c는 세 번째 결과를 갖는다.")
        @Test
        void test7() throws Exception {
            //given
            var persons = Participants.of(new String[]{"a", "b", "c"});
            var lines = new ArrayList<>(
                List.of(
                    new Line(List.of(CONNECTION, DETACHMENT)),
                    new Line(List.of(DETACHMENT, CONNECTION)),
                    new Line(List.of(DETACHMENT, CONNECTION))
                )
            );
            var ladder = new Ladder(lines);
            var ladderGame = LadderGame.create(ladder, persons);
            var results = new Results(new String[]{"1", "2", "3"});

            //when
            ResultMatcher resultMatcher = new ResultMatcher(ladderGame, results);

            //then
            assertSoftly(soft -> {
                soft.assertThat(resultMatcher.match("a")).isEqualTo("2");
                soft.assertThat(resultMatcher.match("b")).isEqualTo("1");
                soft.assertThat(resultMatcher.match("c")).isEqualTo("3");
            });
        }

        /*
            a b c
            | |-|
            |-| |
            | |-|
        */
        @DisplayName("line이 3개가 (b,c), (a,b), (b,c) 사이에 있을 경우 a는 세 번째 결과, b는 두 번째 결과, c는 첫 번째 결과를 갖는다.")
        @Test
        void test8() throws Exception {
            //given
            var persons = Participants.of(new String[]{"a", "b", "c"});
            var lines = new ArrayList<>(
                List.of(
                    new Line(List.of(DETACHMENT, CONNECTION)),
                    new Line(List.of(CONNECTION, DETACHMENT)),
                    new Line(List.of(DETACHMENT, CONNECTION))
                )
            );
            var ladder = new Ladder(lines);
            var ladderGame = LadderGame.create(ladder, persons);
            var results = new Results(new String[]{"1", "2", "3"});

            //when
            ResultMatcher resultMatcher = new ResultMatcher(ladderGame, results);

            //then
            assertSoftly(soft -> {
                soft.assertThat(resultMatcher.match("a")).isEqualTo("3");
                soft.assertThat(resultMatcher.match("b")).isEqualTo("2");
                soft.assertThat(resultMatcher.match("c")).isEqualTo("1");
            });
        }


        /*
            a b c
            | | |
            | |-|
            | | |
        */
        @DisplayName("line이 3개 중 (b,c)만 연결돼 있을 경우 a는 첫 번째 결과, b는 세 번째 결과, c는 두 번째 결과를 갖는다.")
        @Test
        void test11() throws Exception {
            //given
            var persons = Participants.of(new String[]{"a", "b", "c"});
            var lines = new ArrayList<>(
                List.of(
                    new Line(List.of(DETACHMENT, DETACHMENT)),
                    new Line(List.of(DETACHMENT, CONNECTION)),
                    new Line(List.of(DETACHMENT, DETACHMENT))
                )
            );
            var ladder = new Ladder(lines);
            var ladderGame = LadderGame.create(ladder, persons);
            var results = new Results(new String[]{"1", "2", "3"});

            //when
            ResultMatcher resultMatcher = new ResultMatcher(ladderGame, results);

            //then
            assertSoftly(soft -> {
                soft.assertThat(resultMatcher.match("a")).isEqualTo("1");
                soft.assertThat(resultMatcher.match("b")).isEqualTo("3");
                soft.assertThat(resultMatcher.match("c")).isEqualTo("2");
            });
        }
    }
}
