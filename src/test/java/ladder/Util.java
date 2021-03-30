package ladder;

import ladder.entity.Participant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static List<String> stringList(String input){
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<Participant> participantList(String input){
        return Arrays.stream(input.split(","))
                .map(Participant::new)
                .collect(Collectors.toList());
    }
}
