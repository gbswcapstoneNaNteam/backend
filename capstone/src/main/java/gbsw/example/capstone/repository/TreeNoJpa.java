package gbsw.example.capstone.repository;

import gbsw.example.capstone.controller.Form;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeNoJpa {
    String deleteTree(int code, String name, String password);//삭제

    String updateTree(int code, Form form);
}
