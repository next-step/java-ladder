package laddergame.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants extends EndPoints {

    public Participants(String[] inputs) {
        super(
            new ArrayList<>(
                IntStream.range(0, inputs.length)
                        .mapToObj(i -> new Participant(inputs[i], i))
                        .collect(Collectors.toSet())
            )
        );
    }
}