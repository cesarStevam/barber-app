package com.app.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.app.entity.Rol;
import com.app.app.repository.RolRepository;

@Service("rolService")
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public List<Rol> getRoles() {
        return rolRepository.findAll();
    }

    public void saveOrUpdate(Rol rol) {
        rolRepository.save(rol);

    }

    public Optional<Rol> getRolById(Long idRol) {
        return rolRepository.findById(idRol);
    }

    public Rol obtenerRolPorId(Long idRol) {
        Optional<Rol> rol = rolRepository.findById(idRol);
        return rol.orElseThrow(() -> new IllegalArgumentException("Rol no encontrado con id: " + idRol));
    }
    public void eliminarRol(Long idRol) {
        if (rolRepository.existsById(idRol)) {
            rolRepository.deleteById(idRol);
        }
    }

}
