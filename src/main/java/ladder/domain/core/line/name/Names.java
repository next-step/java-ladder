package ladder.domain.core.line.name;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Names {
    private static final String SEPARATOR = ",";
    private final List<Name> names;

    Names(List<Name> names) {
        this.names = names;
    }

    static Names of(String names, Function<String, Name> mapper){
        Name.verifyBlankName(names);
        List<Name> nameList = Stream.of(names.split(SEPARATOR))
                                    .map(mapper)
                                    .collect(toList())
            ;
        return new Names(nameList);
    }

    static Names ofParticipants(String participants){
        return of(participants, Name::ofParticipant);
    }

    static Names ofLadderResults(String ladderResults){
        return of(ladderResults, Name::ofLadderResults);
    }

    int indexOf(Name name) {
        return names.indexOf(name);
    }

    int getCount() {
        return names.size();
    }

    public List<String> getPrimitiveNames(){
        return names.stream()
                    .map(Name::getName)
                    .collect(toList());
    }

    String get(int index) {
        return names.get(index)
                    .getName();
    }
}
