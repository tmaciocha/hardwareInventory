package pl.tm.hardwareinventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tm.hardwareinventory.model.MyFile;
import pl.tm.hardwareinventory.repository.MyFileRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaMyFileImpl implements MyFileService{
    private final MyFileRepository myFileRepository;


    @Override
    public MyFile findById(long id) {
        return myFileRepository.getById(id);
    }

    @Override
    public List<MyFile> findAll() {
        return myFileRepository.findAll();
    }

    @Override
    public void save(MyFile myFile) {
        myFileRepository.save(myFile);
    }

    @Override
    public void update(MyFile myFile) {
        myFileRepository.save(myFile);
    }
}
