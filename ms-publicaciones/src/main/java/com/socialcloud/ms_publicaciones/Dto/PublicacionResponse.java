package com.socialcloud.ms_publicaciones.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class PublicacionResponse {

    private Long id;
    private Long usuarioId;
    private String contenido;
    private LocalDateTime fechaCreacion;
}
