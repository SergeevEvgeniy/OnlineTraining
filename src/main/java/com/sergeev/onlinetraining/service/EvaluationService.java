package com.sergeev.onlinetraining.service;

import com.sergeev.onlinetraining.dao.CRUDdao;
import com.sergeev.onlinetraining.dao.impl.EvaluationDaoImpl;
import com.sergeev.onlinetraining.model.Evaluation;

/**
 *
 * @author sea
 */
public class EvaluationService {

    private final CRUDdao<Evaluation> dao = new EvaluationDaoImpl();

    public void create(Evaluation e) {
        e.setId(dao.getLastId(e) + 1);
        dao.create(e);
    }

    public void delete(Evaluation e) {
        dao.delete(e);
    }

    public Evaluation getById(String param) {
        return dao.getOneByMark("evaluationId", param);
    }
}
