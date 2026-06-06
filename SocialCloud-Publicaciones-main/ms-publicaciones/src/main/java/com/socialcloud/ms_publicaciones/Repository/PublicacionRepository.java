package com.socialcloud.ms_publicaciones.Repository;

import com.socialcloud.ms_publicaciones.Entity.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

    List<Publicacion> findByUsuarioId(Long usuarioId);

}
