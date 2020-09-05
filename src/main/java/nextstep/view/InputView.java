package nextstep.view;

import nextstep.entity.Entries;
import nextstep.entity.Entry;
import nextstep.entity.Length;
import nextstep.entity.TryCatchable;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String NAME_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private TryCatchable tryCatch(Supplier<TryCatchable> supplier) {
        try {
            return supplier.get();
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력할 수 있어요.");
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return supplier.get();
        }
    }

    public Entries inputEntries() {
        return (Entries) tryCatch(() -> {
            System.out.println("참여할 사람 이름을 입력 하세요. (이름은 쉼표(,)로 구분 하세요.)");
            String[] names = scanner.nextLine().split(NAME_DELIMITER);
            System.out.println();
            List<Entry> entries = Stream.of(names)
                    .map(String::trim)
                    .map(Entry::new)
                    .collect(Collectors.toList());
            return new Entries(entries);
        });
    }

    public Length inputLength() {
        return (Length) tryCatch(() -> {
            System.out.println("최대 사다리 높이는 몇 개 인가요?");
            int length = Integer.parseInt(scanner.nextLine());
            System.out.println();
            return new Length(length);
        });
    }
}
