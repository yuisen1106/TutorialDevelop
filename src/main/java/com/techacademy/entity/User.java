package com.techacademy.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="user")

public class User {

	/**性別用の列挙型*/
	public static enum Gender{
		男性,女性
	}

	/**主キー、　自動生成*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**名前　20桁　null不許可*/
	@Column(length=20, nullable =false)
	@NotEmpty
	@Length(max=20)
	private String name;

	/**性別　2桁　列挙型（文字列）*/
	@Column(length=2)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Gender gender;

	/**年齢*/
	@Min(0)
	@Max(120)
	private Integer age;


	/**メールアドレス　50桁　null許可*/
	@Column(length=50)
	@Email
	@Length(max=50)
	private String email;

}
