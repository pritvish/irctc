package org.rail.irctc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Route {

    @Id
    private Integer routeId;
    private String source;
    private String destination;
    private List<Train> trainList;

    public Route(Integer routeId, String source, String destination, List<Train> trainList) {
        this.routeId = routeId;
        this.source = source;
        this.destination = destination;
        this.trainList = trainList;
    }

    public Route() {
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
        return "Route{" +
                "routeId=" + routeId +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", trainList=" + trainList +
                '}';
    }
}
