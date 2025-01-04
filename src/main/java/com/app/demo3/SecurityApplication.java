package com.app.demo3;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.demo3.persistence.entity.PermissionEntity;
import com.app.demo3.persistence.entity.RoleEntity;
import com.app.demo3.persistence.entity.RoleEnum;
import com.app.demo3.persistence.entity.UserEntity;
import com.app.demo3.persistence.repository.UserRepository;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			/* Crate Permissions */
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();

			/* Create Roles */
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();
			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(createPermission, readPermission))
					.build();
			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionList(Set.of(readPermission))
					.build();
			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission,
							refactorPermission))
					.build();

			/* Create Users */
			UserEntity userRomel = UserEntity.builder()
					.username("Romel")
					.password("$2a$10$FI3pi7Bw0Wb/sSdc5J3K/u/zmYLvVcsKEOrt2D3LF99S0JEoPeYIW")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userJuan = UserEntity.builder()
					.username("Juan")
					.password("$2a$10$FI3pi7Bw0Wb/sSdc5J3K/u/zmYLvVcsKEOrt2D3LF99S0JEoPeYIW")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userAndrea = UserEntity.builder()
					.username("Andrea")
					.password("$2a$10$FI3pi7Bw0Wb/sSdc5J3K/u/zmYLvVcsKEOrt2D3LF99S0JEoPeYIW")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			UserEntity userAnyi = UserEntity.builder()
					.username("Anyi")
					.password("$2a$10$FI3pi7Bw0Wb/sSdc5J3K/u/zmYLvVcsKEOrt2D3LF99S0JEoPeYIW")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userRomel, userJuan, userAndrea, userAnyi));
		};
	}

}
