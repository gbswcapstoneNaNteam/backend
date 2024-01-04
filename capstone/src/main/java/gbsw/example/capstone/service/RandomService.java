package gbsw.example.capstone.service;

import gbsw.example.capstone.domain.Booktext;
import gbsw.example.capstone.repository.RandomIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class RandomService {

    private final RandomIn randomIn;

    @Autowired
    public RandomService(RandomIn randomIn) {
        this.randomIn = randomIn;
    }

    public List<Booktext> randomText() {
        int size = getColumnCount();
        Random random = new Random();
        int i = random.nextInt(128) + 1;
        return randomIn.findByCode(i);
    }//난수 결정 및 레피지토리에 보내기

    @PersistenceContext
    private EntityManager entityManager;
    public int getColumnCount() {
        String sql = "SELECT COUNT(*) AS total_records FROM  BookText";
        Number count = (Number) entityManager.createNativeQuery(sql).getSingleResult();
        int intCount = count.intValue();

        return intCount;
    }//난수 범위 결정
}