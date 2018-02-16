package pl.sebastian;

import java.util.Optional;

public class PupilRepositoryTest {

    public static void main(String[] args) {
        PupilRepository pupilRepository = new InMemoryPupilRepository();
        System.out.println("All pupils:");
        pupilRepository.findAll().forEach(pupil -> System.out.println(pupil));

        System.out.println("\nFounded pupils by class:");
        pupilRepository.findByClassLetterAndClassNumber('C', 1).forEach(pupil -> System.out.println(pupil));


        Optional<Pupil> pupil = pupilRepository.findById(3);
        /*if (pupil.isPresent()) {
            System.out.println("\nFounded pupil by id: \n" + pupil.get());
        }*/

        pupil.ifPresent(p -> System.out.println("\nFounded pupil by id: \n" + p));

    }

}
