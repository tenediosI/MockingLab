package Structure;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.spy;

class LoadConfigTest {

    LoadConfig loadConfig = new LoadConfig();

    @Test
    void populatePropertyData() {
    	 Scanner mockScanner = mock(Scanner.class);
         when(mockScanner.hasNextLine()).thenReturn(true).thenReturn(true).thenReturn(false);
         loadConfig.setPropertyReader(mockScanner);
         loadConfig.populatePropertyData();
         assertEquals(true, loadConfig.propertyData.size() >= 2);
    }


    @Test
    void getConfig() {
    	 Scanner mockScanner = mock(Scanner.class);
         when(mockScanner.hasNextLine()).thenReturn(true).thenReturn(true).thenReturn(false);
         loadConfig.setPropertyReader(mockScanner);
         assertEquals(true, loadConfig.getConfig().size() >= 2);
    }
}