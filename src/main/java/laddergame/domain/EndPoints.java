package laddergame.domain;

import laddergame.validator.EndPointsValidator;
import laddergame.validator.Validatable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EndPoints {

    private final List<EndPoint> endPoints;

    public EndPoints(String[] inputs) {
        this(new ArrayList<>(IntStream.range(0, inputs.length)
                .mapToObj(i -> new EndPoint(inputs[i], i))
                .collect(Collectors.toSet())));
    }

    private EndPoints(List<EndPoint> endPoints) {
        Validatable<List<EndPoint>> validator = new EndPointsValidator();
        validator.validate(endPoints);
        this.endPoints = endPoints;
    }

    public int size() {
        return endPoints.size();
    }

    public List<EndPoint> getEndPoints() {
        return endPoints;
    }

    public EndPoint getEndPoint(int index) {
        return endPoints.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndPoints that = (EndPoints) o;
        return Objects.equals(endPoints, that.endPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endPoints);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        endPoints.forEach((endPoint) -> {
            sb.append(endPoint);
            sb.append(" ");
        });

        return sb.toString();
    }
}