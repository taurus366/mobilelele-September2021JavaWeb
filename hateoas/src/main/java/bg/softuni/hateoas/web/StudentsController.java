package bg.softuni.hateoas.web;

import bg.softuni.hateoas.Repository.StudentsReposiory;
import bg.softuni.hateoas.model.dto.OrderDTO;
import bg.softuni.hateoas.model.dto.StudentDTO;
import bg.softuni.hateoas.model.entity.OrderEntity;
import bg.softuni.hateoas.model.entity.StudentsEntity;
import bg.softuni.hateoas.model.mapping.StudentMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/students")
public class StudentsController {

    // WARNING: never inject repository HERE IN THE CONTROLLER ! , I USE THIS NOW JUST FOR PRACTISE
    private final StudentsReposiory studentsReposiory;
    private final StudentMapper studentMapper;

    public StudentsController(StudentsReposiory studentsReposiory, StudentMapper studentMapper) {
        this.studentsReposiory = studentsReposiory;
        this.studentMapper = studentMapper;
    }


    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<StudentDTO>>> getStudents() {
        List<EntityModel<StudentDTO>> allStudents = studentsReposiory.findAll()
                .stream()
                .map(st -> studentMapper.mapEntityToDTO(st))
                .map(dto -> EntityModel.of(dto,createStudentsLinks(dto)))
                .collect(Collectors.toList());


        return ResponseEntity.ok(CollectionModel.of(allStudents));

    }

    //ENTITY MODEL IS HATEOAS
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDTO>> getStudentsByID(@PathVariable Long id) {
        StudentDTO studentDTO = studentsReposiory.findById(id)
                .map(studentMapper::mapEntityToDTO)
                .orElseThrow();

        return ResponseEntity.ok(
                EntityModel.of(studentDTO,createStudentsLinks(studentDTO))
        );
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<CollectionModel<EntityModel<OrderDTO>>> getOrders(@PathVariable Long id){
       StudentsEntity studentsEntity = studentsReposiory
                .findById(id)
               .orElseThrow();

       List<EntityModel<OrderDTO>> orders = studentsEntity.getOrders()
               .stream()
               .map(this::map)
               .map(dto -> EntityModel.of(dto))
               .collect(Collectors.toList());

       return ResponseEntity.ok(CollectionModel.of(orders));
    }

    private OrderDTO map(OrderEntity order){
        return  new OrderDTO().setId(order.getId()).setCourseId(order.getCourse().getId()).setStudentId(order.getStudent().getId());
    }


    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDTO>> update(@PathVariable Long id,StudentDTO studentDTO){
        // IMPLEMENTATION NOT IMPORTANT for the demo

        return ResponseEntity.ok().build();
    }

    private Link[] createStudentsLinks(StudentDTO studentDTO){

        List<Link> result = new ArrayList<>();

        Link selfLink = linkTo(methodOn(StudentsController.class).getStudentsByID(studentDTO.getId())).withSelfRel();

        result.add(selfLink);

        Link updateLink = linkTo(methodOn(StudentsController.class)
                .update(studentDTO.getId(),studentDTO)).withRel("update");

        Link orderLink2 = linkTo(methodOn(StudentsController.class)
                .getOrders(studentDTO.getId())).withRel("orders");

        result.add(updateLink);
        result.add(orderLink2);
        // TODO orders

        return result.toArray(new Link[0]);
    }




}
