package com.crud.es.model.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClienteDto implements Serializable {

    private int id_cliente;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fecha_registro;
}
