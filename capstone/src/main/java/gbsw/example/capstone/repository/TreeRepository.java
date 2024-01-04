package gbsw.example.capstone.repository;

import gbsw.example.capstone.controller.Form;
import gbsw.example.capstone.domain.Daetree;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
    public abstract class TreeRepository implements TreeNoJpa {
        private final EntityManager em;



    protected TreeRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public String deleteTree(int code, String name, String password) {
        String dbname = em.createNativeQuery("select d.name from Daetree d where d.code = "+code).getSingleResult().toString();
        String dbpassword = em.createNativeQuery("select d.password from Daetree d where d.code = "+code).getSingleResult().toString();
        if(dbname.equals(name) && dbpassword.equals(password)) {
            Query deleteQuery = em.createQuery("delete from Daetree where code = "+code);
            deleteQuery.executeUpdate();
            return "성공";
        }
        return "실패";

    }

    @Override
    public String updateTree(int code,Form form) {
        String dbname = em.createNativeQuery("select d.name from Daetree d where d.code = "+code).getSingleResult().toString();
        String dbpassword = em.createNativeQuery("select d.password from Daetree d where d.code = "+code).getSingleResult().toString();
        if(dbname.equals(form.getName()) && dbpassword.equals(form.getPassword())) {
            Query deleteQuery = em.createQuery("UPDATE Daetree set title = '"+form.getTitle()+"',content ='"+form.getContent()+"' where code = "+code);
            deleteQuery.executeUpdate();
            return "성공";
        }
        return "실패";
    }
}
