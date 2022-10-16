package nextstep.ladder.dto;

import nextstep.ladder.domain.ParticipationNames;

import java.util.List;
import java.util.stream.Collectors;

public class ParticipationNameDto {

    private final String names;

    private ParticipationNameDto(final String names) {

        this.names = names;
    }

    public static List<ParticipationNameDto> from(final ParticipationNames participationNames) {

        return participationNames.getName()
                .stream()
                .map(ParticipationNameDto::new)
                .collect(Collectors.toList());
    }

    public String getNames() {

        return names;
    }

    @Override
    public String toString() {
        return "ParticipationNameDto{" +
                "names='" + names + '\'' +
                '}';
    }
}
