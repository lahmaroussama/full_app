import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class SecteurActiviteServiceImplTest {

    @InjectMocks
    private SecteurActiviteServiceImpl secteurActiviteService;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllSecteurActivite() {
        // Create a sample list of SecteurActivite entities
        List<SecteurActivite> secteurActiviteList = new ArrayList<>();
        SecteurActivite secteurActivite1 = new SecteurActivite();
        secteurActivite1.setIdSecteurActivite(1L);
        secteurActivite1.setCodeSecteurActivite("Code1");
        secteurActivite1.setLibelleSecteurActivite("Libelle1");
        secteurActiviteList.add(secteurActivite1);

        // Mock the repository to return the sample list
        Mockito.when(secteurActiviteRepository.findAll()).thenReturn(secteurActiviteList);

        // Test the service method
        List<SecteurActivite> result = secteurActiviteService.retrieveAllSecteurActivite();

        // Assert the result
        assertEquals(1, result.size());
        assertEquals("Code1", result.get(0).getCodeSecteurActivite());
        assertEquals("Libelle1", result.get(0).getLibelleSecteurActivite());
    }

    @Test
    public void testAddSecteurActivite() {
        // Create a sample SecteurActivite entity
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setIdSecteurActivite(1L);
        secteurActivite.setCodeSecteurActivite("Code1");
        secteurActivite.setLibelleSecteurActivite("Libelle1");

        // Mock the repository to save the entity
        Mockito.when(secteurActiviteRepository.save(any(SecteurActivite.class))).thenReturn(secteurActivite);

        // Test the service method
        SecteurActivite result = secteurActiviteService.addSecteurActivite(secteurActivite);

        // Assert the result
        assertEquals(1L, result.getIdSecteurActivite());
        assertEquals("Code1", result.getCodeSecteurActivite());
        assertEquals("Libelle1", result.getLibelleSecteurActivite());
    }

    @Test
    public void testDeleteSecteurActivite() {
        // Mock the repository to delete an entity by ID
        Mockito.doNothing().when(secteurActiviteRepository).deleteById(1L);

        // Test the service method
        secteurActiviteService.deleteSecteurActivite(1L);

        // Verify that the delete method was called once with the correct ID
        Mockito.verify(secteurActiviteRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateSecteurActivite() {
        // Create a sample SecteurActivite entity
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setIdSecteurActivite(1L);
        secteurActivite.setCodeSecteurActivite("Code1");
        secteurActivite.setLibelleSecteurActivite("Libelle1");

        // Mock the repository to save the entity
        Mockito.when(secteurActiviteRepository.save(any(SecteurActivite.class))).thenReturn(secteurActivite);

        // Test the service method
        SecteurActivite result = secteurActiviteService.updateSecteurActivite(secteurActivite);

        // Assert the result
        assertEquals(1L, result.getIdSecteurActivite());
        assertEquals("Code1", result.getCodeSecteurActivite());
        assertEquals("Libelle1", result.getLibelleSecteurActivite());
    }

    @Test
    public void testRetrieveSecteurActivite() {
        // Create a sample SecteurActivite entity
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setIdSecteurActivite(1L);
        secteurActivite.setCodeSecteurActivite("Code1");
        secteurActivite.setLibelleSecteurActivite("Libelle1");

        // Mock the repository to return the entity by ID
        Mockito.when(secteurActiviteRepository.findById(1L)).thenReturn(Optional.of(secteurActivite));

        // Test the service method
        SecteurActivite result = secteurActiviteService.retrieveSecteurActivite(1L);

        // Assert the result
        assertEquals(1L, result.getIdSecteurActivite());
        assertEquals("Code1", result.getCodeSecteurActivite());
        assertEquals("Libelle1", result.getLibelleSecteurActivite());
    }
}
