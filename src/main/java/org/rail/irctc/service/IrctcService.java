package org.rail.irctc.service;

import org.modelmapper.ModelMapper;
import org.rail.irctc.dto.RouteDto;
import org.rail.irctc.dto.TrainDto;
import org.rail.irctc.entity.Route;
import org.rail.irctc.entity.Train;
import org.rail.irctc.repository.RouteRepository;
import org.rail.irctc.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IrctcService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private RouteRepository routeRepository;

    public RouteDto createRoute(Route route) {
        Route newRoute = routeRepository.save(route);
        return convertToRouteDto(newRoute);
    }

    public RouteDto getRouteById(Integer routeId) {
        Route routeByRouteId = routeRepository.findRouteByRouteId(routeId);
        return convertToRouteDto(routeByRouteId);
    }

    public List<TrainDto> getTrainDetailsBySourceAndDestination(String source, String destination) {
        Route routeBySourceAndDestination = routeRepository.findRouteBySourceAndDestination(source, destination);
        List<Train> trainList = routeBySourceAndDestination.getTrainList();
        return trainList.stream().map(this::convertToTrainDto).collect(Collectors.toList());
    }

    public RouteDto updateRouteById(Route route, Integer routeId) {
        Route routeByRouteId = routeRepository.findRouteByRouteId(routeId);
        Route updatedRoute = null;
        if (routeByRouteId.equals(route.getRouteId()) && routeByRouteId != null) {
            updatedRoute = routeRepository.save(route);
        } else {
            route.setRouteId(routeId);
            updatedRoute = routeRepository.save(route);
        }

        return convertToRouteDto(updatedRoute);
    }

    public String deleteTrainFromRoute(Integer routeId, Integer trainId) {
        Route routeByRouteId = routeRepository.findRouteByRouteId(routeId);
        if (routeByRouteId != null) {
            Train trainDetails = trainRepository.deleteTrainByTrainId(trainId);
            return "Deleted the train # " + trainDetails.getTrainId() + " from route " + trainDetails.getRoute().getRouteId();
        } else {
            return "Route does not exist";
        }
    }

    public TrainDto updateTrainDetailsOnRoute(Train train, Integer routeId, Integer trainId) {
        Route routeByRouteId = routeRepository.findRouteByRouteId(routeId);
        Train trainDetail = trainRepository.findTrainByTrainId(trainId);
        if (routeByRouteId != null && trainId.equals(trainDetail.getTrainId())) {
            Train trainDetails = trainRepository.save(train);
            return convertToTrainDto(trainDetail);
        } else {
            trainDetail.setTrainId(trainId);
            return convertToTrainDto(trainDetail);
        }
    }

    public TrainDto createTrain(Train train) {
        Train newTrain = trainRepository.save(train);
        return convertToTrainDto(newTrain);
    }

    public TrainDto updateTrainFareById(Train train, Double fare) {
        Train trainDetail = trainRepository.findTrainByTrainId(train.getTrainId());
        Train updatedTrainFare = null;
        if (trainDetail != null) {
            train.setFare(fare);
            updatedTrainFare = trainRepository.save(train);
        }
        return convertToTrainDto(updatedTrainFare);
    }


    private TrainDto convertToTrainDto(Train train) {
        TrainDto trainDto = modelMapper.map(train, TrainDto.class);
        return trainDto;
    }

    private RouteDto convertToRouteDto(Route route) {
        RouteDto routeDto = modelMapper.map(route, RouteDto.class);
        return routeDto;
    }
}
