package gbsw.example.capstone.service;

import gbsw.example.capstone.controller.Form;
import gbsw.example.capstone.domain.Daetree;
import gbsw.example.capstone.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TreeService {

    private final Treein treein;
    private final TreeRepository treeRepository;

    @Autowired
    public TreeService(Treein treein, TreeRepository treeRepository) {
        this.treein = treein;

        this.treeRepository = treeRepository;
    }

    public List<DaetreeProjection> findAll() {
        return treein.findAllByOrderByCodeDesc();
    }//글목록

    public String create(Daetree daetree) {
       treein.save(daetree);
       return "완료";
    }//글 생성

    public List<DaetreeProjection> findFull(String title) {
        return treein.findAllByTitleContaining(title);
    }//제목검색

    public List<TreeProjection> findCode(int code) {
        return treein.findByCode(code);
    }//코드로 상세정보 검색

    public String delete(int code, String name, String password) {
        return treeRepository.deleteTree(code,name,password);
    }//삭제

    public String update(int code, Form form) {
        return treeRepository.updateTree(code,form);
    }
}
