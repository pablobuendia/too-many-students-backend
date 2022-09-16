package com.pablobuendia.universitymanager;

import com.pablobuendia.universitymanager.entities.address.Address;
import com.pablobuendia.universitymanager.entities.address.AddressRepository;
import com.pablobuendia.universitymanager.entities.address.city.City;
import com.pablobuendia.universitymanager.entities.address.city.CityRepository;
import com.pablobuendia.universitymanager.entities.address.city.CityRepositoryImpl;
import com.pablobuendia.universitymanager.entities.address.country.Country;
import com.pablobuendia.universitymanager.entities.address.country.CountryRepository;
import com.pablobuendia.universitymanager.entities.course.Course;
import com.pablobuendia.universitymanager.entities.course.CourseInstance;
import com.pablobuendia.universitymanager.entities.course.CourseInstanceRepository;
import com.pablobuendia.universitymanager.entities.course.CourseRepository;
import com.pablobuendia.universitymanager.entities.student.Student;
import com.pablobuendia.universitymanager.entities.student.StudentRepository;
import com.pablobuendia.universitymanager.entities.university.University;
import com.pablobuendia.universitymanager.entities.university.UniversityRepository;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class UniversityManagerApplication implements CommandLineRunner {

  private final StudentRepository studentRepository;
  private final UniversityRepository universityRepository;
  private final AddressRepository addressRepository;
  private final CityRepository cityRepository;
  private final CountryRepository countryRepository;
  private final CityRepositoryImpl cityRepositoryImpl;
  private final CourseRepository courseRepository;
  private final CourseInstanceRepository courseInstanceRepository;

  public static void main(String[] args) {
    SpringApplication.run(UniversityManagerApplication.class, args);
  }

  @Override
  public void run(String... args) {
    log.info("Entering sample data through CommandLineRunner");

    val argentina = createCountry("Argentina");
    countryRepository.save(argentina);
    val buenosAires = new City();
    buenosAires.setName("Buenos Aires");
    buenosAires.setCountry(argentina);
    cityRepository.save(buenosAires);

    val uni = createUniversity("University of Buenos Aires", "Paso 123", buenosAires);
    universityRepository.save(uni);

    val pablo = studentRepository.save(
        createStudent(uni, "Pablo", "Buendia", "DNI", "10100100", null));
    val maria = studentRepository.save(
        createStudent(uni, "Maria", "Rodriguez", "DNI", "20200200", null));
    val juana = studentRepository.save(
        createStudent(uni, "Juana", "Perez", "DNI", "30300300", null));

    val addressPablo = createAddress(pablo, buenosAires, "Belgrano 111");
    val addressMaria = createAddress(maria, buenosAires, "Guemes 111");
    val addressJuana = createAddress(juana, buenosAires, "Paz 111");
    addressRepository.saveAll(List.of(addressPablo, addressMaria, addressJuana));

    val mathCourse = createCourse("Math", 20, "Medicine", 7.0d);
    val physicsCourse = createCourse("Physics", 30, "Physics", 6.0d);

    val mathCourse2022 = createCourseInstance(mathCourse, "Professor Math Guy",
        LocalDate.of(2022, Month.JANUARY, 1));

    val physicsCourse2022 = createCourseInstance(mathCourse, "Professor Physics Guy",
        LocalDate.of(2022, Month.JANUARY, 1));

    pablo.setCourses(List.of(physicsCourse2022, mathCourse2022));
    maria.setCourses(List.of(physicsCourse2022, mathCourse2022));

    pablo.setAddress(addressPablo);
    maria.setAddress(addressMaria);
    juana.setAddress(addressJuana);
    studentRepository.saveAll(List.of(pablo, maria, juana));

    // Try EntityManager save action
    val city = new City();
    city.setName("Salta");
    city.setCountry(argentina);
    cityRepositoryImpl.save(city);
  }

  private University createUniversity(String name, String lineStreet1, City city) {
    University uni = new University();
    uni.setName(name);
    uni.setLineStreet1(lineStreet1);
    uni.setCity(city);
    return uni;
  }

  private Country createCountry(String name) {
    Country country = new Country();
    country.setName(name);
    return country;
  }

  private Student createStudent(University uni, String firstName, String lastName,
      String documentType, String documentNumber, Address address) {
    val student = new Student();
    student.setUniversity(uni);
    student.setFirstName(firstName);
    student.setLastName(lastName);
    student.setDocumentType(documentType);
    student.setDocumentNumber(documentNumber);
    student.setAddress(address);
    return student;
  }

  private Address createAddress(Student owner, City city, String lineStreet1) {
    val addressUni = new Address();
    addressUni.setStudentOwner(owner);
    addressUni.setLineStreet1(lineStreet1);
    addressUni.setCity(city);
    return addressUni;
  }

  private Course createCourse(String name, Integer credits, String degree, Double passingGrade) {
    val course = new Course();
    course.setCredits(credits);
    course.setName(name);
    course.setDegree(degree);
    course.setPassingGrade(passingGrade);
    return courseRepository.save(course);
  }

  private CourseInstance createCourseInstance(Course course, String professorName, LocalDate year) {
    val courseInstance = new CourseInstance();
    courseInstance.setParentCourse(course);
    courseInstance.setProfessorName(professorName);
    courseInstance.setYear(year);
    return courseInstanceRepository.save(courseInstance);
  }

}
