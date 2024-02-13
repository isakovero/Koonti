package laskin;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExtraTest extends AbstractParent {

    private static Laskin laskin;
    private final double DELTA = 0.001;

    @BeforeAll
    public static void setUp() {
        System.out.println("@BeforeAll Virta ON (ennen ensimmäistä testiä)");
        laskin = new Laskin();
        laskin.virtaON();
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("@AfterAll Virta OFF (kaikki testit ajettu).");
        laskin.virtaOFF();
        laskin = null;
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("  Nollaa laskin.");
        laskin.nollaa();
        assertEquals(0, laskin.annaTulos(), "Nollaus ei onnistunut");
    }

    @Test
    public void testNelio2() {
        laskin.nelio(2);
        assertEquals(4, laskin.annaTulos(), "Luvun 2 Neliöön korotus väärin");
    }

    @Test
    public void testNelio4() {
        laskin.nelio(4);
        assertEquals(16, laskin.annaTulos(), "Luvun 4 neliöön korotus väärin");
    }

    @Test
    public void testNelio5() {
        laskin.nelio(5);
        assertEquals(25, laskin.annaTulos(), DELTA, "Luvun 5 neliöön korotus väärin");
    }

    @Test
    public void testNeliojuuri2() {
        laskin.neliojuuri(2);
        assertEquals((int) Math.sqrt(2), laskin.annaTulos(), "Luvun 2 neliöjuuri väärin");
    }

    @Test
    @DisplayName("Testaa negatiivinen neliöjuuri")
    public void testNeliojuuriNegat() {
        assertThrows(IllegalArgumentException.class, () -> laskin.neliojuuri(-2), "Negatiivisen luvun neliöjuuri ei heittänyt oikeaa poikkeusta");
    }


}