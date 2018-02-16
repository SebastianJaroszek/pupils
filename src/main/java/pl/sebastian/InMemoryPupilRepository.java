package pl.sebastian;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryPupilRepository implements PupilRepository {

    private List<Pupil> allPupils = new ArrayList<>();

    public InMemoryPupilRepository() {
        allPupils.add(new Pupil(1, "Adam", 3, 'A', 30));
        allPupils.add(new Pupil(2, "Kasia", 3, 'B', 4));
        allPupils.add(new Pupil(3, "Damian", 1, 'C', 0));
        allPupils.add(new Pupil(4, "Patrycja", 2, 'D', 16));
        allPupils.add(new Pupil(5, "Krystian", 1, 'C', 9));
    }

    @Override
    public List<Pupil> findAll() {
        return allPupils;
    }

    @Override
    public List<Pupil> findByClassLetterAndClassNumber(char classLetter, int classNumber) {
        return allPupils.stream()
                .filter(pupil -> pupil.getClassNumber() == classNumber && pupil.getClassLetter() == classLetter)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Pupil> findById(int id) {

        /*allPupils.stream()
                .filter(pupil -> pupil.getId() == id);*/
        Optional<Pupil> optional = Optional.empty();
        for (Pupil pupil : allPupils){
            if (pupil.getId() == id){
                optional = Optional.of(pupil);
            }
        }
        return optional;
    }

    @Override
    public void deleteById(int id) {
        Optional<Pupil> pupilToDelete = findById(id);
        if (pupilToDelete.isPresent()) {
            allPupils.remove(pupilToDelete.get());
        } else {
            //TODO wygeneruj komunikat w HTML
        }
    }
}
