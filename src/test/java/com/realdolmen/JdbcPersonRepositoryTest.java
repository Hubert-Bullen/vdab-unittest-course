package com.realdolmen;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

/**
 * Created by Hyuberuto on 05/06/15.
 */
public class JdbcPersonRepositoryTest {
    @Rule
    public ExpectedException expector = ExpectedException.none(); // Als we heel specifiek dingen willen opvragen over de expected exception.


    @Before
    public void initializeDataSets() throws Exception{
        //1. Create DBUnit connection
        Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Test-DBUnit", "root", "");

        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

        //2. Load dataset "people.xml" (create it first!)
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File("people.xml"));

        //3. execute CLEAN_INSERT operation using 1 and 2
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);

    }

    @Test
    public void testFindPersonById(){
    //4. prepare "fixture" for PersonRepository.
        PersonRepository repository = new JdbcPersonRepository();
        Person test1 = repository.find(2);
        assertEquals("Janis", test1.getFirstName());
        assertEquals("Joplin", test1.getLastName());

    }

    @Test
    public void testNoPersonByThatId(){
        PersonRepository repository = new JdbcPersonRepository();
        assertNull(repository.find(3));

    }

    /*@Test (expected = RepositoryException.class)
    public void testWhatIfIdDoesNotExistForFind(){
        PersonRepository repository = new JdbcPersonRepository();
        assertNull(repository.find(3));

    }*/

    @Test
    public void testRemovingPerson(){ // Not by Id!!
        expector.expectMessage("Unable to remove person"); // In tegenstelling tot assert, moet dit VOOR alles te doen.
        expector.expect(RepositoryException.class);

        PersonRepository repository = new JdbcPersonRepository();
        Person test1 = repository.find(1);
        repository.remove(test1);
        repository.remove(test1);

    }

    @Test
    public void testFindPersonAddress(){
        PersonRepository repository = new JdbcPersonRepository();
        assertEquals("BakerStreet", repository.find(1).getAddress().getStreet());
        assertEquals("25",repository.find(1).getAddress().getNumber());

    }

    @Test
    public  void testFindPersonCity(){
        PersonRepository repository = new JdbcPersonRepository();
        assertEquals("London",repository.find(1).getAddress().getCity().getName());
    }

    @Test
    public void testAddingPerson(){
        PersonRepository repository = new JdbcPersonRepository();
        Person p1 = new Person("Luke", "Skywalker", new Date(1999,20,9,12,36), new Address ("HututBlock", "24", new City("4589-B","Tattooine")));
        repository.save(p1);
        assertEquals("Luke", repository.find(p1.getId()).getFirstName()); // TODO We kunnen niet op Id zoeken sinds de id een random generated one is. Check hoe Generated Keys werken.
        // Logischerwijze zou het 3 zijn, maar omdat de random genertadkeys neit resetten gaat dit na elke test omhoog.

    }
}

