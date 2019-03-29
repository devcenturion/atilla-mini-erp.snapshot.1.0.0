package net.centurion.atilla.atillaminierp.service.interfaces;


import net.centurion.atilla.atillaminierp.service.implementations.ActionService;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

public class IActionServiceTest{

    @Autowired
    private static ActionService actionService;

    @BeforeClass
    public static void setUpBeforeClass ( ) throws Exception {
        actionService = new ActionService();
    }

    @AfterClass
    public static void tearDownAfterClass ( ) throws Exception {
    }

    @Test
    public void save ( ) {
    }

    @Test
    public void listAction ( ) {
    }

    @Test
    public void listAction1 ( ) {
    }

    @Test
    public void delete ( ) {
    }

    @Test
    public void delete1 ( ) {
    }

    @Test
    public void search ( ) {
    }

    @Before
    public void setUp ( ) throws Exception {
    }

    @After
    public void tearDown ( ) throws Exception {
    }
}
