package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private final List<String> computerNumber;

    BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNumber = initComputerNumber();
    }

    public void startGame() {
        boolean isThreeStrike = false;
        while (!isThreeStrike) {
            List<String> userNumber = initUserNumber();
            isThreeStrike = analyzeResult(userNumber);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * 컴퓨터의 숫자를 초기화하는 함수
     */
    public List<String> initComputerNumber() {
        List<String> generatedNumbers = new ArrayList<>(3);
        while (generatedNumbers.size() < 3) {
            String generatedNumber = String.valueOf((int) (Math.random() * 9 + 1));
            if (generatedNumbers.contains(generatedNumber)) continue;
            generatedNumbers.add(generatedNumber);
        }
        return generatedNumbers;
    }

    /**
     * 사용자의 숫자를 입력받는 함수
     */
    public ArrayList<String> initUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        return new ArrayList<>(List.of(String.valueOf(userInput).split("")));
    }

    /**
     * 볼, 스트라이크를 받아서 결과를 반환하는 함수
     */
    private boolean analyzeResult(List<String> userNumber) {
        int strike = countStrike(userNumber);
        int ball = countBall(userNumber);
        printInputResult(strike, ball - strike);
        return strike == 3;
    }

    private void printInputResult(int strike, int ball) {
        if (ball == 0 && strike == 0) System.out.print("0볼");
        if (ball > 0 ) System.out.print(ball + "볼 ");
        if (strike > 0 ) System.out.print(strike + "스트라이크");
        System.out.println();
    }

    /**
     * 컴퓨터의 숫자와 사용자의 숫자를 비교해서 스트라이크, 볼을 비교하는 함수
     */
    private int countStrike(List<String> userNumber) {
        int strike = 0;
        for(int i = 0; i < userNumber.size(); i++) {
           if (userNumber.get(i).equals(computerNumber.get(i))) strike += 1;
        }
        return strike;
    }

    private int countBall(List<String> userNumber) {
        int ball = 0;
        for (String s : userNumber) {
            if (computerNumber.contains(s)) ball += 1;
        }
        return ball;
    }
}
