package com.tg.saveu.service;

import com.tg.saveu.entity.Usuario;
import com.tg.saveu.exception.EmailUniqueViolationException;
import com.tg.saveu.exception.EntityNotFoundException;
import com.tg.saveu.exception.PasswordInvalidException;
import com.tg.saveu.repository.UsuarioRepository;
import com.tg.saveu.exception.EmailInvalidException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    // IMPLEMENTAR TRATAMENTO DE ERROS
    @Transactional
    public Usuario salvar(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new EmailUniqueViolationException(String.format("E-mail %s já cadastrado", usuario.getEmail()));
        }
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuário id = %s não encontrado", id))
        );
    }

    @Transactional
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
        if (!novaSenha.equals(confirmaSenha)) {
            throw new PasswordInvalidException("Nova senha não confere com confirmação de senha.");
        }

        Usuario user = buscarPorId(id);
        if (!user.getPassword().equals(senhaAtual)) {
            throw new PasswordInvalidException("Senha incorreta.");
        }
        user.setPassword(novaSenha);
        return user;
    }

    @Transactional
    public Usuario editarNome(Long id, String novoNome, String senha) {
        Usuario user = buscarPorId(id);
        if (!user.getPassword().equals(senha)) {
            throw new PasswordInvalidException("Senha incorreta.");
        }
        user.setName(novoNome);
        return user;
    }

    @Transactional
    public Usuario editarEmail(Long id, String novoEmail, String confirmaEmail, String senha) {
        if (!novoEmail.equals(confirmaEmail)) {
            throw new EmailInvalidException("Os e-mails não coincidem.");
        }

        Usuario user = buscarPorId(id);
        if (!user.getPassword().equals(senha)) {
            throw new PasswordInvalidException("Senha incorreta.");
        }
        user.setEmail(novoEmail);
        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}
