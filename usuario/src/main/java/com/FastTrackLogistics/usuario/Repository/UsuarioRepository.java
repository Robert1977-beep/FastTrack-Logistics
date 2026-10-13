package com.FastTrackLogistics.usuario.Repository;

import com.FastTrackLogistics.usuario.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}