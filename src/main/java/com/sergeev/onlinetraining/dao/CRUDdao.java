package com.sergeev.onlinetraining.dao;

import java.util.List;

/**
 *
 * @author sea
 * @param <EntityType>
 */
public interface CRUDdao<EntityType> {

    public void create(EntityType entity);

    public List<EntityType> getAllByMark(String mark, String param);

    public EntityType getOneByMark(String mark, String param);

    public List<EntityType> getAll();

    public void update(EntityType entity);

    public void delete(EntityType entity);
}
