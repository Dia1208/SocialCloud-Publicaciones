package com.socialcloud.ms_publicaciones.Controller;

import com.socialcloud.ms_publicaciones.Dto.PublicacionRequest;
import com.socialcloud.ms_publicaciones.Dto.PublicacionResponse;
import com.socialcloud.ms_publicaciones.Service.PublicacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
@RequiredArgsConstructor
public class PublicacionController {

    private final PublicacionService publicacionService;

    @PostMapping
    public PublicacionResponse crear(
            @Valid @RequestBody PublicacionRequest request) {

        return publicacionService.crear(request);
    }

    @GetMapping
    public List<PublicacionResponse> listar() {

        return publicacionService.listar();
    }

    @GetMapping("/{id}")
    public PublicacionResponse buscarPorId(@PathVariable Long id) {

        return publicacionService.buscarPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<PublicacionResponse> listarPorUsuario(
            @PathVariable Long usuarioId) {

        return publicacionService.listarPorUsuario(usuarioId);
    }

    @PutMapping("/{id}")
    public PublicacionResponse actualizar(
            @PathVariable Long id,
            @Valid @RequestBody PublicacionRequest request) {

        return publicacionService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {

        publicacionService.eliminar(id);
        return "Publicación eliminada correctamente";
    }
}
