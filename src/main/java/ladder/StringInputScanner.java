package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringInputScanner {

    private String[] namesString;

    public List<String> getNames() {
        getInputStream();

        return Arrays.stream(namesString)
                .map(wrapper(s -> String.valueOf(s)))
                .collect(Collectors.toList());
    }

    private void getInputStream() {
        Scanner scanner = new Scanner(System.in);
        this.namesString  = scanner.nextLine().replace(" ", "").split(",");
    }

    private <T, R, E extends Exception> Function<T, R> wrapper(FunctionWithException<T, R, E> fe) {
        return arg -> {
            try {
                return fe.apply(arg);
            } catch (Exception e) {
                throw new IllegalArgumentException("입력이 잘못 되었습니다.");
            }
        };
    }
}
