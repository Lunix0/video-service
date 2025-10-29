package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import ma.xproce.CalculatriceAire;
import ma.xproce.Cercle;

import ma.xproce.Rectangle;
import ma.xproce.IForme;

import org.mockito.Mockito;
import static org.mockito.Mockito.*;

class CalculatriceAireTest {

    @Test
    void testAireAvecMock() {
        IForme carre = Mockito.mock(IForme.class);
        when(carre.aire()).thenReturn(4.0);

        List<IForme> formes = Arrays.asList(
                new Cercle(2.0),
                new Rectangle(2, 4),
                carre
        );

        assertEquals(24.56, CalculatriceAire.aire(formes), 0.01);
        verify(carre, times(1)).aire();
    }
}
