package nextstep.ladder.view;

import static nextstep.ladder.error.ErrorMessage.ILLEGAL_STATE;
import static nextstep.ladder.error.ErrorMessage.INVALID_INPUT_EMPTY;
import static nextstep.ladder.error.ErrorMessage.INVALID_INPUT_TYPE_INT;
import static nextstep.ladder.error.ErrorMessage.UN_EXPECTED_ERROR;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);

    private Input() {
    }

    public static String[] inputPersonName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        try {
            return scanner.nextLine().split(",");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(INVALID_INPUT_EMPTY.getMessage());
        } catch (IllegalStateException e) {
            throw new IllegalStateException(ILLEGAL_STATE.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException(UN_EXPECTED_ERROR.getMessage(), e);
        }
    }

    public static List<String> inputExecutionResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        try {
            return Arrays.stream(scanner.nextLine().split(","))
                .collect(Collectors.toList());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(INVALID_INPUT_EMPTY.getMessage());
        } catch (IllegalStateException e) {
            throw new IllegalStateException(ILLEGAL_STATE.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException(UN_EXPECTED_ERROR.getMessage(), e);
        }
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException(INVALID_INPUT_TYPE_INT.getMessage());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(INVALID_INPUT_EMPTY.getMessage());
        } catch (IllegalStateException e) {
            throw new IllegalStateException(ILLEGAL_STATE.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException(UN_EXPECTED_ERROR.getMessage(), e);
        }
    }

    public static String inputUserForDrawConfirmation() {
        System.out.println("결과를 보고 싶은 사람은?");
        try {
            return scanner.next();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(INVALID_INPUT_EMPTY.getMessage());
        } catch (IllegalStateException e) {
            throw new IllegalStateException(ILLEGAL_STATE.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException(UN_EXPECTED_ERROR.getMessage(), e);
        }
    }
}
