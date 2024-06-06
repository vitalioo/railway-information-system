package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Integer> {
    @Query("select r.initialDestination from Route r")
    List<String> findAllByInitialDestination();

    @Query("select r.finalDestination from Route r")
    List<String> findAllByFinalDestination();

    @Query("select r from Route r where r.canceled = ?1")
    List<Route> findAllByCanceled(Boolean canceled);

    @Query("select count(r) from Route r where r.canceled = ?1")
    int countAllByCanceled(Boolean canceled);

    @Query("select r from Route r where r.finalDestination = ?1")
    List<Route> findAllByFinalDestination(String finalDestination);

    @Query("select count(r) from Route r where r.finalDestination = ?1")
    int countAllByFinalDestination(String finalDestination);

    @Query("select r from Route r where r.initialDestination = ?1 and r.finalDestination = ?2")
    List<Route> findAllByInitialDestinationAndFinalDestination(String initialDestination, String finalDestination);

    @Query("select count(r) from Route r where r.initialDestination = ?1 and r.finalDestination = ?2")
    int countAllByInitialDestinationAndFinalDestination(String initialDestination, String finalDestination);

    @Query("select r from Route r join Schedule s on r.id = s.route.id join s.delayReason d where d.reason IS NOT NULL")
    List<Route> findAllByDelayReason();

    @Query("select count(r) from Route r join Schedule s on r.id = s.route.id join s.delayReason d where d.reason IS NOT NULL")
    int countAllByDelayReason();

    @Query("select r from Route r join Schedule s on r.id = s.route.id join s.delayReason d where d.reason = ?1")
    List<Route> findAllByDelayReason(String reason);

    @Query("select count(r) from Route r join Schedule s on r.id = s.route.id join s.delayReason d where d.reason = ?1")
    int countAllByDelayReason(String reason);

    @Query("select r from Route r join Schedule s on r.id = s.route.id join s.delayReason d where d.reason IS NOT NULL and r.initialDestination = ?1 and r.finalDestination = ?2")
    List<Route> findAllByDelayReasonAndDestination(String initialDestination, String finalDestination);

    @Query("select count(r) from Route r join Schedule s on r.id = s.route.id join s.delayReason d where d.reason IS NOT NULL and r.initialDestination = ?1 and r.finalDestination = ?2")
    int countAllByDelayReasonAndDestination(String initialDestination, String finalDestination);

    @Query("select r from Route r where r.routeType = ?1 and r.finalDestination = ?2")
    List<Route> findAllByRouteTypeAndFinalDestination(String routeType, String finalDestination);

    @Query("select count(r) from Route r where r.routeType = ?1 and r.finalDestination = ?2")
    int countAllByRouteTypeAndFinalDestination(String routeType, String finalDestination);
}