package com.sergeev.onlinetraining.service;

import com.sergeev.onlinetraining.dao.CRUDdao;
import com.sergeev.onlinetraining.dao.impl.EvaluationDaoImpl;
import com.sergeev.onlinetraining.dao.impl.TaskDaoImpl;
import com.sergeev.onlinetraining.model.Evaluation;
import com.sergeev.onlinetraining.model.Task;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sea
 */
public class TaskService {

    private final CRUDdao<Task> dao = new TaskDaoImpl();

    public void create(Task task) {
        task.setId(dao.getLastId(task) + 1);
        dao.create(task);
    }

    public List<Task> getAll() {
        return dao.getAll();
    }

    public Task getById(String param) {
        return dao.getOneByMark("taskId", param);
    }

    public void update(Task task) {
        dao.update(task);
    }

    public void delete(Task task) {
        dao.delete(task);
    }

    public List<Evaluation> getGrades(Task task) {
        final List<Evaluation> allGradesForTask = new EvaluationDaoImpl().getAllByMark("taskid", Integer.toString(task.getId()));
        List<Evaluation> result = new ArrayList<>();
        for (Evaluation grade : allGradesForTask) {
            if (grade.getTask().equals(task)) {
                result.add(grade);
            }
        }
        return result;
    }
}
