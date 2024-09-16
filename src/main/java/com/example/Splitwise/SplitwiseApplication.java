package com.example.Splitwise;

import com.example.Splitwise.commands.CommandRegistry;
import com.example.Splitwise.controller.GroupController;
import com.example.Splitwise.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {
	UserController userController;
	GroupController groupController;
	@Autowired
	CommandRegistry commandRegistry;
	@Autowired
	public SplitwiseApplication(UserController userController,
								GroupController groupController){
		this.userController=userController;
		this.groupController=groupController;
	}
	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}
//	@Override
//	public void run(String... args)throws Exception{
//		CreateUserRequestDto userRequest=new CreateUserRequestDto();
//		userRequest.setName("Samadhan Aasaram Tilkar");
//		userRequest.setPhone_Number(9322302497L);
//		userRequest.setPassword("samadhan");
//		CreateUserResponseDto userResponse= this.userController.registerUser(userRequest);
//		System.out.println(userResponse.getResponseStatusDto());
//
//		UpdateUserRequestDto updateUser=new UpdateUserRequestDto();
//		updateUser.setId(1L);
//		updateUser.setPassword("12345678");
//		UpdateUserRepsonseDto updateUserRepsonseDto=this.userController.updateProfile(updateUser);
//		System.out.println(updateUserRepsonseDto.getResponseStatusDto());
//
//		CreateGroupRequestDto createGroup=new CreateGroupRequestDto();
//		createGroup.setName("Goa");
//		createGroup.setCreatedBy(1L);
//		createGroup.setParticipants(List.of(1L));
//
//		CreateUserResponseDto createUserResponseDto= groupController.createGroup(createGroup);
//		System.out.println(createUserResponseDto.getResponseStatusDto());
//
//		UpdateGroupRequestDto updateGroupRequestDto=new UpdateGroupRequestDto();
//		updateGroupRequestDto.setName("Bengalore");
//		updateGroupRequestDto.setUserid(1L);

//		UpdateGroupResponesDto updateGroupResponesDto=groupController.updateGroup(updateGroupRequestDto);
//
//
//	}
	public void run(String[] args) throws Exception{
		Scanner scanner=new Scanner(System.in);
		while(true){
			String input=scanner.nextLine();
			commandRegistry.execute(input);
		}
	}

}
