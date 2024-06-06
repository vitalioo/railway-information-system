package com.example.railwayinformationsystem.service.impl;

import com.example.railwayinformationsystem.exception.RouteNotFoundException;
import com.example.railwayinformationsystem.model.entity.Route;
import com.example.railwayinformationsystem.repository.RouteRepository;
import com.example.railwayinformationsystem.service.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper mapper;

    @Override
    public Route getById(Integer id) {
        return routeRepository.findById(id).orElseThrow(() -> new RouteNotFoundException("Route with id " + id + " not found"));
    }

    @Override
    public void deleteById(Integer id) {
        routeRepository.delete(getById(id));
        log.debug("Route with id {} deleted", id);
    }

    @Override
    public void save(Route route) {
        routeRepository.save(route);
        log.debug("Route with id {} saved", route.getId());
    }

    @Override
    public List<Route> getAll() {
        List<Route> routes = routeRepository.findAll();
        log.debug("{} routes found", routes.size());
        return routes;
    }

    @Override
    public void update(Route route) {
        Route dbRoute = getById(route.getId());
        mapper.map(route, dbRoute);
        routeRepository.save(dbRoute);
        log.debug("Route with id {} updated", route.getId());
    }

    @Override
    public List<String> findAllByInitialDestination() {
        return routeRepository.findAllByInitialDestination();
    }

    @Override
    public List<String> findAllByFinalDestination() {
        return routeRepository.findAllByFinalDestination();
    }

    @Override
    public List<Route> findAllByCanceled(Boolean canceled) {
        return routeRepository.findAllByCanceled(canceled);
    }

    @Override
    public int countAllByCanceled(Boolean canceled) {
        return routeRepository.countAllByCanceled(canceled);
    }

    @Override
    public List<Route> findAllByFinalDestination(String finalDestination) {
        return routeRepository.findAllByFinalDestination(finalDestination);
    }

    @Override
    public int countAllByFinalDestination(String finalDestination) {
        return routeRepository.countAllByFinalDestination(finalDestination);
    }

    @Override
    public List<Route> findAllByInitialDestinationAndFinalDestination(String initialDestination, String finalDestination) {
        return routeRepository.findAllByInitialDestinationAndFinalDestination(initialDestination, finalDestination);
    }

    @Override
    public int countAllByInitialDestinationAndFinalDestination(String initialDestination, String finalDestination) {
        return routeRepository.countAllByInitialDestinationAndFinalDestination(initialDestination, finalDestination);
    }

    @Override
    public List<Route> findAllByDelayReason() {
        return routeRepository.findAllByDelayReason();
    }

    @Override
    public int countAllByDelayReason() {
        return routeRepository.countAllByDelayReason();
    }

    @Override
    public List<Route> findAllByDelayReason(String reason) {
        return routeRepository.findAllByDelayReason(reason);
    }

    @Override
    public int countAllByDelayReason(String reason) {
        return routeRepository.countAllByDelayReason(reason);
    }

    @Override
    public List<Route> findAllByDelayReasonAndDestination(String initialDestination, String finalDestination) {
        return routeRepository.findAllByDelayReasonAndDestination(initialDestination, finalDestination);
    }

    @Override
    public int countAllByDelayReasonAndDestination(String initialDestination, String finalDestination) {
        return routeRepository.countAllByDelayReasonAndDestination(initialDestination, finalDestination);
    }

    @Override
    public List<Route> findAllByRouteTypeAndFinalDestination(String routeType, String finalDestination) {
        return routeRepository.findAllByRouteTypeAndFinalDestination(routeType, finalDestination);
    }

    @Override
    public int countAllByRouteTypeAndFinalDestination(String routeType, String finalDestination) {
        return routeRepository.countAllByRouteTypeAndFinalDestination(routeType, finalDestination);
    }

    @Override
    public List<String> getAllRouteTypes() {
        return routeRepository.findAll()
                .stream()
                .map(Route::getRouteType)
                .distinct()
                .toList();
    }

    @Override
    public List<String> getAllInitialDestinations() {
        return routeRepository.findAll()
                .stream()
                .map(Route::getInitialDestination)
                .distinct()
                .toList();
    }

    public List<String> getAllFinalDestinations() {
        return routeRepository.findAll()
                .stream()
                .map(Route::getFinalDestination)
                .distinct()
                .toList();
    }
}
