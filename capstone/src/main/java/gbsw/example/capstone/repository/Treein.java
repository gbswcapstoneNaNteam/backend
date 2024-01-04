package gbsw.example.capstone.repository;

import gbsw.example.capstone.domain.Daetree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Treein extends JpaRepository<Daetree,Long> {
    List<DaetreeProjection> findAllByOrderByCodeDesc();//대나무 게시판 목록

    List<DaetreeProjection> findAllByTitleContaining(String title);//대나무 게시판 제목검색

    List<TreeProjection> findByCode(int code);//상세정보



}
