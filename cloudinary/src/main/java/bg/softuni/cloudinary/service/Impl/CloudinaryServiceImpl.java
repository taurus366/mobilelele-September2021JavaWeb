package bg.softuni.cloudinary.service.Impl;

import bg.softuni.cloudinary.service.CloudinaryImage;
import bg.softuni.cloudinary.service.CloudinaryService;
import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    private static final String TEMP_FILE = "temp-file";
    private static final String URL = "url";
    private static final String PUBLIC_ID = "public_id";
    private final Cloudinary cloudinary;


    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }


    @Override
    public CloudinaryImage upload(MultipartFile file) throws IOException {
        File tempFile = File.createTempFile(TEMP_FILE,file.getOriginalFilename());
        file.transferTo(tempFile);
try {

    Map<String, String> uploadResult = cloudinary
            .uploader()
            .upload(tempFile, Map.of());

    String url = uploadResult.getOrDefault(URL, "https://i.pinimg.com/originals/fd/78/c4/fd78c47f2a009df65b5b5a46f4437399.png");
    String publicId = uploadResult.getOrDefault(PUBLIC_ID, "");

    return new CloudinaryImage()
            .setPublicId(publicId)
            .setUrl(url);
}
finally {
    tempFile.delete();
}

    }

    @Override
    public boolean delete(String publicId) {
        try {
            this.cloudinary
                    .uploader()
                    .destroy(publicId,Map.of());
        } catch (IOException e) {
           return false;
        }
        return true;
    }
}
