//package ladder.domain.ladder;
//
//import ladder.domain.participant.Participants;
//import ladder.strategy.LineGenerateStrategy;
//import ladder.exception.LineListNullPointerException;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.assertAll;
//
//class LadderTest {
//
//    @DisplayName("Ladder 인스턴스 생성 여부 테스트")
//    @Test
//    void 생성() {
//        // given
//        Participants participants = Participants.of("a,b,c".split(","));
//        LadderHeight ladderHeight = LadderHeight.valueOf(5);
//        LineGenerateStrategy strategy = () -> true;
//
//        // when
//        Ladder ladder = Ladder.from(participants, ladderHeight, strategy);
//
//        // then
//        assertThat(ladder).isNotNull();
//    }
//
//    @DisplayName("Ladder 인스턴스에 null 입력시 예외처리 여부 테스트")
//    @Test
//    void 검증_null() {
//        // given
//        List<Line> nullLines = null;
//
//        // when and then
//        assertThatThrownBy(() -> Ladder.from(nullLines))
//                .isInstanceOf(LineListNullPointerException.class)
//                .hasMessage("List<Line>이 null 입니다.");
//    }
//
//    @DisplayName("Ladder 인스턴스가 Stream<Line> 반환하는지 테스트")
//    @Test
//    void 반환_stream() {
//        // given
//        Participants participants = Participants.of("a,b,c".split(","));
//        LadderHeight ladderHeight = LadderHeight.valueOf(5);
//        LineGenerateStrategy strategy = () -> true;
//
//        // when
//        Ladder ladder = Ladder.from(participants, ladderHeight, strategy);
//
//        // then
//        assertAll(
//                () -> assertThat(ladder.stream()).isNotNull(),
//                () -> assertThat(ladder.stream()).isInstanceOf(Stream.class)
//        );
//    }
//
//    @DisplayName("Ladder 인스턴스가 LadderResultBoard 반환하는지 테스트")
//    @Test
//    void 반환_LadderResultBoard() {
//        // given
//        Participants participants = Participants.of("pobi,honux,crong,jk".split(","));
//        LadderHeight height = LadderHeight.valueOf(5);
//        LadderResults ladderResults = LadderResults.of("꽝,꽝,5000,3000".split(","));
//
//        // when
//        Ladder ladder = Ladder.from(participants, height, () -> true);
//
//
//        // then
//        assertAll(
//                () -> assertThat(ladder.run(participants, ladderResults)).isNotNull(),
//                () -> assertThat(ladder.run(participants, ladderResults)).isInstanceOf(LadderResultBoard.class)
//        );
//
//    }
//
//
//}