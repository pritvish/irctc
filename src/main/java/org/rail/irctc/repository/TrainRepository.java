package org.rail.irctc.repository;

import org.rail.irctc.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train,Integer> {

    public Train deleteTrainByTrainId(Integer trainId);
    public Train findTrainByTrainId(Integer trainId);
}
