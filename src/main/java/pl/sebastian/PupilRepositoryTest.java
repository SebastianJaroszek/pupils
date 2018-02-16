package pl.sebastian;

public class PupilRepositoryTest {

    public static void main(String[] args) {
        PupilRepository pupilRepository = new InMemoryPupilRepository();
        System.out.println("All pupils:");
        pupilRepository.findAll().forEach(pupil -> System.out.println(pupil));
    }

}
