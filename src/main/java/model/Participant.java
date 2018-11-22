package model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participant {
    private static final String ALL = "all";
    private static final int LIMIT = 5;
    private String name;


    private Participant(String name) {
        if (name.length() > LIMIT) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Participant getParticipant(String name) {
        return new Participant(name);
    }

    public static List<Participant> getParticipants(String names) {
        return Arrays.stream(names.split(","))
                .map(Participant::getParticipant)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * 이름으로 찾기
     *
     * @param name
     * @param participants
     * @return
     */
    public static Participant findByName(String name, List<Participant> participants) {
        Participant participant = Participant.getParticipant(name);

        return participants.stream()
                .filter(p -> p.equals(participant))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * 모두 출력인지 여부
     *
     * @param name
     * @return
     */
    public static boolean isAll(String name) {
        return name.equals(ALL);
    }

}
