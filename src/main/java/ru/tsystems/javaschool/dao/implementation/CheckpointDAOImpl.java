package ru.tsystems.javaschool.dao.implementation;

import org.springframework.stereotype.Repository;
import ru.tsystems.javaschool.dao.CheckpointDAO;
import ru.tsystems.javaschool.entity.Checkpoint;

@Repository
public class CheckpointDAOImpl extends AbstractDAOImpl<Checkpoint> implements CheckpointDAO {

    public CheckpointDAOImpl() {
        super(Checkpoint.class);
    }

}
