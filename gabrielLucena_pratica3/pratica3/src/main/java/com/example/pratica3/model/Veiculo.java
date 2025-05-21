package com.example.pratica3.model;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="veiculos")
public class Veiculo {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private BigDecimal valor;

    public Veiculo(){
        this.modelo = "";
        this.valor = 0;
    }

    public Veiculo(String modelo, BigDecimal valor){
        this.modelo = modelo;
        this.valor = valor;
    }
    
    public Long getId() {
        return id;
    }
    public String getModelo() {
        return modelo;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
}
