package me.sky.recipeapp.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FilesService {
    @Value("${path.to.data.file}")
    private String dataFilePath;
    @Value("${name.of.ingredients.data.file}")
    private String dataIngrFileName;
    @Value("${name.of.recipe.data.file}")
    private String dataRecFileName;

    @Override
    public boolean saveToFileIngr(String json) {
        try {
            cleanDataFileIngr();
            Files.writeString(Path.of(dataFilePath, dataIngrFileName), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean saveToFileRec(String json) {
        try {
            cleanDataFileRec();
            Files.writeString(Path.of(dataFilePath, dataRecFileName), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public String readFromFileIngr() {
        try {
            return Files.readString(Path.of(dataFilePath, dataIngrFileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public String readFromFileRec() {
        try {
            return Files.readString(Path.of(dataFilePath, dataRecFileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public File getDataIngrFile() {
        return new File(dataFilePath + "/" + dataIngrFileName);
    }

    @Override
    public File getDataRecFile() {
        return new File(dataFilePath + "/" + dataRecFileName);
    }

    @Override
    public Path createTempFile(String suffix) {
        try {
            return Files.createTempFile(Path.of(dataFilePath), "tempFile", suffix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean cleanDataFileIngr() {
        try {
            Path path = Path.of(dataFilePath, dataIngrFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean cleanDataFileRec() {
        try {
            Path path = Path.of(dataFilePath, dataRecFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
