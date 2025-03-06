package com.example.restapi;

import com.registrorecetas.model.Receta;
import com.registrorecetas.service.RecetaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class  recetaServiceApplicationTests {

    @Mock
    private RecetaService recetaService;

    private recetaServiceApplicationTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerTodasLasRecetas() {
        Receta receta1 = new Receta(1L, "Pasta", "Ingredientes de la pasta", "Instrucciones");
        Receta receta2 = new Receta(2L, "Pizza", "Ingredientes de la pizza", "Instrucciones");
        List<Receta> recetasMock = Arrays.asList(receta1, receta2);

        when(recetaService.obtenerTodasLasRecetas()).thenReturn(recetasMock);

        List<Receta> recetas = recetaService.obtenerTodasLasRecetas();
        assertNotNull(recetas);
        assertEquals(2, recetas.size());
        verify(recetaService, times(1)).obtenerTodasLasRecetas();
    }}
