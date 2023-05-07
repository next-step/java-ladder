# 사다리타기 - FP, OOP

---

## Step3 - 사다리(생성)
### 기능 요구사항
- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다

### 구현 목록
- [X] 실행 결과 입력 기능 
- [ ] 사다리 결과 계산 기능
  - [X] 개별 결과 객체 생성
  - [X] 라인별 결과 객체 생성
- [ ] 사다리 결과 출력 기능
  - [ ] 개인별 결과 출력 기능
  - [ ] 전체 결과 출력 기능

---

### Step2 1차 피드백 수정
- [X] 사다리 생성 방법 수정
- [X] Random 인스턴스 변수 카멜케이스 수정
- nextInt -> nextBoolean 메서드 변경
  - 수정해봤으나 확률적으로 라인을 그리는 확률이 더 높은게 좋을듯 하여 반영하지는 않음 

--- 

## Step2 - 사다리(생성)
### 기능 요구사항
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

### 구현 목록
- [X] 사다리 게임 참가자 입력 기능
  - [X] 참가자 이름이 빈 값이거나 null인 경우 체크
  - [X] 참가자 당 최대 5글자까지 이름 부여 체크
  - [X] 참가자 이름은 쉼표(,) 기준으로 구분

- [X] 사다리 높이 입력 기능
  - [X] 0 초과 입력 체크

- [X] 입력한 값에 따라 사다리 생성 기능
  - [X] 개별 라인 생성 기능
  - [X] 가로 라인 생성
    - [X] 랜덤 값으로 라인 생성
    - [X] 옆 라인이 겹치지 않게 설정
  - [X] 사다리 생성
    - [X] 최대 높이 만큼 생성

- [X] 사다리 출력 기능
    - [X] 사람 이름 출력
    - [X] 사다리 출력
---

## Step1 - 스트림, 람다, Optional
### Step1 1차 피드백 수정
- [X] 람다 실습 2 - 람다를 활용해 중복 제거 의 요구조건을 충족
- [X] DEFAULT_SUM 은 오히려 가독성을 해치는 일
- [X] 함수명에서 even임을 명시했기 때문에 n % 2 == 0 이 더 직관적
- [X] OVER_CONDITION도 마찬가지
- [X] StreamStudy.java 중복이 존재

---

### 람다 실습 1 - 익명 클래스를 람다로 전환
- [X] MoveStrategy에 대한 익명 클래스로 구현하고 있는데 람다를 적용해 구현

### 람다 실습 2 - 람다를 활용해 중복 제거
- [X] 람다를 활용해 중복을 제거

### 다양한 stream method 실습
- [X] List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다.
- [X] nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현

### Optional
- [X] Optional을 활용해 ageIsInRange2() 메소드에 구현
- [X] Optional을 사용하도록 리팩토링한 후 UsersTest의 단위 테스트가 통과
- [X] nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현
