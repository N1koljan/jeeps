package com.example.jeeps.inocg3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "route") 
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_ID") 
    private Long routeId;

    @Column(name = "route_code")
    private String routeCode;

    @Column(name = "route_name") 
    private String routeName;

    @Column(name = "base_fare") 
    private double baseFare;

    @Column(name = "initial_km_covered") 
    private double initialKmCovered;

    @Column(name = "rate_per_km")
    private double ratePerKm;

    
    public RouteEntity() {
        // This empty constructor is required by JPA (Spring Data)
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }

    public double getInitialKmCovered() {
        return initialKmCovered;
    }

    public void setInitialKmCovered(double initialKmCovered) {
        this.initialKmCovered = initialKmCovered;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
}