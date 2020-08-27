package org.rail.irctc.dto;

import org.rail.irctc.entity.Train;

import java.util.List;

public class RouteDto {

    private Integer routeId;
    private String source;
    private String destination;
    private List<Train> trainList;

    public RouteDto(Integer routeId, String source, String destination, List<Train> trainList) {
        this.routeId = routeId;
        this.source = source;
        this.destination = destination;
        this.trainList = trainList;
    }

    public RouteDto() {
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
    }

    @Override
    public String toString() {
        return "RouteDto{" +
                "routeId=" + routeId +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", trainList=" + trainList +
                '}';
    }
}
