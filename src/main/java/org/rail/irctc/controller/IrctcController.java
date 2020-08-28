package org.rail.irctc.controller;

import org.rail.irctc.dto.RouteDto;
import org.rail.irctc.dto.TrainDto;
import org.rail.irctc.entity.Route;
import org.rail.irctc.entity.Train;
import org.rail.irctc.service.IrctcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/irctc")
public class IrctcController {

    private static final Logger logger = LoggerFactory.getLogger(IrctcController.class);

    @Autowired
    private IrctcService irctcService;

    @PostMapping("/routes")
    public ResponseEntity<RouteDto> createRoute(@RequestBody Route route) {
        RouteDto newRoute = irctcService.createRoute(route);
        logger.info("New route created successfully !");
        return new ResponseEntity<RouteDto>(newRoute, HttpStatus.CREATED);
    }

    @GetMapping("/routes/{routeId}")
    public ResponseEntity<RouteDto> getRouteById(@PathVariable Integer routeId) {
        logger.info("Route detail retrieved successfully !");
        RouteDto routeById = irctcService.getRouteById(routeId);
        return new ResponseEntity<RouteDto>(routeById, HttpStatus.OK);
    }

    @GetMapping("/routes/trains")
    public ResponseEntity<List<TrainDto>> getRouteById(@RequestParam String source, @RequestParam String destination) {
        List<TrainDto> trainDetailsBySourceAndDestination = irctcService.getTrainDetailsBySourceAndDestination(source, destination);
        logger.info("Trains list details retrieved successfully for given source and destination !");
        return new ResponseEntity<List<TrainDto>>(trainDetailsBySourceAndDestination, HttpStatus.OK);
    }

    @PutMapping("/routes/{routeId}")
    public ResponseEntity<RouteDto> updateRouteById(@RequestBody Route route, @PathVariable Integer routeId) {
        RouteDto routeDto = irctcService.updateRouteById(route, routeId);
        logger.info("Updated route detail successfully !");
        return new ResponseEntity<RouteDto>(routeDto, HttpStatus.OK);
    }

    @DeleteMapping("/routes/{routeId}/{trainId}")
    public ResponseEntity<String> deleteTrainFromRoute(@PathVariable Integer routeId, @PathVariable Integer trainId) {
        String response = irctcService.deleteTrainFromRoute(routeId, trainId);
        logger.info("Selected train deleted from given route successfully");
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


    @PutMapping("/routes/{routeId}/{trainId}")
    public ResponseEntity<TrainDto> updateTrainDetailsOnRoute(@RequestBody Train train, @PathVariable Integer routeId, @PathVariable Integer trainId) {
        TrainDto trainDto = irctcService.updateTrainDetailsOnRoute(train, routeId, trainId);
        logger.info("Updated the train details on selected route successfully !");
        return new ResponseEntity<TrainDto>(trainDto, HttpStatus.OK);
    }

    @PostMapping("/trains")
    public ResponseEntity<TrainDto> createTrain(@RequestBody Train train) {
        TrainDto trainDetails = irctcService.createTrain(train);
        return new ResponseEntity<TrainDto>(trainDetails,HttpStatus.CREATED);
    }

    @PutMapping("/trains/{trainId}")
    public ResponseEntity<TrainDto> updateTrainFareById(@RequestBody Train train, @RequestParam Double fare) {
        TrainDto trainDto = irctcService.updateTrainFareById(train, fare);
        return new ResponseEntity<TrainDto>(trainDto,HttpStatus.OK);
    }

}
