package com.sergeev.onlinetraining.service;

import com.sergeev.onlinetraining.dao.CRUDdao;
import com.sergeev.onlinetraining.dao.impl.SubscriptionDaoImpl;
import com.sergeev.onlinetraining.model.Subscription;

/**
 *
 * @author sea
 */
public class SubscriptionService {

    private final CRUDdao<Subscription> dao = new SubscriptionDaoImpl();

    public void delete(Integer subscriptionId) {
        Subscription oneByMark = dao.getOneByMark("subscriptionid", subscriptionId.toString());
        dao.delete(oneByMark);
    }

    public void create(Subscription s) {
        s.setId(dao.getLastId(s) + 1);
        dao.create(s);
    }
}
