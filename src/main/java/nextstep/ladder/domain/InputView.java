package nextstep.ladder.domain;

import nextstep.ladder.dto.LadderInput;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class InputView {
    public LadderInput initRadderInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> users = inputToUsers(scanner.next());
        nameLengthValidate(users);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = Optional.ofNullable(scanner.nextInt()).orElseThrow(() -> new IllegalArgumentException("최대 사다리 높이는 몇 개인가요?"));
        return new LadderInput(users, height);
    }

    public void nameLengthValidate(List<String> participants) {
        participants.stream()
                .filter(o -> o.length() <= 5 && o.length() >= 1)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("이름은 최대 5글자 최소1글자 입니다."));
    }

    public List<String> inputToUsers(String input) {
        return Arrays.asList(input.split(","));
    }
}
