package org.rail.irctc.repository;

import org.rail.irctc.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route,Integer> {

    public Route findRouteByRouteId(Integer routeId);
    public Route findRouteBySourceAndDestination(String source, String destination);
}
