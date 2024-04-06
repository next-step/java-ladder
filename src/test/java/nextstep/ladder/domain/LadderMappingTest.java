package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderMappingTest {

    LadderMapping testLadderMapping;
    @BeforeEach
    void setUp() {
        List<Participant> participants = List.of(new Participant("a"), new Participant("b"), new Participant("c"));
        List<Destination> destinations = List.of(new Destination("1"), new Destination("2"), new Destination("3"));
        testLadderMapping = new LadderMapping(participants, destinations);
    }

    @Test
    @DisplayName("결과 조회자가 null 일 경우에 예외(null => IllegalArgumentException)")
    void show_result_null_or_empty() {
        assertThatThrownBy(() -> {
            testLadderMapping.showResult(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("결과 조회자가 참가자가 아니라면 예외(a,b,c,d | e => IllegalArgumentException)")
    void not_participants() {
        assertThatThrownBy(() -> {
            testLadderMapping.showResult(new Participant("e"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("결과 조회 대상자라면 해당 조회자의 결과만 조회('a' => a:1)")
    void show_result() {
        assertThat(testLadderMapping.showResult(new Participant("a"))).isEqualTo(new LadderMapping.MappingDto(new Participant("a"), new Destination("1")));
    }

    @Test
    @DisplayName("모든 결과 조회(a:1,b:2,c:3)")
    void show_all() {
        assertThat(testLadderMapping.showAll())
                .contains(
                        new LadderMapping.MappingDto(new Participant("a"), new Destination("1")),
                        new LadderMapping.MappingDto(new Participant("b"), new Destination("2")),
                        new LadderMapping.MappingDto(new Participant("c"), new Destination("3"))
                );
    }

    @Test
    @DisplayName("전체 참여자가 1명 이하일 경우에 예외(pobi => IllegalArugmentExcepiton)")
    void exception_when_participant_only_one() {
        assertThatThrownBy(() -> {
            new LadderMapping(List.of(new Participant("pobi")), List.of(new Destination("꽝")));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("order 순서에 따라서 참여자들이 다시 재배치된다(a,b,c -> 2,1,0 => c,b,a)")
    void reordering(){
        List<Participant> participants = List.of(new Participant("a"), new Participant("b"), new Participant("c"));
        LadderMapping ladderMapping = new LadderMapping(participants, List.of(new Destination("1"), new Destination("2"), new Destination("3")));
        int[] orders = {2, 1, 0};
        assertThat(ladderMapping.regenerate(orders).getParticipants()).isEqualTo(List.of(new Participant("c"), new Participant("b"), new Participant("a")));
    }

    @Test
    @DisplayName("empty이면 예외('' => IllegalArgumentException)")
    void null_or_empty() {
        assertThatThrownBy(() -> {
            new LadderMapping(List.of(new Participant("a"), new Participant("b")), Collections.emptyList());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실행결과의 개수는 참가자 수랑 다르면 예외(3,4 => IllegalArgumentException)")
    void check_size() {
        assertThatThrownBy(() -> {
            new LadderMapping(
                    List.of(new Participant("a"), new Participant("b"), new Participant("c")),
                    List.of(new Destination("1"), new Destination("2"), new Destination("3"), new Destination("4")));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
