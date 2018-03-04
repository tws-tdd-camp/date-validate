import org.junit.*;

import static org.junit.Assert.*;

public class AssertionDemo {

    @Test
    void basic() {
        assertEquals(1 + 1, 2);
        assertEquals("message", 1 + 1, 2);
        assertFalse(1 > 2);
        assertTrue(1 < 2);
        assertNull(null);
        assertNotNull(this);
        assertSame("foo", "foo");
        assertEquals("foo", "foo");
        assertArrayEquals(new int[] {1, 2, 3}, new int[] {1, 2, 3});
    }

    @BeforeClass
    static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterClass
    static void afterAll() {
        System.out.println("After All");
    }

    @Before
    void beforeEach() {
        System.out.println("Before Each");
    }

    @After
    void afterEach() {
        System.out.println("After Each");
    }

};