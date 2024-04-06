package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderMapping {
    private final List<Participant> participants;
    private final List<Destination> destinations;

    public LadderMapping(List<Participant> participants, List<Destination> destinations) {
        validateParticipants(participants);
        validateDestinations(destinations);
        validateSize(participants.size(), destinations);
        this.participants = participants;
        this.destinations = destinations;
    }

    private void validateDestinations(List<Destination> destinations) {
        if (destinations == null || destinations.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateParticipants(List<Participant> participants) {
        if (participants == null) {
            throw new IllegalArgumentException();
        }
        if (participants.size() <= 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(int size, List<Destination> destinations) {
        if (destinations.size() != size) {
            throw new IllegalArgumentException();
        }
    }

    public LadderMapping regenerate(int[] orders) {
        ArrayList<Participant> newParticipants = new ArrayList<>();
        for (int order : orders) {
            newParticipants.add(this.participants.get(order));
        }
        return new LadderMapping(newParticipants, this.destinations);
    }

    public List<MappingDto> showAll() {
        return this.participants
                .stream().map(this::showResult)
                .collect(Collectors.toList());
    }

    public MappingDto showResult(Participant viewer) {
        if (viewer == null) {
            throw new IllegalArgumentException();
        }
        int index = this.participants.indexOf(viewer);
        if (index == -1) {
            throw new IllegalArgumentException();
        }
        return new MappingDto(viewer, this.destinations.get(index));
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public static class MappingDto {
        private final Participant participant;
        private final Destination destination;

        public MappingDto(Participant participant, Destination destination) {
            this.participant = participant;
            this.destination = destination;
        }

        public Participant getParticipant() {
            return participant;
        }

        public Destination getDestination() {
            return destination;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MappingDto)) return false;
            MappingDto that = (MappingDto) o;
            return Objects.equals(participant, that.participant) && Objects.equals(destination, that.destination);
        }

        @Override
        public int hashCode() {
            return Objects.hash(participant, destination);
        }
    }
}
