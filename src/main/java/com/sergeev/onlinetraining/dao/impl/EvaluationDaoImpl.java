package com.sergeev.onlinetraining.dao.impl;

import com.sergeev.onlinetraining.dao.CRUDdaoImpl;
import com.sergeev.onlinetraining.model.Evaluation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sea
 */
public class EvaluationDaoImpl extends CRUDdaoImpl<Evaluation> {

    private static final Logger LOG = LoggerFactory.getLogger(EvaluationDaoImpl.class.getName());

    @Override
    protected List<Evaluation> parseResultSet(ResultSet rs) {
        List<Evaluation> result = new LinkedList<>();
        try {

            while (rs.next()) {
                UserDaoImpl udi = new UserDaoImpl();
                TaskDaoImpl tdi = new TaskDaoImpl();
                Evaluation evaluation = new Evaluation();
                evaluation.setId(rs.getInt("evaluationid"));
                evaluation.setGrade(rs.getInt("grade"));
                evaluation.setComment(rs.getString("comment"));
                evaluation.setStudent(udi.getOneByMark("userid", rs.getString("subscriberid")));
                evaluation.setTask(tdi.getOneByMark("taskid", rs.getString("taskid")));
                result.add(evaluation);
            }
        } catch (SQLException ex) {
            LOG.error("Error parsing Evaluation ", ex);
        }
        return result;
    }

    @Override
    protected String getCreateQuery(Evaluation evaluation) {
        return "INSERT INTO \"PUBLIC\".EVALUATION VALUES ("
                + evaluation.getId()
                + ", "
                + evaluation.getGrade()
                + ", '"
                + evaluation.getComment()
                + "', "
                + evaluation.getStudent().getId()
                + ", "
                + evaluation.getTask().getId()
                + ")";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM \"PUBLIC\".EVALUATION";
    }

    @Override
    protected String getUpdateQuery(Evaluation evaluation) {
        return "UPDATE \"PUBLIC\".EVALUATION SET "
                + "GRADE = " + evaluation.getGrade()
                + ", COMMENT ='" + evaluation.getComment() + "'"
                + ", SUBSCRIBERID = " + evaluation.getStudent().getId()
                + ", TASKID = " + evaluation.getTask().getId()
                + " WHERE EVALUATIONID = 1";
    }

    @Override
    protected String getDeleteQuery(Evaluation evaluation) {
        return "DELETE FROM \"PUBLIC\".EVALUATION WHERE EVALUATIONID = " + evaluation.getId();
    }

}
