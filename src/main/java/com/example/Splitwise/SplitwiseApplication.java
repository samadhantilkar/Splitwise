package com.example.Splitwise;

import com.example.Splitwise.controller.UserController;
import com.example.Splitwise.dto.CreateUserRequestDto;
import com.example.Splitwise.dto.CreateUserResponseDto;
import com.example.Splitwise.dto.UpdateUserRepsonseDto;
import com.example.Splitwise.dto.UpdateUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {
	UserController userController;
	@Autowired
	public SplitwiseApplication(UserController userController){
		this.userController=userController;
	}
	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}
	@Override
	public void run(String... args)throws Exception{
		CreateUserRequestDto userRequest=new CreateUserRequestDto();
		userRequest.setName("Samadhan Aasaram Tilkar");
		userRequest.setPhone_Number(9322302497L);
		userRequest.setPassword("samadhan");
		CreateUserResponseDto userResponse= this.userController.createUser(userRequest);
		System.out.println(userResponse.getResponseStatusDto());

		UpdateUserRequestDto updateUser=new UpdateUserRequestDto();
		updateUser.setId(1L);
		updateUser.setPassword("12345678");
		UpdateUserRepsonseDto updateUserRepsonseDto=this.userController.updateUser(updateUser);
		System.out.println(updateUserRepsonseDto.getResponseStatusDto());

	}

}
