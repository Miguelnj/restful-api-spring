package springtheamproject.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    public void save(MultipartFile file) throws IOException {
        byte[] fileBytes = file.getBytes();
        Path dataPath = Paths.get("./src/main/resources/images/".concat(file.getOriginalFilename()));
        Files.write(dataPath, fileBytes);

    }
}
