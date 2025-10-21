package com.example.jeeps.lapisg3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "route") // Matches your diagram table name
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_ID") // Matches ERD column
    private Long routeId;

    @Column(name = "route_code") // Matches ERD column
    private String routeCode;

    @Column(name = "route_name") // Matches ERD column
    private String routeName;

    @Column(name = "base_fare") // Matches ERD column
    private double baseFare;

    @Column(name = "initial_km_covered") // Matches ERD column
    private double initialKmCovered;

    @Column(name = "rate_per_km") // Matches ERD column
    private double ratePerKm;

    // --- Constructors ---
    public RouteEntity() {
        // This empty constructor is required by JPA (Spring Data)
    }

    // --- Getters and Setters ---
    // (We need all of them for Spring)

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