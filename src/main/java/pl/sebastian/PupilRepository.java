package pl.sebastian;

import java.util.List;
import java.util.Optional;

public interface PupilRepository {

    List<Pupil> findAll();
    List<Pupil> findByClassLetterAndClassNumber(char classLetter, int classNumber);
    Optional<Pupil> findById(int id);
    void deleteById(int id);
}
