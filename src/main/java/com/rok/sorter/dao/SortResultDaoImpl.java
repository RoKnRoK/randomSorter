package com.rok.sorter.dao;

import com.rok.sorter.model.SortResult;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by roman.kulikov on 5/16/2017.
 * All rights reserved =D
 */
@Transactional
@Repository
public class SortResultDaoImpl implements SortResultDao {
    @PersistenceContext
    private EntityManager entityManager;


    @SuppressWarnings("unchecked")
    @Override
    public List<SortResult> fetchAllSortResults() {
        String hql = "FROM SortResult as sr ORDER BY sr.id";
        return (List<SortResult>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addSortResult(SortResult sortResult) {
        entityManager.persist(sortResult);
    }
}
