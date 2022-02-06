package pl.tm.hardwareinventory.service;

import pl.tm.hardwareinventory.model.MyFile;

import java.util.List;

public interface MyFileService {

    MyFile findById(long id);

    List<MyFile> findAll();

    void save (MyFile myFile);

    void update(MyFile myFile);
}
