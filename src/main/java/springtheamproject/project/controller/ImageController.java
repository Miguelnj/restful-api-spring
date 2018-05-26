package springtheamproject.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import springtheamproject.project.service.ImageService;

import java.io.IOException;

@Controller
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()) return new ResponseEntity<>("Image not selected", HttpStatus.OK);

        try{
            imageService.save(file);
        }catch(IOException exception){
            exception.printStackTrace();
            return new ResponseEntity<>("I/O error ocurred", HttpStatus.OK);
        }
        return new ResponseEntity<>("You successfully uploaded " +
                file.getOriginalFilename() + "!", HttpStatus.OK);
    }

}
