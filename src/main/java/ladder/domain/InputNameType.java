package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public enum InputNameType {
    ALL("all", (names, target) -> names),
    EACH(null, (names, target) -> List.of(target));

    private final String input;
    private final BiFunction<List<String>, String, List<String>> nameProvider;

    InputNameType(String input,
                  BiFunction<List<String>, String, List<String>> nameProvider) {
        this.input = input;
        this.nameProvider = nameProvider;
    }

    public static InputNameType from(String userInput) {
        return Arrays.stream(values())
                .filter(inputNameType -> userInput.equals(inputNameType.input))
                .findFirst()
                .orElse(EACH);
    }

    public List<String> name(List<String> names, String targetName) {
        return nameProvider.apply(names, targetName);
    }

}
