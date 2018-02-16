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
        pupil.ifPresent(p -> System.out.println("\nFounded pupil by id: \n" + p));

        pupilRepository.deleteById(1);
        System.out.println("\nAll pupils after removing 1:");
        pupilRepository.findAll().forEach(p -> System.out.println(p));

    }

}
