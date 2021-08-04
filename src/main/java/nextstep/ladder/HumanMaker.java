package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HumanMaker {

    private final List<String> ladders;

    private HumanMaker(List<String> ladders) {
        this.ladders = ladders;
    }


    public static List<String> of(String s) {
        return new HumanMaker(Arrays.stream(s.split(","))
                                     .map(Validation::lengthValidation)
                                     .collect(Collectors.toList())).getLadders();
    }

    private List<String> getLadders() {
        return ladders;
    }
}
