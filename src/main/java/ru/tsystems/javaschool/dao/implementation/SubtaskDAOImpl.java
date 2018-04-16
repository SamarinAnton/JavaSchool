package ru.tsystems.javaschool.dao.implementation;

import org.springframework.stereotype.Repository;
import ru.tsystems.javaschool.dao.SubtaskDAO;
import ru.tsystems.javaschool.entity.Subtask;

@Repository
public class SubtaskDAOImpl extends AbstractDAOImpl<Subtask> implements SubtaskDAO {

    public SubtaskDAOImpl() {
        super(Subtask.class);
    }

}
