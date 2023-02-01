package me.sky.recipeapp.services;

import java.io.File;
import java.nio.file.Path;

public interface FilesService {
    boolean saveToFileIngr(String json);

    boolean saveToFileRec(String json);

    String readFromFileIngr();

    String readFromFileRec();

    File getDataIngrFile();

    File getDataRecFile();

    Path createTempFile(String suffix);

    boolean cleanDataFileIngr();

    boolean cleanDataFileRec();
}
