package laddergame.dto;

import laddergame.domain.LadderLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LadderLineDto {

    private final List<Boolean> connections;

    public LadderLineDto(List<Boolean> connections) {
        this.connections = connections;
    }

    public static LadderLineDto from(LadderLine line) {
        List<Boolean> connections = new ArrayList<>();
        IntStream.range(0, line.size())
                .forEach(index -> connections.add(line.isConnected(index)));
        return new LadderLineDto(connections);
    }

    public List<Boolean> getConnections() {
        return connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLineDto that = (LadderLineDto) o;
        return Objects.equals(connections, that.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connections);
    }

    @Override
    public String toString() {
        return "LadderLineDto{" +
                "connections=" + connections +
                '}';
    }

}
