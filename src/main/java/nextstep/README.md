# 1단계 - 자바8 스트림, 람다, Optional

## 요구사항 정리

## 람다
- 실습 1
    - 익명 클래스를 람다로 전환
    - 테스트 코드에서 MoveStrategy에 대한 익명 클래스로 구현 부분 람다를 적용해 구현

- 실습 2
    - 람다를 활용해 중복 제거
    - 변경 되는 부분을 인터페이스로 추출
    - 인터페이스 구현체 부분을 익명 클래스로 구현해 메소드 인자로 전달

## 스트림
- src/main/resources/fp 디렉토리 아래에 있는 war-and-peace.txt 파일을 읽어 실습 진행
- 실습 1
    - List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합 추출
    - map, reduce, filter 활용
    - nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass 해야 함

- 실습 2
    - nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현
    - 단어의 길이가 12자를 초과하느 단어 추출
    - 길이가 긴 순서로 100개 단어 추출
    - 단어 중복 허용하지 않음
    - 추출한 100개의 단어 출력
    - 소문자로 출력


## Optional
- 실습 1
    - Optional을 활용해 조건에 따른 반환Optional에서 값을 반환
    - nextstep.optional.User의 ageIsInRange1() 메소드는 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메소드
    - 같은 기능을 Optional을 활용해 ageIsInRange2() 메소드에 구현
    - Optional 생성하여 stream의 map, filter 등의 메소드 사용
    - nextstep.optional.UserTest의 테스트가 모두 pass 해야 함

- 실습 2
    - Optional에서 값을 반환
    - stream과 Optional을 사용하도록 리팩토링
    - UsersTest의 단위 테스트가 통과해야 함


- 실습 3
    - Optional Exception 처리
    - nextstep.optional.ExpressionTest의 테스트가 통과 해야 함
    - of 메소드 구현
    - stream 기반으로 구현
