package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//TODO: 삭제할건지 생각
public class HumanMaker {

    private final List<String> ladders;

    private HumanMaker(List<String> ladders) {
        this.ladders = ladders;
    }


    public static List<String> of(String names) {
        return new HumanMaker(Arrays.stream(names.split(","))
                                     .map(Validation::lengthValidation)
                                     .collect(Collectors.toList())).getLadders();
    }

    private List<String> getLadders() {
        return ladders;
    }
}
