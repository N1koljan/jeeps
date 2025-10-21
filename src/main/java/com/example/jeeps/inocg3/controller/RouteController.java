package com.example.jeeps.inocg3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.jeeps.inocg3.entity.RouteEntity;
import com.example.jeeps.inocg3.service.RouteService;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    public RouteEntity createRoute(@RequestBody RouteEntity route) {
        return routeService.createRoute(route);
    }

    @GetMapping
    public List<RouteEntity> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteEntity> getRouteById(@PathVariable Long id) {
        return routeService.getRouteById(id)
                .map(route -> ResponseEntity.ok().body(route)) 
                .orElse(ResponseEntity.notFound().build());   
    }

    @PutMapping("/{id}")
    public ResponseEntity<RouteEntity> updateRoute(@PathVariable Long id, @RequestBody RouteEntity routeDetails) {
        try {
            RouteEntity updatedRoute = routeService.updateRoute(id, routeDetails);
            return ResponseEntity.ok(updatedRoute);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id) {
        try {
            routeService.deleteRoute(id);
            return ResponseEntity.ok().build(); 
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}