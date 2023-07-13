package ch.zli.m223.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.type.LocalDateTimeType;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.model.Booking;
import ch.zli.m223.model.Category;
import ch.zli.m223.model.CoworkingSpace;
import ch.zli.m223.model.Entry;
import ch.zli.m223.model.Tag;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.runtime.StartupEvent;

@IfBuildProfile("dev")
@ApplicationScoped
public class TestDataService {

  @Inject
  EntityManager entityManager;

  @Transactional
  void generateTestData(@Observes StartupEvent event) {
    // ApplicationUsers
    var applicationUserMaxWeber = new ApplicationUser("Max", "Weber", "Max.Weber@gmail.com", "mWeber", "123456789", 0);
    var applicationUserAnnaSchmidt = new ApplicationUser("Anna", "Schmidt", "Anna.Schmidt@gmail.com", "DieVoZH", "8004", 1);
    var applicationUserMarkusMueller = new ApplicationUser("Markus", "Mueller", "Markus.Mueller@gmail.com", "M&M", "2004", 2);

    // CoworkingSpace
    var coworkingSpaceTheWarRoom = new CoworkingSpace("TheWarRoom", "Bukarest");
    var coworkingSpaceTopGLounge = new CoworkingSpace("TopGLounge", "Zurich");
    var coworkingSpaceTJKKonkAGOffice = new CoworkingSpace("TJK Konk AG Office", "Schwyz, Schweiz");

    // Booking
    LocalDateTime startDateOne = LocalDateTime.of(2023, 7, 13, 13, 0, 0);
    LocalDateTime endDateOne = LocalDateTime.of(2023, 7, 13, 14, 0, 0);
    var BookingOne = new Booking(applicationUserMaxWeber, coworkingSpaceTopGLounge, startDateOne, endDateOne, 0);

    LocalDateTime startDateTwo = LocalDateTime.of(2023, 6, 13, 13, 0, 0);
    LocalDateTime endDateTwo = LocalDateTime.of(2023, 6, 13, 14, 0, 0);
    var BookingTwo = new Booking(applicationUserAnnaSchmidt, coworkingSpaceTJKKonkAGOffice, startDateTwo, endDateTwo, 1);

    LocalDateTime startDateThree = LocalDateTime.of(2023, 7, 12, 13, 0, 0);
    LocalDateTime endDateThree = LocalDateTime.of(2023, 7, 12, 14, 0, 0);
    var BookingThree = new Booking(applicationUserMarkusMueller, coworkingSpaceTheWarRoom, startDateThree, endDateThree, 2);


    
    // Categories
    var projectACategory = new Category();
    projectACategory.setTitle("Project A");
    entityManager.persist(projectACategory);

    var projectBCategory = new Category();
    projectBCategory.setTitle("Project B");
    entityManager.persist(projectBCategory);

    var projectCCategory = new Category();
    projectCCategory.setTitle("Project C");
    entityManager.persist(projectCCategory);

    // Tags
    var programmingTag = new Tag();
    programmingTag.setTitle("Programming");
    entityManager.persist(programmingTag);

    var debuggingTag = new Tag();
    debuggingTag.setTitle("Debugging");
    entityManager.persist(debuggingTag);

    var meetingTag = new Tag();
    meetingTag.setTitle("Meeting");
    entityManager.persist(meetingTag);

    // Entries
    var firstEntry = new Entry();
    firstEntry.setCategory(projectACategory);
    firstEntry.setTags(new HashSet<>(Arrays.asList(programmingTag, debuggingTag)));
    firstEntry.setCheckIn(LocalDateTime.now().minusHours(3));
    firstEntry.setCheckOut(LocalDateTime.now().minusHours(2));
    entityManager.persist(firstEntry);

    var secondEntry = new Entry();
    secondEntry.setCategory(projectACategory);
    secondEntry.setTags(new HashSet<>(Arrays.asList(meetingTag)));
    secondEntry.setCheckIn(LocalDateTime.now().minusHours(2));
    secondEntry.setCheckOut(LocalDateTime.now().minusHours(1));
    entityManager.persist(secondEntry);

    var thirdEntry = new Entry();
    thirdEntry.setCategory(projectBCategory);
    thirdEntry.setTags(new HashSet<>(Arrays.asList(programmingTag)));
    thirdEntry.setCheckIn(LocalDateTime.now().minusHours(1));
    thirdEntry.setCheckOut(LocalDateTime.now());
    entityManager.persist(thirdEntry);
  }
}
