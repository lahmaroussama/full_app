package tn.esprit.rh.achat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.Mockito;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
//import tn.esprit.rh.achat.entities.SecteurActivite;
//import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;

import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
//import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;

import tn.esprit.rh.achat.services.FournisseurServiceImpl;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FourTest {


    @InjectMocks
    FournisseurServiceImpl fournisseurService;

    @Mock
    FournisseurRepository fournisseurRepository;
   // @Mock
    //private SecteurActiviteRepository secteurActiviteRepository;


    @Mock
    DetailFournisseurRepository detailfournisseurRepository;




        @Test
        public void testRetrieveAllFournisseurs() {
        // Create a list of sample Fournisseurs
        List<Fournisseur> sampleFournisseurs = new ArrayList<>();
        sampleFournisseurs.add(new Fournisseur());
        sampleFournisseurs.add(new Fournisseur());

        // Mock the findAll method of the repository to return the sampleFournisseurs
        when(fournisseurRepository.findAll()).thenReturn(sampleFournisseurs);

        // Call the retrieveAllFournisseurs method
        List<Fournisseur> retrievedFournisseurs = fournisseurService.retrieveAllFournisseurs();

        // Verify that findAll method was called on the repository
        verify(fournisseurRepository).findAll();

        // Verify that the returned list is the same as the sampleFournisseurs
        assertEquals(sampleFournisseurs, retrievedFournisseurs);
    }


    @Test
    public void testAddFournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        DetailFournisseur detailFournisseur = new DetailFournisseur();
        fournisseur.setCode("anas");
        detailFournisseur.setEmail("anaso@gmail.com");
        // Stubbing behavior for the mock objects
        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        Fournisseur result = fournisseurService.addFournisseur(fournisseur);

        // Verify that the save method was called with the expected arguments
        verify(fournisseurRepository).save(fournisseur);

        // Assert that the result is as expected
        assertEquals(fournisseur, result);

        // You can also add more assertions based on your specific requirements
    }



    @Test
    public void testUpdateFournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        DetailFournisseur detailFournisseur = new DetailFournisseur();
        fournisseur.setCode("laam");
        detailFournisseur.setEmail("laami@gmail.com");
        // Stubbing behavior for the mock objects
        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        Fournisseur result = fournisseurService.addFournisseur(fournisseur);

        // Verify that the save method was called with the expected arguments
        verify(fournisseurRepository).save(fournisseur);

        // Assert that the result is as expected
        assertEquals(fournisseur, result);
        assertNotNull(result);
        // You can also add more assertions based on your specific requirements
        assertEquals("laam",result.getCode());
    }



        @Test
        public void testDeleteFournisseur() {
            // Arrange
            Long fournisseurId = 1L;

            // Act
            fournisseurService.deleteFournisseur(fournisseurId);

            // Assert
            verify(fournisseurRepository).deleteById(fournisseurId);
        }

        @Test
       public void testRetrieveFournisseur() {
        // Define the ID of the fournisseur to retrieve
        Long fournisseurId = 1L;

        // Create a sample Fournisseur
        Fournisseur sampleFournisseur = new Fournisseur();
        sampleFournisseur.setCode("laamiri");

        // Mock the findById method of the repository to return the sampleFournisseur
        when(fournisseurRepository.findById(fournisseurId)).thenReturn(Optional.of(sampleFournisseur));

        // Call the retrieveFournisseur method
        Fournisseur retrievedFournisseur = fournisseurService.retrieveFournisseur(fournisseurId);

        // Verify that findById method was called on the repository with the correct ID
        verify(fournisseurRepository).findById(fournisseurId);

        // Verify that the returned Fournisseur is the same as the sampleFournisseur
        assertEquals(sampleFournisseur, retrievedFournisseur);
    }


  /*  @Test
    public void testAssignSecteurActiviteToFournisseur() {
        // Define IDs for SecteurActivite and Fournisseur
        Long idSecteurActivite = 1L;
        Long idFournisseur = 2L;

        // Create sample SecteurActivite and Fournisseur
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setLibelleSecteurActivite("informatique");

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setCode("olala");

        // Mock the findById methods of the repositories to return the sample objects
        when(fournisseurRepository.findById(idFournisseur)).thenReturn(Optional.of(fournisseur));
        when(secteurActiviteRepository.findById(idSecteurActivite)).thenReturn(Optional.of(secteurActivite));

        // Call the assignSecteurActiviteToFournisseur method
        fournisseurService.assignSecteurActiviteToFournisseur(idSecteurActivite, idFournisseur);
        // Verify that findById methods were called on the repositories with the correct IDs
        verify(fournisseurRepository).findById(idFournisseur);
        verify(secteurActiviteRepository).findById(idSecteurActivite);

        // Verify that the SecteurActivite was added to the Fournisseur
        assertTrue(fournisseur.getSecteurActivites().contains(secteurActivite));

        // Verify that save method was called on the fournisseurRepository
        verify(fournisseurRepository).save(fournisseur);
    }*/
    }


