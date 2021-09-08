# 1단계 - 자바8 스트림, 람다, Optional

### 요구 사항

- [x] Lambda 실습
    - MoveStrategy에 대한 익명클래스를 람다로 구현
        + 람다를 활용한 중복 제거
- [x] Stream 실습
    + List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다.
    + nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다.
        * 단어의 길이가 12자를 초과하는 단어를 추출한다.
        * 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
        * 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
        * 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
- [ ] Optional 실습
    + Optional을 활용해 조건에 따른 반환
        * ageIsInRange2() 메소드에 구현한다
    + Optional에서 값을 반환
    + Optional에서 exception 처리