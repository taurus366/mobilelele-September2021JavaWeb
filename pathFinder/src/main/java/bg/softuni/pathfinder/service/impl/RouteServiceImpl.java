package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.model.service.RouteServiceModel;
import bg.softuni.pathfinder.model.view.RouteViewModel;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.service.CategoryService;
import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    @Override
    public List<RouteViewModel> findAllRoutesView() {



        return routeRepository
                .findAll()
                .stream()
                .map(route -> {
                    RouteViewModel routeViewModel = modelMapper.map(route,RouteViewModel.class);
                if (route.getPictures().isEmpty()){
                    routeViewModel.setPictureUrl("/images/pic4.jpg");
                }else {
                    routeViewModel.setPictureUrl(route.getPictures().stream().findFirst().get().getUrl());
                }

                  return routeViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void postRoute(RouteServiceModel routeServiceModel) {
        Route route = modelMapper.map(routeServiceModel,Route.class);
        route.setAuthor(userService.findCurrentLoginUserEntity());
        route.setCategories(routeServiceModel
                .getCategories()
                .stream()
                .map(categoryService::findByName)
                .collect(Collectors.toSet()));

        routeRepository.save(route);
    }
}
