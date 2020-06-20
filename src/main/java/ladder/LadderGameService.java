package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderResults;
import ladder.domain.Persons;
import ladder.dto.LadderRequestDto;
import ladder.dto.LadderResponseDto;

public class LadderGameService {
    public static LadderResponseDto play(LadderRequestDto ladderRequestDto) {
        Persons persons = Persons.of(ladderRequestDto.getPersons());
        LadderResults ladderResults = LadderResults.of(ladderRequestDto.getResults(), persons.count());
        Height height = Height.of(ladderRequestDto.getHeight());
        Ladder ladder = Ladder.create(height, persons.count());

        return new LadderResponseDto(persons, ladder, ladderResults);
    }
}
