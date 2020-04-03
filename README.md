# 사다리 게임
## 어플리케이션 흐름
1. 사용자가 플레어어 이름을 입력한다.
2. 사용자가 사다리의 높이를 입력한다.
3. 사다리의 Row를 구한다.
4. n 개의 Row를 구한다.
5. 출력한다.

## 기능 목록
- 플레이어 이름 입력
    - 5자 초과 입력 -> Exception
    - 5자 이하 입력 -> ok!

- 사다리 높이 입력
    - 0 입력 -> Exception
    - -1 입력 -> Exception
    - 0 초과 입력 -> ok!

- 사다리 Row 구하기
    - If Row.get(i) == true, Row.get(i+1)은 반드시 false
    - If Row.get(i) == false, Row.get(i+1)은 아무거나 ok!