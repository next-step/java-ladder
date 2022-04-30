package ladder.converter;

import ladder.dto.LadderResultDto;
import ladder.model.Direction;
import ladder.model.ExecutionResult;
import ladder.model.ExecutionResults;
import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.Participant;
import ladder.model.Participants;
import ladder.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ResultConverterTest {

    @Test
    @DisplayName("참여자의 사다리게임 결과를 변환하여 전달한다")
    void convertIntoLadderResultDto() {
        //given
        Participants participants = Participants.create(List.of(
                Participant.create("user1"),
                Participant.create("user2"),
                Participant.create("user3")
        ));

        ExecutionResults executionResults = ExecutionResults.create(List.of(
                ExecutionResult.create("1"),
                ExecutionResult.create("2"),
                ExecutionResult.create("3")
        ));

        Ladder ladder = Ladder.create(List.of(
                Line.create(List.of(
                        Point.of(false, true),
                        Point.of(true, false),
                        Point.of(false, false)
                )),
                Line.create(List.of(
                        Point.of(false, false),
                        Point.of(false, true),
                        Point.of(true, false))
                ))
        );

        LadderResultDto ladderResultDto
                = ResultConverter.convertIntoLadderResultDto(participants, executionResults, ladder);

        assertAll(
                () -> assertThat(ladderResultDto.showLadderResult("user1").toString()).isEqualTo("3"),
                () -> assertThat(ladderResultDto.showLadderResult("user2").toString()).isEqualTo("1"),
                () -> assertThat(ladderResultDto.showLadderResult("user3").toString()).isEqualTo("2")
        );
    }
}