package tn.esprit.rh.achat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FactureTest {
    @Mock
    private FactureRepository factureRepository;
    @InjectMocks
    private FactureServiceImpl service;


    @Test
    public void addFactureTest() {
        Facture facture = new Facture();

        facture.setMontantFacture(150);
        when(factureRepository.save(facture)).thenReturn(facture);
        assertNotNull(service.addFacture(facture));
    }

    @Test
    public void retrieveAllFacturesTest() {

        Facture facture1 = new Facture();
        Facture facture2 = new Facture();
        Facture facture3 = new Facture();

        List<Facture> factures = Arrays.asList(facture1, facture2, facture3);
        when(factureRepository.findAll()).thenReturn(factures);
        List<Facture> retrievedFactures = service.retrieveAllFactures();
        assertEquals(factures, retrievedFactures);
    }

    @Test
    public void testCancelFacture() {
        Long factureId = 1L;

        // Create a sample Facture object
        Facture facture = new Facture();
        facture.setIdFacture(factureId);
        facture.setArchivee(false);

        when(factureRepository.findById(factureId)).thenReturn(Optional.of(facture));
        service.cancelFacture(factureId);
        /// assertTrue(facture.getArchivee());
        verify(factureRepository, times(1)).save(facture);
    }
    @Test
    public void retrieveFactureTest() {

        Facture expectedFacture = new Facture();
        when(factureRepository.findById(1L)).thenReturn(java.util.Optional.of(expectedFacture));
        Facture retrievedFacture = service.retrieveFacture(1L);
        assertEquals(expectedFacture, retrievedFacture);
    }
}
