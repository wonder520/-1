package com.xmcc.dao.Impl;

import com.xmcc.dao.BatchDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AbstractBatchDao<T> implements BatchDao<T> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public void batchInsert(List<T> list) {
        long length = list.size();
        for (int i = 0; i < length;i++){
            em.persist(list.get(i));
            if (i % 100 == 0 || i == length-1){
                em.flush();
                em.clear();
            }
        }
    }
}
