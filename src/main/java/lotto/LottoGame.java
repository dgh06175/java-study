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

        Map<LottoRank, Integer> result = calculateResult(winningLotto, bonusNumber);
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

    private Map<LottoRank, Integer> calculateResult(Lotto winningLotto, int bonusNumber) {
        Map<LottoRank, Integer> lottoWins = new HashMap<>();
        for (LottoRank rank: LottoRank.values()) {
            lottoWins.put(rank, 0);
        }

        for(Lotto lotto: lottoArray) {
            LottoRank rank = winningLotto.match(lotto, bonusNumber);
            lottoWins.put(rank, lottoWins.get(rank) + 1);
        }

        return lottoWins;
    }

    private void printResult(Map<LottoRank, Integer> result) {
        System.out.println("\n당첨 통계\n---");
        String[] resultStrings = new String[6];
        int totalMoneyEarn = 0;
        for (LottoRank rank: result.keySet()) {
            totalMoneyEarn += rank.getPrice() * result.get(rank);
            resultStrings[rank.ordinal()] = rank.returnRankInfo(result.get(rank));
        }
        for(String resultString: resultStrings) {
            if (resultString.isEmpty()) continue;
            System.out.println(resultString);
        }

        double moneyPercent;
        if (totalMoneyEarn == 0)  moneyPercent = 0.0;
        else moneyPercent = totalMoneyEarn / (double) money * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", moneyPercent);
    }
}
