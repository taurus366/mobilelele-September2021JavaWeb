package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.service.RouteServiceModel;
import bg.softuni.pathfinder.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesView();

    void postRoute(RouteServiceModel routeServiceModel);
}
