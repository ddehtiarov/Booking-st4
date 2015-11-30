package ua.nure.degtuaryov.SummaryTask4.db.dao;

import java.util.List;

import ua.nure.degtuaryov.SummaryTask4.db.entity.Train;

/**
 * Interface dao producing implementations TrainDAO
 * 
 * @author Degtuaryow
 *
 */
public interface TrainDAO {

	Train findTrainById(long id);

	List<Train> findAllTrains();

	boolean addTrain(Train train);

	boolean removeTrain(long id);

	boolean updateTrain(Train train);

}
