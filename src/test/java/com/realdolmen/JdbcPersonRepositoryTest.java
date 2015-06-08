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
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    @Test (expected = RepositoryException.class)
    public void testWhatIfIdDoesNotExistForFind(){
        PersonRepository repository = new JdbcPersonRepository();
        assertNotNull(repository.find(3));

    }

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
    public void testFindPersonAddress (){
        PersonRepository repository = new JdbcPersonRepository();
        assertEquals("BakerStreet", repository.find(1).getAddress().getStreet());
        assertEquals("25",repository.find(1).getAddress().getNumber());

    }

    @Test
    public  void testFindPersonCity (){
        PersonRepository repository = new JdbcPersonRepository();
        assertEquals("London",repository.find(1).getAddress().getCity().getName());
    }

    @Test
    public void testAddingPerson (){

    }

}

