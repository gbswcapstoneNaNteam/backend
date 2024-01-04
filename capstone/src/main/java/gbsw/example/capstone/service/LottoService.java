package gbsw.example.capstone.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class LottoService {
    private final List<List<Integer>> lottoResults = new ArrayList<>();

    public List<Integer> drawLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        List<Integer> candidateNumbers = new ArrayList<>();

        // 1부터 45까지의 숫자를 candidateNumbers 리스트에 추가
        for (int i = 1; i <= 45; i++) {
            candidateNumbers.add(i);
        }

        Random random = new Random();

        // candidateNumbers에서 무작위로 7개의 숫자를 선택하여 lottoNumbers에 추가
        for (int i = 0; i < 7; i++) {
            int randomIndex = random.nextInt(candidateNumbers.size());
            int selectedNumber = candidateNumbers.remove(randomIndex);
            lottoNumbers.add(selectedNumber);
        }

        // 번호를 정렬하여 반환
        return lottoNumbers;
    }

    public List<List<Integer>> drawMultipleLottoResults(int count) {
        lottoResults.clear();

        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = drawLottoNumbers();
            lottoResults.add(lottoNumbers);
        }

        return lottoResults;
    }
}
