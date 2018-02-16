package pl.sebastian;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryPupilRepository implements PupilRepository {

    private List<Pupil> allPupils = new ArrayList<>();

    @Override
    public List<Pupil> findAll() {
        return null;
    }

    @Override
    public List<Pupil> findByClassLetterAndClassNumber(char classLetter, int classNumber) {
        return null;
    }

    @Override
    public Optional<Pupil> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(int id) {

    }
}
