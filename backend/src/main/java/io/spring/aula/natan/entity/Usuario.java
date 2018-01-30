/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
package io.spring.aula.natan.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
@Document
public class Usuario {
	
	@Id
	private String id;

    private String nome;
    
    @DBRef
    private List<Perfil> perfis;

    private int idade;

    private String email;
    
    private String senha;
    
    public Usuario() {
    	
    }
    
    public Usuario(String nome, List<Perfil> perfis, String email, String senha) {
    	this.nome = nome;
    	this.perfis = perfis;
    	this.email = email;
    	this.senha = senha;
    }
    

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
