package iths.not3book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Spring Boot Web Application built with Maven. Uses Lombok to reduce the amount of code and make more readable.
 *
 * Projects purpose is to store users in a database and set up suitable relations between them for a relational database.
 * The users will consist of authors and subscribers whom will have different access-level to the application.
 *
 * Is set up for PostgreSQL and uses Spring Data JPA to interact with the database.
 * Project has four entities(Excluding Authority) with service layer and controller layer for each entity,
 * in order for authenticated users to interact with the database.
 * {@link iths.not3book.author.Author}
 * {@link iths.not3book.subscriber.Subscriber}
 * {@link iths.not3book.document.Document}
 * {@link iths.not3book.contactinfo.ContactInformation}
 *
 * Has simple Spring Security implementation that stores user credentials in a database by using {@link org.springframework.security.provisioning.JdbcUserDetailsManager}
 * and limits user actions with the help of:
 * {@link iths.not3book.authorities.Authority}
 * {@link iths.not3book.security.UserManagementConfig}
 * {@link iths.not3book.security.WebAuthorizationConfig}
 *
 * Some customized exception handling has been implemented where an ErrorResponse-object
 * containing information about the error is sent back with the response.
 * {@link iths.not3book.exception.GlobalExceptionHandler}
 * {@link iths.not3book.exception.ResourceNotFoundException}
 * {@link iths.not3book.exception.ErrorResponse}
 *
 * 'httprequests'-folder located in the projects source folder contains some http-files
 * with request to test the functionality of the different classes and methods.
 * @author Petter Bergström
 */
@SpringBootApplication
public class Not3bookApplication {

	public static void main(String[] args) {
		SpringApplication.run(Not3bookApplication.class, args);
	}
}
