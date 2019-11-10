package ladder;

import ladder.domain.player.Name;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LadderController {

    public static void main(String[] args) {


    }

    private static List<Name> makeNames(String[] inputNames) {
        return Arrays.stream(inputNames)
                .map(Name::new)
                .collect(toList());
    }
}
