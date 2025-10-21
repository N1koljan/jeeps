package com.example.jeeps.lapisg3.service;

import com.example.jeeps.lapisg3.entity.RouteEntity;
import com.example.jeeps.lapisg3.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public RouteEntity createRoute(RouteEntity route) {
        return routeRepository.save(route);
    }

    public List<RouteEntity> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Optional<RouteEntity> getRouteById(Long routeId) {
        return routeRepository.findById(routeId);
    }

    public RouteEntity updateRoute(Long routeId, RouteEntity routeDetails) {

        RouteEntity existingRoute = routeRepository.findById(routeId)
                .orElseThrow(() -> new RuntimeException("Route not found with id: " + routeId));

        existingRoute.setRouteCode(routeDetails.getRouteCode());
        existingRoute.setRouteName(routeDetails.getRouteName());
        existingRoute.setBaseFare(routeDetails.getBaseFare());
        existingRoute.setInitialKmCovered(routeDetails.getInitialKmCovered());
        existingRoute.setRatePerKm(routeDetails.getRatePerKm());

        return routeRepository.save(existingRoute);
    }

    public void deleteRoute(Long routeId) {
        routeRepository.deleteById(routeId);
    }
}