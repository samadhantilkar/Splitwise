package com.example.Splitwise.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRegistry {
//    private RegisterUserCommand registerUserCommand;
    @Autowired
    public CommandRegistry(RegisterUserCommand registerUserCommand,
                           UpdateUserCommand updateUserCommand){
        commands.add(registerUserCommand);
        commands.add(updateUserCommand);
    }

    private List<Command> commands=new ArrayList<>();

    public boolean registerCommand(Command command){
        if(commands.contains(command)){
            return false;
        }
        commands.add(command);
        return true;
    }

    public boolean unregister(Command command){
        if (!commands.contains(command)) {
            return false;
        }
        commands.remove(command);
        return true;
    }

    public void execute(String input) throws Exception  {
        for(Command command:commands){
            if(command.canExecute(input)){
                command.execute(input);
                return;
            }
        }
    }


}
