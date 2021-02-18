package com.sergeev.onlinetraining.dao;

import com.sergeev.onlinetraining.config.DatabaseConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sea
 * @param <EntityType>
 */
public abstract class CRUDdaoImpl<EntityType> implements CRUDdao<EntityType> {

    protected abstract List<EntityType> parseResultSet(ResultSet rs);

    protected abstract String getCreateQuery(EntityType entity);

    protected abstract String getSelectQuery();

    protected abstract String getUpdateQuery(EntityType entity);

    protected abstract String getDeleteQuery(EntityType entity);

    private static final Logger LOG = LoggerFactory.getLogger(CRUDdaoImpl.class.getName());

    private final DatabaseConfig connect = new DatabaseConfig();
    private PreparedStatement pstmt;

    @Override
    public void create(EntityType entity) {
        String sql = getCreateQuery(entity);
        executeSQL(sql);
    }

    /**
     * Method for getting records from a database by the value of a single field
     *
     * @param mark - the name of the column in the database
     * @param param - value of the parameter of this column
     * @return List<EntityType>
     */
    @Override
    public List<EntityType> getAllByMark(String mark, String param) {
        List<EntityType> list = new LinkedList<>();
        String sql = getSelectQuery();
        sql += " where " + mark + " = '" + param + "'";
        try (Connection con = DriverManager.getConnection(
                connect.getUrl(), connect.getUser(), connect.getPassword());) {

            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException sqlEx) {
            LOG.error("error query getOneByMark ", sqlEx);
        }
        return list;
    }

    @Override
    public EntityType getOneByMark(String mark, String param) {
        final List<EntityType> list = getAllByMark(mark, param);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.iterator().next();
    }

    @Override
    public List<EntityType> getAll() {
        List<EntityType> list = new LinkedList<>();
        String sql = getSelectQuery();
        try (Connection con = DriverManager.getConnection(
                connect.getUrl(), connect.getUser(), connect.getPassword());) {

            pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException sqlEx) {
            LOG.error("error query getAll ", sqlEx);
        }
        return list;
    }

    @Override
    public void update(EntityType entity) {
        String sql = getUpdateQuery(entity);
        executeSQL(sql);
    }

    @Override
    public void delete(EntityType entity) {
        String sql = getDeleteQuery(entity);
        executeSQL(sql);
    }

    public void executeSQL(String sql) {
        LOG.info(sql);
        try (Connection con = DriverManager.getConnection(
                connect.getUrl(), connect.getUser(), connect.getPassword());) {

            pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException sqlEx) {
            LOG.error("query execution error ", sqlEx);
        }
    }

    @Override
    public Integer getLastId(EntityType entity) {
        try (Connection con = DriverManager.getConnection(
                connect.getUrl(), connect.getUser(), connect.getPassword());) {

            final String entityName = entity.getClass().getSimpleName().toLowerCase();
            String sql = "SELECT MAX(" + entityName + "id) FROM " + entityName;
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException sqlEx) {
            LOG.error("query execution error ", sqlEx);
        }
        return 0;
    }
}
