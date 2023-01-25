package me.sky.recipeapp.services;

public interface FilesService {
    boolean saveToFileIngr(String json);

    boolean saveToFileRec(String json);

    String readFromFileIngr();

    String readFromFileRec();

    boolean cleanDataFileIngr();

    boolean cleanDataFileRec();
}
