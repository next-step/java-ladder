# 1단계 - 스트림, 람다, Optional

## 기능 요구 목록
- [X] 람다 실습 1 - 익명 클래스를 람다로 전환
- [ ] 람다 실습 2 - 람다를 활용해 중복 제거
- [ ] map, reduce, filter 실습 1
  - List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다.
- [ ] map, reduce, filter 실습 2
  - nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다.
    - 단어의 길이가 12자를 초과하는 단어를 추출한다.
    - 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
    - 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
    - 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
- [ ] Optional을 활용해 조건에 따른 반환
  - ageIsInRange2() 메소드에 구현한다.
  - 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환한다.
- [ ] Optional에서 값을 반환
  - getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현한다.
- [ ] Optional에서 exception 처리
  - Expression의 of 메소드를 구현한다.
