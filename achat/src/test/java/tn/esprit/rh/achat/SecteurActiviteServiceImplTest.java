import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecteurActiviteServiceImplTest {

    private SecteurActiviteServiceImpl secteurActiviteService;
    private SecteurActiviteRepository secteurActiviteRepository;

    @BeforeEach
    void setUp() {
        secteurActiviteRepository = new SecteurActiviteRepository(); // Instantiate your repository here
        secteurActiviteService = new SecteurActiviteServiceImpl(secteurActiviteRepository);
    }

    @Test
    void testRetrieveAllSecteurActivite() {
        // Create a sample list of SecteurActivite entities
        List<SecteurActivite> secteurActiviteList = new ArrayList<>();
        SecteurActivite secteurActivite1 = new SecteurActivite();
        secteurActivite1.setIdSecteurActivite(1L);
        secteurActivite1.setCodeSecteurActivite("Code1");
        secteurActivite1.setLibelleSecteurActivite("Libelle1");
        secteurActiviteList.add(secteurActivite1);

        // Mock the repository to return the sample list
        when(secteurActiviteRepository.findAll()).thenReturn(secteurActiviteList);

        // Test the service method
        List<SecteurActivite> result = secteurActiviteService.retrieveAllSecteurActivite();

        // Assert the result
        assertEquals(1, result.size());
        assertEquals("Code1", result.get(0).getCodeSecteurActivite());
        assertEquals("Libelle1", result.get(0).getLibelleSecteurActivite());
    }

    // Other test methods for your service methods

    @Test
    void testAddSecteurActivite() {
        // Create a sample SecteurActivite entity
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setIdSecteurActivite(1L);
        secteurActivite.setCodeSecteurActivite("Code1");
        secteurActivite.setLibelleSecteurActivite("Libelle1");

        // Test the service method
        SecteurActivite result = secteurActiviteService.addSecteurActivite(secteurActivite);

        // Assert the result
        assertEquals(1L, result.getIdSecteurActivite());
        assertEquals("Code1", result.getCodeSecteurActivite());
        assertEquals("Libelle1", result.getLibelleSecteurActivite());
    }

    // Other test methods for your service methods

}
