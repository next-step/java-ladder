package nextstep.view;

import nextstep.dto.DTO;
import nextstep.dto.EntriesDTO;
import nextstep.dto.EntryDTO;
import nextstep.dto.LengthDTO;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String ENTRY_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private DTO tryCatch(Supplier<DTO> supplier) {
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

    private EntriesDTO inputEntries() {
        return (EntriesDTO) tryCatch(() -> {
            String[] inputs = scanner.nextLine().split(ENTRY_DELIMITER);
            System.out.println();
            List<EntryDTO> entries = Stream.of(inputs)
                    .map(String::trim)
                    .map(EntryDTO::new)
                    .collect(Collectors.toList());
            return new EntriesDTO(entries);
        });
    }

    public EntriesDTO inputStartEntries() {
        return (EntriesDTO) tryCatch(() -> {
            System.out.println("참여할 사람 이름을 입력 하세요. (이름은 쉼표(,)로 구분 하세요.)");
            return this.inputEntries();
        });
    }

    public EntriesDTO inputResultEntries(int personnel) {
        return (EntriesDTO) tryCatch(() -> {
            System.out.println("실행 결과를 입력 하세요. (결과는 쉼표(,)로 구분 하세요.)");
            EntriesDTO resultEntries = (EntriesDTO) this.inputEntries();
            if (resultEntries.getEntryCount() != personnel) {
                throw new IllegalArgumentException("참여한 사람과 수가 같지 않아요.");
            }
            return resultEntries;
        });
    }

    public LengthDTO inputLength() {
        return (LengthDTO) tryCatch(() -> {
            System.out.println("최대 사다리 높이는 몇 개 인가요?");
            int length = Integer.parseInt(scanner.nextLine());
            System.out.println();
            return new LengthDTO(length);
        });
    }
}
