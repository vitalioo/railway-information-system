package com.example.railwayinformationsystem.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class RouteStationId implements Serializable {
    private static final long serialVersionUID = -1402260339107286225L;
    @Column(name = "route_id", nullable = false)
    private Integer routeId;

    @Column(name = "station_id", nullable = false)
    private Integer stationId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RouteStationId entity = (RouteStationId) o;
        return Objects.equals(this.routeId, entity.routeId) &&
                Objects.equals(this.stationId, entity.stationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, stationId);
    }

}