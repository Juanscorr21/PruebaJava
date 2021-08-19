package com.prueba.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

	@Id
	private Long id;
	@NotBlank(message = "El nombre es obligatorio")
	@Column(name = "name", nullable = false, length = 40)
	private String name;
	@NotBlank(message = "Los apellidos son obligatorios")
	@Column(name = "user_lastname", nullable = false, length = 40)
	private String lastname;
	@NotBlank(message = "El telefono es obligatorio")
	@Column(name = "user_phone",length = 20)
	private String phone;
	@NotEmpty(message = "El nombre de usuario es obligatorio y no puede ser null")
	@Column(name = "userName",length = 15)
	private String userName;
	@NotEmpty(message = "La contraseña es obligatoria y no puede ser null")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,70}$", message = "La contraseña debe tener minimo 8 , al menos un dígito,una minúscula y una mayúscula.\r\n" + 
			 "Puede tener otros símbolos adicionales")
	@Column(name = "user_Password")
	private String password;
	
}
