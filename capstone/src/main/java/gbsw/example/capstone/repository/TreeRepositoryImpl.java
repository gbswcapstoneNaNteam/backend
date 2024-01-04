package gbsw.example.capstone.repository;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class TreeRepositoryImpl extends TreeRepository {

    public TreeRepositoryImpl(EntityManager em) {
        super(em);
    }
}