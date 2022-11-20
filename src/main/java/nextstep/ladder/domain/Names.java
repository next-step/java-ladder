package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private static final String DELIMITER_COMMA = ",";
    private List<Name> playersName;

    public Names(String names) {
        this.playersName = from(names);
    }

    public List<Name> names(){
        return playersName;
    }

    private List<Name> from(String names){
        List<String> playersName = splitByByComma(names);
        return playersName.stream()
            .map(Name::new)
            .collect(Collectors.toList());
    }

    private List<String> splitByByComma(String names){
        List<String> playersName = new ArrayList<>();
        Collections.addAll(playersName,names.split(DELIMITER_COMMA));
        return playersName;
    }

}
