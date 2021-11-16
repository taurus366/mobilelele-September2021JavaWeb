package bg.softuni.cloudinary.web;

import bg.softuni.cloudinary.model.binding.PictureBindingModel;
import bg.softuni.cloudinary.model.entity.PictureEntity;
import bg.softuni.cloudinary.model.repository.PictureRepository;
import bg.softuni.cloudinary.model.view.PictureViewModel;
import bg.softuni.cloudinary.service.CloudinaryImage;
import bg.softuni.cloudinary.service.CloudinaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PicturesController {

    private final CloudinaryService cloudinaryService;

    // Don't inject repository directly here(Controller) !
    // I inject it here because of don't have much time !
    private final PictureRepository pictureRepository;

    public PicturesController(CloudinaryService cloudinaryService, PictureRepository pictureRepository) {
        this.cloudinaryService = cloudinaryService;
        this.pictureRepository = pictureRepository;
    }


    @GetMapping("/pictures/add")
    public String addPicture(){

        return "add";
    }

    @PostMapping("/pictures/add")
    public String addPicture(PictureBindingModel bindingModel) throws IOException {
        //todo

        PictureEntity pictureEntity = createPictureEntity(bindingModel.getPicture(), bindingModel.getTitle());

        pictureRepository.save(pictureEntity);
        return "redirect:/pictures/all";
    }

    private PictureEntity createPictureEntity (MultipartFile file, String title) throws IOException {
        CloudinaryImage upload = cloudinaryService.upload(file);

        return new PictureEntity()
                .setPublicId(upload.getPublicId())
                .setTitle(title)
                .setUrl(upload.getUrl())
;    }

    @GetMapping("/pictures/all")
    public String picturesAll(Model model){
        //todo - all



      List<PictureViewModel> pictures = pictureRepository
                .findAll()
                .stream()
                .map(this::asViewModel)
                        .collect(Collectors.toList());

        model
                .addAttribute("pictures",pictures);

        return "all";
    }

    private PictureViewModel asViewModel(PictureEntity picture){
        return new PictureViewModel()
                .setPublicID(picture.getPublicId())
                .setTitle(picture.getTitle())
                .setUrl(picture.getUrl());
    }

    @Transactional
    @DeleteMapping("/pictures/delete")
    public String delete(@RequestParam("public_id") String publicId){
       if ( cloudinaryService.delete(publicId)){
           pictureRepository.deleteAllByPublicId(publicId);
       }
       return "redirect:/pictures/all";
    }
}
