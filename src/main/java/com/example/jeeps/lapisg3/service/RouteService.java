package com.example.jeeps.lapisg3.service;

import com.example.jeeps.lapisg3.entity.RouteEntity;
import com.example.jeeps.lapisg3.repository.RouteRepository;
import org.springframework.stereotype.Service;
// import org.springframework.util.RouteMatcher.Route; // <-- I REMOVED THIS UNUSED IMPORT

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    // --- CHANGED THIS SECTION ---
    // Removed @Autowired and added 'final'
    private final RouteRepository routeRepository;

    // Added the constructor for dependency injection
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }
    // --- END OF CHANGE ---

    // --- CREATE ---
    public RouteEntity createRoute(RouteEntity route) {
        return routeRepository.save(route);
    }

    // --- READ (All) ---
    public List<RouteEntity> getAllRoutes() {
        return routeRepository.findAll();
    }

    // --- READ (One by ID) ---
    public Optional<RouteEntity> getRouteById(Long routeId) {
        return routeRepository.findById(routeId);
    }

    // --- UPDATE ---
    public RouteEntity updateRoute(Long routeId, RouteEntity routeDetails) {
        // Find the existing route by its ID
        RouteEntity existingRoute = routeRepository.findById(routeId)
                .orElseThrow(() -> new RuntimeException("Route not found with id: " + routeId));

        // Update the fields with the new details
        existingRoute.setRouteCode(routeDetails.getRouteCode());
        existingRoute.setRouteName(routeDetails.getRouteName());
        existingRoute.setBaseFare(routeDetails.getBaseFare());
        existingRoute.setInitialKmCovered(routeDetails.getInitialKmCovered());
        existingRoute.setRatePerKm(routeDetails.getRatePerKm());

        // Save the updated route back to the database
        return routeRepository.save(existingRoute);
    }

    // --- DELETE ---
    public void deleteRoute(Long routeId) {
        routeRepository.deleteById(routeId);
    }
}