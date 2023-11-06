package tn.esprit.rh.achat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecteurActiviteServiceImplTest {

    public SecteurActiviteServiceImpl secteurActiviteService;
    public SecteurActiviteRepository secteurActiviteRepository;

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

}
