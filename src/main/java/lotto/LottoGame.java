package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.*;

public class LottoGame {
    private static final int INVALID_NUMBER = -1;
    private static final int LOTTO_PRICE = 1000;
    final String LOTTO_REGEX = "[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+";

    private Lotto winningLotto;
    private int bonusNumber;
    private int money;
    private ArrayList<Lotto> lottoArray;

    public void play() {
        money = inputMoney();
        if (money == INVALID_NUMBER) return;
        int lottoCount = money / LOTTO_PRICE;
        System.out.println(lottoCount + "개를 구매했습니다.");
        lottoArray = lottoMachine(lottoCount);
        printLotto(lottoArray);

        winningLotto = inputWinNumbers();
        if (winningLotto == null) return;

        bonusNumber = inputBonusNumber();
        if (bonusNumber == INVALID_NUMBER) return;

        //System.out.println("당첨번호는 "+ winningLotto.getNumbers() + " \n보너스 번호는 " + bonusNumber);
        ArrayList<Integer> result = calculateResult();
        printResult(result);
    }

    private int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        try {
            validateInputMoney(inputMoney);
            return Integer.parseInt(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return INVALID_NUMBER;
        }
    }

    private void validateInputMoney(String inputMoney) throws IllegalArgumentException {
        int parsedMoney;
        try {
            parsedMoney = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 돈 값을 입력했습니다.");
        }

        if (parsedMoney < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000 미만의 값을 입력했습니다.");
        }
    }

    private ArrayList<Lotto> lottoMachine(int lottoCount) {
        ArrayList<Lotto> lottoArray = new ArrayList<>(lottoCount);
        for(int i = 0; i<lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoArray.add(new Lotto(numbers));
        }
        return lottoArray;
    }

    private void printLotto(ArrayList<Lotto> lottoArray) {
        for (Lotto lotto : lottoArray) {
            System.out.println(lotto.getNumbers());
        }
    }

    private Lotto inputWinNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String inputWinNumber = Console.readLine();

        try {
            validateWinNumbers(inputWinNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

        String[] winNumberStringArray = inputWinNumber.split(",");
        List<Integer> winNumberIntegerArray = new ArrayList<>(0);
        for(String num: winNumberStringArray) {
            winNumberIntegerArray.add(Integer.parseInt(num));
        }
        return new Lotto(winNumberIntegerArray);
    }

    private void validateWinNumbers(String inputMoney) throws IllegalArgumentException {
        if (!inputMoney.matches(LOTTO_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력 형식이 잘못되었습니다.");
        }
        // 1~45 검사 로직 추가
    }

    private int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumberString = Console.readLine();
        try {
            validateBonusNumber(bonusNumberString);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return INVALID_NUMBER;
        }
        return Integer.parseInt(bonusNumberString);
    }

    private void validateBonusNumber(String bonusNumberString) {
        int parsefBonusNumber;
        try {
            parsefBonusNumber = Integer.parseInt(bonusNumberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 보너스 번호 형식입니다.");
        }
        if (parsefBonusNumber < 1 || parsefBonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 잘못된 보너스 번호 입니다.");
        }
    }

    private ArrayList<Integer> calculateResult() {
        ArrayList<Integer> winLottoAry = winningLotto.getNumbers();
        int _1 = 0, _2 = 0, _3 = 0, _4 = 0, _5 = 0;
        for(Lotto lotto: lottoArray) {
            ArrayList<Integer> lottoNumAry = lotto.getNumbers();
            boolean bonusMatch = lottoNumAry.contains(bonusNumber);

            lottoNumAry.retainAll(winLottoAry);
            int matchNum = lottoNumAry.size();

            switch (matchNum) {
                case 3:
                    _5 += 1;
                    break;
                case 4:
                    _4 += 1;
                    break;
                case 5:
                    if (bonusMatch) _2 += 1;
                    else _3 += 1;
                    break;
                case 6:
                    _1 += 1;
                    break;
            }
        }
        return new ArrayList<>(List.of(_1, _2, _3, _4, _5));
    }

    private void printResult(ArrayList<Integer> result) {
        System.out.println("\n당첨 통계\n---");
        int moneyEarn = 0;
        for(int i = 0; i < result.size(); i++) {
            int rankNum = result.get(i);
            switch (i+1) {
                case 5:
                    System.out.println("3개 일치 (5,000원) - " + rankNum + "개");
                    moneyEarn += 5000 * rankNum;
                    break;
                case 4:
                    System.out.println("4개 일치 (50,000원) - " + rankNum + "개");
                    moneyEarn += 50000 * rankNum;
                    break;
                case 3:
                    System.out.println("5개 일치 (1,500,000원) - " + rankNum + "개");
                    moneyEarn += 1500000 * rankNum;
                    break;
                case 2:
                    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankNum + "개");
                    moneyEarn += 30000000 * rankNum;
                    break;
                case 1:
                    System.out.println("6개 일치 (2,000,000,000원) - " + rankNum + "개");
                    moneyEarn += 2000000000 * rankNum;
                    break;
            }
        }
        double moneyPercent;
        if (moneyEarn == 0)  moneyPercent = 0.0;
        else moneyPercent = moneyEarn / (double) money * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", moneyPercent);
    }
}
