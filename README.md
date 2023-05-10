# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

### 람다(lambda)
- [X] CarTest의 테스트 코드에서 MoveStrategy를 람다로 적용한다.
- [X] nextstep.fp.Lambda의 sumAll, sumAllEven, sumAllOverThree를 람다를 활용해 중복 제거한다.

### 스트림(stream)
- [X] List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다.
    - [X] nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.
- [X] nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다.
    - [X] 단어의 길이가 12자를 초과하는 단어를 추출한다.
    - [X] 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다. (sorted())
    - [X] 단어 중복을 허용하지 않는다. (distinct())
    - [X] 추출한 100개의 단어를 소문자로 출력한다. (String.toLowerCase())

### Optional
- [X] ageIsInRange2() Optional을 사용해 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메소드를 구현한다.
    - [X] nextstep.optional.UserTest의 테스트가 모두 pass해야 한다.
- [X] nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현한다.
    - [X] UsersTest의 단위 테스트가 통과해야 한다.
- [X] Expression의 of 메소드를 Stream 기반으로 구현한다.
    - [X] nextstep.optional.ExpressionTest의 테스트가 통과해야 한다.

## 사다리 게임

### 사다리 생성
- [X] 사다리 게임 참여자의 이름을 입력받는다.
  - [X] 이름은 최대 5글자까지 부여할 수 있다.
  - [X] 이름은 쉼표(,) 기준으로 구분한다.
- [X] 최대 사다리 높이를 입력받는다.
- [X] 참여자 수, 사다리 높이 기준으로 사다리를 생성한다.
  - [X] 사다리 한 라인에 가로 라인이 겹치지 않아야 한다.
- [X] 사다리 출력 시 참여자의 이름도 함께 출력한다.

### Point
- [] 현재 위치 좌,우로 라인 여부를 저장한다.
- [] 좌,우 모두 라인이 있는 경우 예외가 발생한다.
- [] 좌측에 라인이 있는 경우 LEFT 이동한다.
- [] 우측에 라인이 있는 경우 RIGHT 이동한다.
- [] 좌,우 모두 라인이 없는 경우 이동하지 않는다.

### 게임 실행
- [] 게임 실행 결과를 입력받는다.
  - [] 결과는 (,)로 구분한다.
  - [] 결과는 꽝 or 숫자만 허용한다.
- [] 각 사용자 별 개별 결과를 출력한다.
- [] 전체 사용자의 게임 결과를 출력한다.
