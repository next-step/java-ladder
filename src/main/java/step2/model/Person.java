package step2.model;

import step2.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Person {

    private final static String MINIMUM_PERSON_COUNT_MESSAGE = "참여 인원은 2명이상이여야 합니다.";
    private final static String NOT_EXIST_CORRECT_NAME_MESSAGE = "이름이 일치하는 사람이 없습니다.";
    private final static String ALL = "all";
    private final static int MINIMUM_PERSON_COUNT = 2;

    private final List<Name> names = new ArrayList<>();

    private Person(String[] personArr) {
        confirmPersonCount(personArr);
        for(String name : personArr) {
            names.add(Name.createName(name));
        }
    }

    // 사다리게임 참여인원을 생성한다.
    public static Person createPerson(String personStr) {
        return new Person(StringUtil.divideComma(personStr));
    }

    //이름을 입력받아 몇번째 참여 인원인지 가져온다.
    public int[] getPersonIndex(String personName) {
        if (ALL.equals(personName)) {
            return IntStream.range(0, nameSize()).toArray();
        }
        return new int[] {
                IntStream.range(0, nameSize())
                        .filter(i -> names.get(i).checkName(personName))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_CORRECT_NAME_MESSAGE))
        };
    }

    //인원수를 가져온다.
    public int nameSize() {
        return names.size();
    }

    public List<Name> getNames() {
        return names;
    }

    //참여하는 인원수를 체크한다.
    private void confirmPersonCount(String[] personArr) {
        if (personArr.length < MINIMUM_PERSON_COUNT) {
            throw new IllegalArgumentException(MINIMUM_PERSON_COUNT_MESSAGE);
        }
    }

}
