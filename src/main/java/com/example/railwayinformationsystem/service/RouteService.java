package com.example.railwayinformationsystem.service;

import com.example.railwayinformationsystem.model.entity.Route;

import java.util.List;

public interface RouteService {
    public Route getById(Integer id);

    public void deleteById(Integer id);

    public void save(Route route);

    public List<Route> getAll();

    public void update(Route route);

    public List<String> findAllByInitialDestination();

    public List<String> findAllByFinalDestination();

    List<Route> findAllByCanceled(Boolean canceled);

    int countAllByCanceled(Boolean canceled);

    List<Route> findAllByFinalDestination(String finalDestination);

    int countAllByFinalDestination(String finalDestination);

    List<Route> findAllByInitialDestinationAndFinalDestination(String initialDestination, String finalDestination);

    int countAllByInitialDestinationAndFinalDestination(String initialDestination, String finalDestination);

    List<Route> findAllByDelayReason();

    int countAllByDelayReason();

    List<Route> findAllByDelayReason(String reason);

    int countAllByDelayReason(String reason);

    List<Route> findAllByDelayReasonAndDestination(String initialDestination, String finalDestination);

    int countAllByDelayReasonAndDestination(String initialDestination, String finalDestination);

    List<Route> findAllByRouteTypeAndFinalDestination(String routeType, String finalDestination);

    int countAllByRouteTypeAndFinalDestination(String routeType, String finalDestination);

    List<String> getAllRouteTypes();

    List<String> getAllInitialDestinations();

    List<String> getAllFinalDestinations();
}
