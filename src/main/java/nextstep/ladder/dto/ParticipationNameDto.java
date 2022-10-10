package nextstep.ladder.dto;

import nextstep.ladder.domain.ParticipationName;

import java.util.List;
import java.util.stream.Collectors;

public class ParticipationNameDto {

    private final String names;

    private ParticipationNameDto(final String names) {

        this.names = names;
    }

    public static List<ParticipationNameDto> from(final List<ParticipationName> participationNames) {

        return participationNames.stream()
                .map(participationName -> new ParticipationNameDto(participationName.getName()))
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
