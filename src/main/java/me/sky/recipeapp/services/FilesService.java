package me.sky.recipeapp.services;

import java.io.File;

public interface FilesService {
    boolean saveToFileIngr(String json);

    boolean saveToFileRec(String json);

    String readFromFileIngr();

    String readFromFileRec();

    File getDataIngrFile();

    File getDataRecFile();

    boolean cleanDataFileIngr();

    boolean cleanDataFileRec();
}
