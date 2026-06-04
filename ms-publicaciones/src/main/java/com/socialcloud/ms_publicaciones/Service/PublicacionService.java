package com.socialcloud.ms_publicaciones.Service;

import com.socialcloud.ms_publicaciones.Dto.PublicacionRequest;
import com.socialcloud.ms_publicaciones.Dto.PublicacionResponse;
import com.socialcloud.ms_publicaciones.Entity.Publicacion;
import com.socialcloud.ms_publicaciones.Repository.PublicacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicacionService {

    private final PublicacionRepository publicacionRepository;

    public PublicacionResponse crear(PublicacionRequest request) {

        Publicacion publicacion = Publicacion.builder()
                .usuarioId(request.getUsuarioId())
                .contenido(request.getContenido())
                .fechaCreacion(LocalDateTime.now())
                .build();

        return convertir(publicacionRepository.save(publicacion));
    }

    public List<PublicacionResponse> listar() {

        return publicacionRepository.findAll()
                .stream()
                .map(this::convertir)
                .toList();
    }

    public PublicacionResponse buscarPorId(Long id) {

        Publicacion publicacion = publicacionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Publicación no encontrada"));

        return convertir(publicacion);
    }

    public List<PublicacionResponse> listarPorUsuario(Long usuarioId) {

        return publicacionRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(this::convertir)
                .toList();
    }

    public PublicacionResponse actualizar(Long id,
                                          PublicacionRequest request) {

        Publicacion publicacion = publicacionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Publicación no encontrada"));

        publicacion.setUsuarioId(request.getUsuarioId());
        publicacion.setContenido(request.getContenido());

        return convertir(publicacionRepository.save(publicacion));
    }

    public void eliminar(Long id) {

        if (!publicacionRepository.existsById(id)) {
            throw new RuntimeException("Publicación no encontrada");
        }

        publicacionRepository.deleteById(id);
    }

    private PublicacionResponse convertir(Publicacion publicacion) {

        return PublicacionResponse.builder()
                .id(publicacion.getId())
                .usuarioId(publicacion.getUsuarioId())
                .contenido(publicacion.getContenido())
                .fechaCreacion(publicacion.getFechaCreacion())
                .build();
    }
}
