package br.unitins.topicos1.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario extends DefaultEntity {

    private String nome;
    private String email;
    private String login;
    private String senha;
    //@Enumerated(EnumType.ORDINAL)
    private Perfil perfil;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="usuario_telefone",
        joinColumns= @JoinColumn(name="id_usuario"),
        inverseJoinColumns = @JoinColumn(name="id_telefone") )
    private List<Telefone> agenda;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public List<Telefone> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<Telefone> Agenda) {
        this.agenda = Agenda;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}