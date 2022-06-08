package ladder.converter;

import ladder.domain.*;
import ladder.dto.LadderResultDto;
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
        Participants participants = new Participants(List.of(
                new Participant("user1"),
                new Participant("user2"),
                new Participant("user3")
        ));

        ExecutionResults executionResults = new ExecutionResults(List.of(
                new ExecutionResult("1"),
                new ExecutionResult("2"),
                new ExecutionResult("3")
        ));

        Ladder ladder = new Ladder(List.of(
                Line.create(List.of(
                        new Point(false, true),
                        new Point(true, false),
                        new Point(false, false)
                )),
                Line.create(List.of(
                        new Point(false, false),
                        new Point(false, true),
                        new Point(true, false))
                ))
        );

        LadderResultDto ladderResultDto
                = ResultConverter.convertToResultDto(ladder, executionResults, participants);

        assertAll(
                () -> assertThat(ladderResultDto.showLadderResult("user1").toString()).isEqualTo("3"),
                () -> assertThat(ladderResultDto.showLadderResult("user2").toString()).isEqualTo("1"),
                () -> assertThat(ladderResultDto.showLadderResult("user3").toString()).isEqualTo("2")
        );
    }

}