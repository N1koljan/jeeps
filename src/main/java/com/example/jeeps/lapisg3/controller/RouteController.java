package com.example.jeeps.lapisg3.controller;

import com.example.jeeps.lapisg3.entity.RouteEntity;
import com.example.jeeps.lapisg3.service.RouteService;
// import org.springframework.beans.factory.annotation.Autowired; // <-- REMOVED THIS
import org.springframework.http.ResponseEntity;
// import org.springframework.util.RouteMatcher.Route; // <-- REMOVED THIS UNUSED IMPORT
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes") // This is the base URL: http://localhost:8080/api/routes
public class RouteController {

    // --- CHANGED THIS SECTION ---
    // Removed @Autowired and added 'final'
    private final RouteService routeService;

    // Added the constructor for dependency injection
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }
    // --- END OF CHANGE ---

    // --- CREATE ---
    // POST http://localhost:8080/api/routes
    @PostMapping
    public RouteEntity createRoute(@RequestBody RouteEntity route) {
        return routeService.createRoute(route);
    }

    // --- READ (All) ---
    // GET http://localhost:8080/api/routes
    @GetMapping
    public List<RouteEntity> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    // --- READ (One by ID) ---
    // GET http://localhost:8080/api/routes/1
    @GetMapping("/{id}")
    public ResponseEntity<RouteEntity> getRouteById(@PathVariable Long id) {
        return routeService.getRouteById(id)
                .map(route -> ResponseEntity.ok().body(route)) // Found it, return 200 OK
                .orElse(ResponseEntity.notFound().build());    // Didn't find it, return 404 Not Found
    }

    // --- UPDATE ---
    // PUT http://localhost:8080/api/routes/1
    @PutMapping("/{id}")
    public ResponseEntity<RouteEntity> updateRoute(@PathVariable Long id, @RequestBody RouteEntity routeDetails) {
        try {
            RouteEntity updatedRoute = routeService.updateRoute(id, routeDetails);
            return ResponseEntity.ok(updatedRoute);
        } catch (RuntimeException e) {
            // This catches the "Route not found" error from the service
            return ResponseEntity.notFound().build();
        }
    }

    // --- DELETE ---
    // DELETE http://localhost:8080/api/routes/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id) {
        try {
            routeService.deleteRoute(id);
            return ResponseEntity.ok().build(); // Return 200 OK with no body
        } catch (Exception e) {
            // This catches errors, e.g., if the ID doesn't exist
            return ResponseEntity.notFound().build();
        }
    }
}