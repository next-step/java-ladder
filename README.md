# 사다리 게임

## 진행 방법

* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

</br>

---

## 요구사항

<details>
<summary><b>🚀 1단계 - 스트림, 람다, Optional</b></summary>

**실습**
> - [X] Lambda1. CarTest 내 MoveStrategy에 대한 익명 클래스로 구현하고 있는데 람다를 적용해 구현
> - [X] Lambda2. nextstep.fp.Lambda의 sumAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고 중복 제거
> - [X] Stream1. List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합 산출
>    - nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.
> - [X] Stream2. nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다. 요구사항은 다음과 같다. 
>   - 단어의 길이가 12자를 초과하는 단어를 추출한다.
>   - 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
>   - 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
>   - 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
> - [X] Optional1. nextstep.optional.User의 ageIsInRange1() 메소드는 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메소드이다. 같은 기능을 Optional을 활용해 ageIsInRange2() 메소드에 구현
> - [X] Optional2. nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현
> - [X] Optional3. nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현
</details>

<details>
<summary><b>🚀 2단계 - 사다리(생성)</b></summary>

**기능 요구사항**
> - [X] 사다리 게임에 참여하는 사람 이름을 한 줄로 입력받는다.
>> - [X] 사람 이름은 최대 다섯글자이다.
>> - [X] 사람 이름을 (,) 쉼표로 구분한다.
> - [X] 최대 사다리 높이를 입력받는다.
> - [X] 입력받은 이름들을 사다리 게임에 참여시킨다.
> - [X] 사다리를 생성한다.
>> - [X] 라인의 좌표 값에 선이 있는지 유무를 판단한다.
>> - [X] horizontal line 이 `|-----|-----|` 이런 식으로 겹치면 안된다.
> - [X] 사다리 게임에 참여하는 이름과 사다리를 출력한다.

</details>

<details>
<summary><b>🚀 3단계 - 사다리(게임 실행)</b></summary>

**기능 요구사항**
> - [X] 사다리 실행 결과를 입력한다.
>> - [X] 이 때, 입력한 사다리 실행 결과 값은 참여 인원수와 똑같아야한다.
> - [X] 입력한 실행 결과를 토대로 사다리를 출력한다.
> - [X] 사다리 게임을 실행한다.
> - [X] 사다리 실행 결과를 출력한다.
>> - [X] 개인별 이름을 입력하면 개인별 결과를 출력한다.
>> - [X] "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

</details>

</br>
