package com.pablobuendia.universitymanager;

import com.pablobuendia.universitymanager.address.Address;
import com.pablobuendia.universitymanager.address.AddressRepository;
import com.pablobuendia.universitymanager.address.city.City;
import com.pablobuendia.universitymanager.address.city.CityRepository;
import com.pablobuendia.universitymanager.address.country.Country;
import com.pablobuendia.universitymanager.address.country.CountryRepository;
import com.pablobuendia.universitymanager.commons.BaseEntity;
import com.pablobuendia.universitymanager.student.Student;
import com.pablobuendia.universitymanager.student.StudentRepository;
import com.pablobuendia.universitymanager.university.University;
import com.pablobuendia.universitymanager.university.UniversityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class UniversityManagerApplication implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(UniversityManagerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Entering sample data through CommandLineRunner");

        val uni = createUniversity("University of Buenos Aires");
        universityRepository.save(uni);

        val argentina = createCountry("Argentina");
        countryRepository.save(argentina);
        val buenosAires = new City();
        buenosAires.setName("Buenos Aires");
        buenosAires.setCountry(argentina);
        cityRepository.save(buenosAires);

        final Address addressUni = createAddress(uni, buenosAires, "Rivadavia 111");
        addressRepository.save(addressUni);

        val pablo = studentRepository.save(createStudent(uni, "Pablo", "Buendia"));
        val maria = studentRepository.save(createStudent(uni, "Maria", "Rodriguez"));
        val juana = studentRepository.save(createStudent(uni, "Juana", "Perez"));

        val addressPablo = createAddress(pablo, buenosAires, "Belgrano 111");
        val addressMaria = createAddress(maria, buenosAires, "Guemes 111");
        val addressJuana = createAddress(juana, buenosAires, "Paz 111");
        addressRepository.saveAll(List.of(addressPablo, addressMaria, addressJuana));
    }

    private University createUniversity(String name) {
        University uni = new University();
        uni.setName(name);
        return uni;
    }

    private Country createCountry(String name) {
        Country country = new Country();
        country.setName(name);
        return country;
    }

    private Student createStudent(University uni, String firstName, String lastName) {
        val student = new Student();
        student.setUniversity(uni);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        return student;
    }

    private Address createAddress(BaseEntity owner, City city, String lineStreet1) {
        val addressUni = new Address();
        addressUni.setLineStreet1(lineStreet1);
        addressUni.setCity(city);
        return addressUni;
    }


}
