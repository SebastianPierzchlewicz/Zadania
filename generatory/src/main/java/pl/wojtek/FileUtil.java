package pl.wojtek;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.source.util.Plugin;
import lombok.Getter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileUtil {
    @Getter
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();



    public static void save(String name, Object object) {
        final File file = new File(System.getProperty("user.dir") + "\\generatory\\src\\main\\resources", name+".gson");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(gson.toJson(object));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
