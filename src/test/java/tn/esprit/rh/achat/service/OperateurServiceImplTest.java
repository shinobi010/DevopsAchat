package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OperateurServiceImplTest {
    @Autowired
    OperateurServiceImpl os;
    @Test
    @Order(1)
    public void retrieveAllOperateursTest() {
        List<Operateur> operateurList = os.retrieveAllOperateurs();
        Assertions.assertEquals(1, operateurList.size());
    }

}
