package teplyy.taras.olgaglass.tool;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Service
public class FileTool {

    private String metaInfo; // добавив виправленн червоного

    public String saveFile(String image, String directory) throws IOException { //провірка коду по файлу мета інфо
        Path pathToDirectory = getPathToDirectory(directory);

        String[] data = image.split(Constants.COMMA);
        String mateInfo = data[0];
        String base64File = data[1];

        String fileName = createFileName(getFileExtensionFromMetaInfo(metaInfo)); //private String metaInfo; // добавив виправленн червоного

        Files.write(Paths.get(pathToDirectory.toString(), fileName), Base64.getDecoder().decode(base64File.getBytes())
        );
        return fileName;
    }

    private Path getPathToDirectory(String directory) throws IOException {
        Path path = Paths.get(System.getProperty(Constants.USER_HOME), directory);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        return path;
    }

    private String getFileExtensionFromMetaInfo(String metaInfo) {
        return metaInfo.split(Constants.SLASH)[1].split(Constants.SEMICOLON)[0];
    }

    private String createFileName(String fileExtension) {
        String fileName = UUID.randomUUID().toString();
        return String.format(Constants.FULL_IMAGE_NAME_FORMAT, fileName, fileExtension);

    }

}
