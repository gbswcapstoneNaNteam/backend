package gbsw.example.capstone.repository;

import gbsw.example.capstone.domain.Booktext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RandomIn extends JpaRepository<Booktext,Long> {
    List<Booktext> findByCode(int code);//랜덤 난수 기반 검색

}
