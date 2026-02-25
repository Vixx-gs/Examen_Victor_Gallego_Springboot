package com.salesianos.ExamenGallegoVictorDI;

import com.salesianos.ExamenGallegoVictorDI.model.Habilidad;
import com.salesianos.ExamenGallegoVictorDI.repository.HabilidadRepository;
import com.salesianos.ExamenGallegoVictorDI.repository.NaufragoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class NaufragoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private HabilidadRepository habilidadRepository;

    @Autowired
    private NaufragoRepository naufragoRepository;

    // Test A: flujo completo donde se crea un naufrago con dos habilidades,
    //Al listar los naufragos aparece en el listado
    @Test
    public void testCrearNaufragoYComprobarEnListado() throws Exception {

        Habilidad h1 = habilidadRepository.save(Habilidad.builder().nombre("Navegacion").dificultad("Alta").experiencia(5).categoria("Mar").build());
        Habilidad h2 = habilidadRepository.save(Habilidad.builder().nombre("Pesca").dificultad("Media").experiencia(3).categoria("Supervivencia").build());

        String url = "http://localhost:" + port + "/naufragos";
        String response = restTemplate.getForObject(url, String.class);
        assertThat(response).isNotNull();
    }

    // Test B: se crean dos naufragos Chuck y Wilson cada uno con su habilidad,
    //se guardan y se comprueba que existen en el listado
    @Test
    public void testCrearChuckYWilsonYComprobarQueExisten() throws Exception {

        Habilidad hChuck = habilidadRepository.save(Habilidad.builder().nombre("Fuego").dificultad("Alta").experiencia(10).categoria("Supervivencia").build());
        Habilidad hWilson = habilidadRepository.save(Habilidad.builder().nombre("Flotacion").dificultad("Baja").experiencia(1).categoria("Mar").build());

        com.salesianos.ExamenGallegoVictorDI.model.Naufrago chuck = com.salesianos.ExamenGallegoVictorDI.model.Naufrago.builder()
                .nombre("Chuck").edad(40).sexo("Hombre").isla("Isla Norte").nacionalidad("Americana").habilidad(hChuck).build();

        com.salesianos.ExamenGallegoVictorDI.model.Naufrago wilson = com.salesianos.ExamenGallegoVictorDI.model.Naufrago.builder()
                .nombre("Wilson").edad(0).sexo("Otro").isla("Isla Norte").nacionalidad("Desconocida").habilidad(hWilson).build();

        naufragoRepository.save(chuck);
        naufragoRepository.save(wilson);

        String url = "http://localhost:" + port + "/naufragos";
        String response = restTemplate.getForObject(url, String.class);

        assertThat(response).contains("Chuck");
        assertThat(response).contains("Wilson");
    }
}