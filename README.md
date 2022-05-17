# 사다리 게임

## 진행 방법

* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

---

## 1. Step1 - 람다, 스트림, Optional

### 1) 람다

- 익명클래스 -> 람다 전환
- 람다를 활용해 중복 제거

### 2) 스트림

> src/main/resources/fp 디렉토리 아래에 있는 war-and-peace.txt 파일을 읽어 다음 요구사항을 만족하세요.

- map, reduce, filter 실습 1
  - List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다.
  - nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.
- map, reduce, filter 실습 2
  - nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다.
  요구사항은 다음과 같다.
  - ```text
    - 단어의 길이가 12자를 초과하는 단어를 추출한다.
    - 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
    - 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
    - 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
    ```

### 3) Optional

- Optional을 활용해 조건에 따른 반환
  - nextstep.optional.User의 ageIsInRange1() 메소드는 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메소드이다.
  - 같은 기능을 Optional을 활용해 ageIsInRange2() 메소드에 구현한다. 메소드 인자로 받은 User를 Optional로 생성하면 stream의 map, filter와 같은 메소드를 사용하는 것이 가능하다
  - nextstep.optional.UserTest의 테스트가 모두 pass해야 한다.
- Optional에서 값을 반환
  - nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현한다. 
  - 자바 8의 stream과 Optional을 사용하도록 리팩토링한 후 UsersTest의 단위 테스트가 통과해야 한다.
- Optional에서 exception 처리
  - nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현한다. 
  - 단, of 메소드를 구현할 때 자바 8의 stream을 기반으로 구현한다.

<br>

## 2. step2 ~ step4 사다리 게임
### 기능 요구사항 정리
- [ ] 게임에 참여할 플레이어들의 이름을 입력 받을 수 있다.
  - [x] 플레이어들의 수는 최소 두 명 이상이어야 한다.
  - [x] 플레이어들의 이름은 중복이 없어야 한다.
  - [x] 플레이어들의 이름은 `,` 로 구분하여 입력받는다.
  - [x] 플레이어들의 이름은 5글자 까지 가능하다.
  - [x] 플레이어들의 이름은 빈 값이 아니어야 한다.

- [ ] 사다리의 높이 갯수를 입력 받을 수 있다.
  - [ ] 1 이상의 수만 입력이 가능하다.

- [ ] 플레이어들 수와 동일하게 사다리의 세로 라인을 만든다.
- [ ] 플레이어 수를 기준으로 랜덤하게 사다리를 생성한다.
  - [ ] 플레이어들 수에 맞게 사다리의 세로 라인을 만든다.
  - [ ] `|-----|-----|` 와 같이 사다리가 겹쳐서 어디로 이동할지 모르는 케이스가 없어야한다.

- [ ] 생성한 사다리를 출력할 수 있다.