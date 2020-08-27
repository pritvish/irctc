package org.rail.irctc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Train {

    @Id
    private Integer trainId;
    private String trainName;
    private String arrivalTime;
    private String departureTime;
    private Double fare;

    public Train(Integer trainId, String trainName, String arrivalTime, String departureTime, Double fare) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.fare = fare;
    }

    public Train() {
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId=" + trainId +
                ", trainName='" + trainName + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", fare=" + fare +
                '}';
    }
}
