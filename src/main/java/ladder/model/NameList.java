package ladder.model;

import ladder.model.utils.StringToListConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class NameList implements NameListInterface{
    private static final String NAME_PATTERN = "^[a-zA-Z]*$";
    private List<String> nameList;

    public NameList(String nameList) {
        this.nameList = StringToListConverter.toList(nameList);
        checkDuplicate();
        checkPattern();
        checkLength();
    }

    public NameList(List<String> nameList) {
        this.nameList = nameList;
        checkDuplicate();
        checkPattern();
        checkLength();
    }

    private void checkDuplicate() {
        if (nameList.size() != nameList.stream().distinct().count()) {
            throw new IllegalArgumentException("이름은 중복일수 없습니다.");
        }
    }

    private void checkPattern() {
        nameList.stream()
                .filter(name -> !Pattern.matches(NAME_PATTERN, name))
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("이름은 영어 대소문자 / 숫자만 포함 가능.");
                });
    }

    private void checkLength() {
        nameList.stream()
                .filter(name -> name.length() > 5)
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("아이디는 5자 이하.");
                });
    }

    public int numOfName() {
        return nameList.size();
    }

    public List<String> getNameList() {
        return nameList;
    }

    @Override
    public NameList swapPoints(int index) {
        if (index < 0 || index >= nameList.size() - 1) {
            throw new IllegalArgumentException("경계 초과");
        }
        List<String> newList = new ArrayList<>(nameList);
        Collections.swap(newList, index, index + 1);
        return new NameList(newList);
    }

}
