package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private final List<Integer> computerNumber = new ArrayList<>(3);
    private final List<Integer> userNumber = new ArrayList<>(3);

    BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        initComputerNumber();
        System.out.println(computerNumber);
    }

    public void startGame() {

    }

    /**
     * 컴퓨터의 숫자를 초기화하는 함수
     */
    private void initComputerNumber() {
        computerNumber.clear();
        for (int i = 0; i < 3; i++) {
            computerNumber.add((int)(Math.random() * 9 + 1));
        }
    }

    /**
     * 사용자의 숫자를 입력받는 함수
     */
    private void initUserNumber() {

    }

    /**
     * 볼, 스트라이크를 받아서 결과를 반환하는 함수
     */
    private boolean analyzeResult() {
        return false;
    }

    /**
     * 컴퓨터의 숫자와 사용자의 숫자를 비교해서 스트라이크, 볼을 비교하는 함수
     */
    private int countStrike() {
        return 0;
    }

    private int countBall() {
        return 0;
    }

    public boolean inputGameContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int inputInt = scanner.nextInt();
        return inputInt == 1;
    }
}
